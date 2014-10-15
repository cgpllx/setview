package com.kubeiwu.commontool.setting.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class GroupView extends LinearLayout {

	public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initGroupView();
	}

	public GroupView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GroupView(Context context) {
		super(context);
		initGroupView();
	}

	private void initGroupView() {
		setOrientation(VERTICAL);
	}

	private ArrayList<RowView> rowViews = new ArrayList<>();

 
	public void addAllRowView(ArrayList<RowView> rowViews) {
		this.rowViews.addAll(rowViews);
	}

	public void notifyDataChanged() {
		
		if (rowViews != null && rowViews.size() > 0) {
			for (RowView rowView : rowViews) {
				addView(rowView);
				rowView.notifyDataChanged();
			}
		} else {
			setVisibility(View.GONE);
		}
	}
}
