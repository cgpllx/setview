package com.kubeiwu.commontool.setting.view;

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
	 * 增加一组RowView
	 * 
	 * @param order
	 *            位置
	 * @param rowViewlinkedlist
	 */
	public void addAllRowView(SparseArray<RowView> rowViewArray) {
		if (mRowViewArray == null || mRowViewArray.size() == 0) {
			mRowViewArray = rowViewArray;
		} else {
			for (int i = 0; i < rowViewArray.size(); i++) {
				RowView linked = this.mRowViewArray.valueAt(i);
				RowView deliverylinked = rowViewArray.valueAt(i);
				if (linked == null) {
					mRowViewArray.put(rowViewArray.keyAt(i), deliverylinked);
				} else {
					linked.addRowViewLastNode(deliverylinked);
				}
			}
		}
	}

	/**
	 * 获取当前groupView的子view
	 * 
	 * @return
	 */
	public SparseArray<RowView> getmRowViewArray() {
		return mRowViewArray;
	}

	/**
	 * 增加单个RowView
	 * 
	 * @param order
	 * @param rowView
	 */
	public void addRowView(int order, RowView rowView) {
		RowView entry = this.mRowViewArray.get(order);
		if (entry == null) {
			this.mRowViewArray.put(order, rowView);
		} else {
			entry.addRowViewLastNode(rowView);
		}
	}

	public void notifyDataChanged() {
		if (this.mRowViewArray != null && this.mRowViewArray.size() > 0) {
			RowView rowView = null;
			for (int i = 0; i < this.mRowViewArray.size(); i++) {
				rowView = this.mRowViewArray.valueAt(i);
				addView(rowView);
				while (rowView != null && rowView.hasNext()) {
					rowView = rowView.getNext();
					addView(rowView);
					rowView.notifyDataChanged();
				}
			}
		} else {
			setVisibility(View.GONE);
		}
	}
	private SparseArray<RowView> mRowViewArray = new SparseArray<RowView>();

	// 在GroupView中添加GroupView
	public void addGroupView(GroupView entry) {
		SparseArray<RowView> value = entry.getmRowViewArray();// 传进来的值
		addAllRowView(value);
	}
}
