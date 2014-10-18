package com.kubeiwu.commontool.setting.view;

import java.util.LinkedList;

import android.content.Context;
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

	/**
	 * 获取当前groupView的子view
	 * 
	 * @return
	 */
	public SparseArray<LinkedList<RowView>> getRowViewArray() {
		return this.mRowViewArray;
	}

	/**
	 * 增加一组RowView
	 * 
	 * @param order
	 *            位置
	 * @param rowViewlinkedlist
	 */
	public void addAllRowView(int order, LinkedList<RowView> rowViewlinkedlist) {
		LinkedList<RowView> entry = this.mRowViewArray.valueAt(order);
		if (entry == null) {
			this.mRowViewArray.put(order, rowViewlinkedlist);
		} else {
			entry.addAll(rowViewlinkedlist);
		}
	}

	/**
	 * 增加单个RowView
	 * 
	 * @param order
	 * @param rowView
	 */
	public void addRowView(int order, RowView rowView) {
		LinkedList<RowView> entry = this.mRowViewArray.valueAt(order);
		if (entry == null) {
			LinkedList<RowView> lists = new LinkedList<RowView>();
			lists.add(rowView);
			this.mRowViewArray.put(order, lists);
		} else {
			entry.addLast(rowView);
		}
	}

	public void notifyDataChanged() {
		if (this.mRowViewArray != null && this.mRowViewArray.size() > 0) {
			for (int i = 0; i < this.mRowViewArray.size(); i++) {
				LinkedList<RowView> lists = this.mRowViewArray.valueAt(i);
				for (RowView rowView : lists) {
					addView(rowView);
					rowView.notifyDataChanged();
				}
			}
		} else {
			setVisibility(View.GONE);
		}
	}

	private SparseArray<LinkedList<RowView>> mRowViewArray = new SparseArray<LinkedList<RowView>>();

	// 在GroupView中添加GroupView
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
