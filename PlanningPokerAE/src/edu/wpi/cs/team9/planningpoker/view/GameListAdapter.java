package edu.wpi.cs.team9.planningpoker.view;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.wpi.cs.team9.planningpoker.R;
import edu.wpi.cs.team9.planningpoker.model.GameModel;

public class GameListAdapter extends BaseExpandableListAdapter {
	
	private ArrayList<GameModel> games;
	private Context context;

	public GameListAdapter(Context context) {
		super();
		this.context = context;
		games = new ArrayList<GameModel>();		
	}
	
	public void add(GameModel g){
		games.add(g);
	}
	
	public void clear(){
		games.clear();
	}
	
	@Override
	public int getGroupCount() {
		return games.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return games.get(groupPosition).getRequirements().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return games.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return games.get(groupPosition).getRequirements().get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return Integer.parseInt(groupPosition + "" + childPosition);
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int position,boolean expanded, View convertView, ViewGroup parent){
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);		
		View view;
		if(convertView == null){
			view = inflater.inflate(R.layout.game_list_item, null);
		} else {
			view = convertView;
		}
		
		GameModel game = games.get(position);
		ImageView statusView = (ImageView)view.findViewById(R.id.status);	
		TextView nameView = (TextView)view.findViewById(R.id.name);
		
		int icon = (game.isEnded())?R.drawable.ic_status_complete:R.drawable.ic_status_pending;
		
		statusView.setImageResource(icon);
		nameView.setText(game.getName());
		
		return view;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);		
		View view;
		if(convertView == null){
			view = inflater.inflate(R.layout.game_list_requirement_item, null);
		} else {
			view = convertView;
		}
		
		TextView text = (TextView)view.findViewById(R.id.text1);
		text.setText(games.get(groupPosition).getRequirements().get(childPosition).getName());
		
		return view;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}


}
