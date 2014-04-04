package edu.wpi.cs.team9.planningpoker;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.wpi.cs.wpisuitetng.network.Request;
import edu.wpi.cs.wpisuitetng.network.RequestObserver;
import edu.wpi.cs.wpisuitetng.network.models.IRequest;
import edu.wpi.cs.wpisuitetng.network.models.ResponseModel;

public class LoginActivity extends Activity {
	
	private static final String TAG = LoginActivity.class.getSimpleName();

	private EditText usernameText;
	private EditText passwordText;
	private EditText projectText;
	private EditText serverText;
	
	private TextView errorView;
	
	private Button loginButton;
	
	private SharedPreferences prefs;
	
	private RequestObserver projectObserver = new RequestObserver() {
		
		@Override
		public void responseSuccess(IRequest iReq) {
			ResponseModel response = ((Request)iReq).getResponse();
			if (response.getStatusCode() == 200) {
				LoginController.projectSelectSuccessful(response);
				Log.d(TAG, "Project Select Success!");
				setError("");
				
				prefs.edit()
					.putString("project", projectText.getText().toString())
				.commit();
			} else {
				setError(String.format("Error %d: %s", response.getStatusCode(), response.getStatusMessage()));
				Log.e(TAG, "Project Select Failed " + response.getStatusCode());
			}
		}
		
		@Override
		public void responseError(IRequest iReq) {
			ResponseModel response = ((Request)iReq).getResponse();
			if (iReq.getResponse().getStatusCode() == 403) {
				setError("Incorrect username, password or project.");

			} else {
				setError(String.format("Error %d: %s", response.getStatusCode(), response.getStatusMessage()));
				Log.e(TAG, "Project Select Failed " + response.getStatusCode());			
			}			
		}
		
		@Override
		public void fail(IRequest iReq, Exception exception) {
			setError("Unable to complete request: "+exception.getMessage());
			Log.e(TAG, exception.getMessage());			
		}
	};
	
	private RequestObserver loginObserver = new RequestObserver() {
		
		@Override
		public void responseSuccess(IRequest iReq) {			
		ResponseModel response = ((Request)iReq).getResponse();
			if (response.getStatusCode() == 200) {
				LoginController.loginSuccessful(response, projectText.getText().toString(), projectObserver);
				setError("");	
								
				prefs.edit()
					.putString("username", usernameText.getText().toString())
					.putString("password", passwordText.getText().toString())
					.putString("server", serverText.getText().toString())
				.commit();
				
			} else {
				setError(String.format("Error %d: %s", response.getStatusCode(), response.getStatusMessage()));
				Log.e(TAG, "Login Failed " + response.getStatusCode()); 
			}
		}
		
		@Override
		public void responseError(IRequest iReq) {
			ResponseModel response = ((Request)iReq).getResponse();
			if (iReq.getResponse().getStatusCode() == 403) {
				setError("Incorrect username, password or project.");
				Log.e(TAG, "Incorrect username, password or project.");

			} else {
				setError(String.format("Error %d: %s", response.getStatusCode(), response.getStatusMessage()));
				Log.e(TAG, "Login Failed " + response.getStatusCode());
			}
			
		}
		
		@Override
		public void fail(IRequest iReq, Exception exception) {
			setError("Unable to complete request: "+exception.getMessage());
			Log.e(TAG, exception.getMessage());	
		}
	};
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		usernameText = (EditText)findViewById(R.id.usernameField);
		passwordText = (EditText)findViewById(R.id.passwordField);
		projectText = (EditText)findViewById(R.id.projectField);
		serverText = (EditText)findViewById(R.id.serverField);
		
		usernameText.setText(prefs.getString("username", ""));
		passwordText.setText(prefs.getString("password", ""));
		projectText.setText(prefs.getString("project", ""));
		serverText.setText(prefs.getString("server", ""));
		
		errorView = (TextView)findViewById(R.id.error);
		errorView.setText("");
		
		loginButton = (Button)findViewById(R.id.login);
		loginButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "User: "+usernameText.getText().toString());
				Log.d(TAG, "Pass: "+passwordText.getText().toString());
				Log.d(TAG, "Proj: "+projectText.getText().toString());
				Log.d(TAG, "Serv: "+serverText.getText().toString());
				LoginController.sendLoginRequest(
						usernameText.getText().toString(),
						passwordText.getText().toString(),
						serverText.getText().toString(),
						loginObserver);				
			}
		});
		
		
	}
	
	private void setError(final String error){
		runOnUiThread(new Runnable() {			
			@Override
			public void run() {
				errorView.setText(error);				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
