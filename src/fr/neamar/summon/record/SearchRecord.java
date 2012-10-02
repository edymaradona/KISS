package fr.neamar.summon.record;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import fr.neamar.summon.R;
import fr.neamar.summon.holder.SearchHolder;

public class SearchRecord extends Record {
	public SearchHolder searchHolder;

	public SearchRecord(SearchHolder searchHolder) {
		super();
		this.searchHolder = searchHolder;
	}

	@Override
	public View display(Context context) {
		View v = inflateFromId(context, R.layout.item_search);
		TextView appName = (TextView) v.findViewById(R.id.item_search_text);
		appName.setText(context.getString(R.string.ui_item_search) + " \"" + searchHolder.query
				+ '"');

		return v;
	}

	@Override
	public void launch(Context context) {
		Intent search = new Intent(Intent.ACTION_WEB_SEARCH);  
		search.putExtra(SearchManager.QUERY, searchHolder.query);  
		search.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(search);
	}

}