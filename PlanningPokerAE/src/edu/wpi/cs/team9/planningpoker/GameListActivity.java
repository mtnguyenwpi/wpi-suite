package edu.wpi.cs.team9.planningpoker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ListView;
import edu.wpi.cs.team9.planningpoker.controller.GetGamesController;
import edu.wpi.cs.team9.planningpoker.controller.GetGamesController.GetGamesObserver;
import edu.wpi.cs.team9.planningpoker.model.GameModel;
import edu.wpi.cs.team9.planningpoker.view.GameListAdapter;

public class GameListActivity extends Activity implements GetGamesObserver {

	private static final String TAG = GameListActivity.class.getSimpleName();

	private ExpandableListView gameListView;
	private GameListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_game_list);

		gameListView = (ExpandableListView) findViewById(R.id.gameList);
		adapter = new GameListAdapter(this);
		gameListView.setAdapter(adapter);

		setProgressBarIndeterminateVisibility(true);
		GetGamesController.getInstance().setObserver(this);
		GetGamesController.getInstance().requestGames();
	}

	@Override
	public void receivedGames(final GameModel[] games) {
		
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Log.d(TAG, "reveivedGames()");
				adapter.clear();
				for (GameModel game : games) {
					adapter.add(game);
				}
				adapter.notifyDataSetChanged();
				setProgressBarIndeterminateVisibility(false);
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_refresh:
			setProgressBarIndeterminateVisibility(true);
			GetGamesController.getInstance().requestGames();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_list, menu);
		return true;
	}

}
