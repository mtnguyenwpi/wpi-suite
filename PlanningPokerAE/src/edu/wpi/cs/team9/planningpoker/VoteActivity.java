package edu.wpi.cs.team9.planningpoker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import edu.wpi.cs.team9.planningpoker.model.GameRequirementModel;

public class VoteActivity extends Activity {
	
	private TextView nameView;
	private TextView descView;

	private GameRequirementModel requirement;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_vote);
		
		requirement = new Gson().fromJson(getIntent().getExtras().getString("req"), GameRequirementModel.class);
		
		nameView = (TextView)findViewById(R.id.req_name);
		descView = (TextView)findViewById(R.id.req_desc);
		
		nameView.setText(requirement.getName());
		descView.setText(requirement.getDescription());


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vote, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if(id == android.R.id.home){
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
