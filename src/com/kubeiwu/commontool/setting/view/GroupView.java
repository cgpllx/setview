package com.kubeiwu.commontool.setting.view;

import java.util.LinkedList;

import android.content.Context;
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

	private void initGroupView() {
		setOrientation(VERTICAL);
		setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
		setDividerPadding(2);
		LayoutParams l = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		setPadding(0, 20, 0, 0);
		setLayoutParams(l);
	}

	public SparseArray<LinkedList<RowView>> getRowViewArray() {
		return mRowViewArray;
	}

	public void addrowViewArray(SparseArray<LinkedList<RowView>> rowViewArray) {
		if (rowViewArray != null && rowViewArray.size() > 0) {
			for (int i = 0; i < rowViewArray.size(); i++) {
				this.mRowViewArray.put(rowViewArray.keyAt(i), rowViewArray.valueAt(i));
			}
		}

		// this.rowViewArray.
	}

	public void setRowViewArray(SparseArray<LinkedList<RowView>> rowViewArray) {
		this.mRowViewArray = rowViewArray;
	}

	public void addAllRowView(int order, LinkedList<RowView> rowViewlinkedlist) {
		LinkedList<RowView> entry = mRowViewArray.get(order, new LinkedList<RowView>());
		entry.addAll(rowViewlinkedlist);
		mRowViewArray.put(order, rowViewlinkedlist);
	}

	public void addRowView(int order, RowView rowView) {
		LinkedList<RowView> linkedList = mRowViewArray.get(order, new LinkedList<RowView>());
		linkedList.addLast(rowView);
		mRowViewArray.put(order, linkedList);
	}

	@Override
	public void setDividerDrawable(Drawable divider) {
		super.setDividerDrawable(divider);
	}

	public void notifyDataChanged() {
		if (mRowViewArray != null && mRowViewArray.size() > 0) {
			for (int i = 0; i < mRowViewArray.size(); i++) {
				LinkedList<RowView> lists = mRowViewArray.valueAt(i);
				for (RowView rowView : lists) {
					addView(rowView);
					rowView.notifyDataChanged();
				}
			}
		} else {
			setVisibility(View.GONE);
		}
	}

	SparseArray<LinkedList<RowView>> mRowViewArray = new SparseArray<LinkedList<RowView>>();

	
	//在GroupView中添加GroupView
	public void addGroupView(GroupView entry) {
		SparseArray<LinkedList<RowView>> value = entry.getRowViewArray();// 传进来的值
		for (int i = 0; i < value.size(); i++) {
			LinkedList<RowView> deliverylinked = value.valueAt(i);
			LinkedList<RowView> linked = mRowViewArray.valueAt(i);
			if (linked == null) {
				mRowViewArray.put(value.keyAt(i), deliverylinked);
			} else {
				linked.addAll(deliverylinked);
			}
		}
	}
}
