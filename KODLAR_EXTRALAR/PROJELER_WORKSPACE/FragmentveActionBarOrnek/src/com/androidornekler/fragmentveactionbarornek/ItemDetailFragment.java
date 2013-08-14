package com.androidornekler.fragmentveactionbarornek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidornekler.fragmentveactionbarornek.dummy.DummyContent;

public class ItemDetailFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";

	private DummyContent.DummyItem mItem;

	public ItemDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.content);
		}

		return rootView;
	}
}
