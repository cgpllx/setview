package com.kubeiwu.commontool.setting.view;

import java.util.ArrayList;

import com.kubeiwu.commontool.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
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

	public static GroupView newInstance() {
		return null;
	}

	private void initGroupView() {
		setOrientation(VERTICAL);
		setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
		setDividerPadding(2);
		// setDividerDrawable(getResources().getDrawable(R.drawable.divider));
		// setBackgroundResource(R.drawable.groupviewbg1);
		LayoutParams l = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		setPadding(0, 20, 0, 0);
		// l.setMargins(2, 2, 2, 2);
		setLayoutParams(l);
		// setBackgroundColor(Color.RED);
	}

	// private ArrayList<RowView> rowViews = new ArrayList<>();
	SparseArray<RowView> rowViewArray = new SparseArray<RowView>();

	public void addAllRowView(ArrayList<RowView> rowViews) {
		// this.rowViews.addAll(rowViews);
	}

	public void addRowView(RowView rowView) {
		this.rowViewArray.put(rowView.getItemId(), rowView);
	}

	// public void addRowView(int index, RowView rowViews) {
	// this.rowViews.add(index, rowViews);
	// notifyDataChanged();
	// }

	@Override
	public void setDividerDrawable(Drawable divider) {
		super.setDividerDrawable(divider);
	}

	public void notifyDataChanged() {
		if (rowViewArray != null && rowViewArray.size() > 0) {
			for (int i = 0; i < rowViewArray.size(); i++) {
				RowView rowView = rowViewArray.valueAt(i);
				addView(rowView);
				rowView.notifyDataChanged();
			}
		} else {
			setVisibility(View.GONE);
		}
	}
}
