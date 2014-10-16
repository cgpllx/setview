package com.kubeiwu.commontool.setting.view;

import java.util.ArrayList;

import com.kubeiwu.commontool.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
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
		setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
		setDividerPadding(2);
//		setDividerDrawable(getResources().getDrawable(R.drawable.divider));
//		setBackgroundResource(R.drawable.groupviewbg1);
		LayoutParams l = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		// setPadding(1, 1, 1, 1);
		// l.setMargins(2, 2, 2, 2);
		setLayoutParams(l);
		// setBackgroundColor(Color.RED);
	}

	private ArrayList<RowView> rowViews = new ArrayList<>();

	public void addAllRowView(ArrayList<RowView> rowViews) {
		this.rowViews.addAll(rowViews);
		notifyDataChanged();

	}

	@Override
	public void setDividerDrawable(Drawable divider) {

		super.setDividerDrawable(divider);
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
