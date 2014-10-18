package com.kubeiwu.commontool.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;

public class ContainerView extends LinearLayout {

	public ContainerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	private void initView() {
		setOrientation(VERTICAL);
		setPadding(10, 10, 10, 10);
		setScrollbarFadingEnabled(true);
		setScrollContainer(true);
	}

	public ContainerView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ContainerView(Context context) {
		super(context);
		initView();
	}

	public void addAllGroupView(SparseArray<GroupView> groupViewArray) {
		this.mGroupViewArray = groupViewArray;
		notifyDataChanged();
	}

	private SparseArray<GroupView> mGroupViewArray = new SparseArray<GroupView>();

	/**
	 * 增加一条item
	 * 
	 * @param groupId
	 *            组id
	 * @param itemId
	 *            列id
	 * @param order
	 *            循序,1 2 3
	 * @param title
	 * @return
	 */
	public RowView addItem(int groupId, int itemId, int order, String title) {
		RowView rowView = new RowView.Builder(getContext()).setItemId(itemId)//
				.setLable(title).setAction(RowViewActionEnum.My_POSTS).create();
		GroupView groupView = mGroupViewArray.get(groupId);
		if (groupView == null) {
			groupView = new GroupView(getContext());
			mGroupViewArray.put(groupId, groupView);
		}
		groupView.addRowView(order, rowView);
		mGroupViewArray.put(groupId, groupView);

		return rowView;
	};

	/**
	 * 在设置view中增加多组GroupView
	 * 
	 * @param groupViewArray
	 */
	public void addGroupViewArray(SparseArray<GroupView> groupViewArray) {
		if (groupViewArray == null || groupViewArray.size() == 0) {
			this.mGroupViewArray = groupViewArray;
		} else {
			for (int i = 0; i < groupViewArray.size(); i++) {
				// 传进来的key 和value
				int key = groupViewArray.keyAt(i);
				GroupView entry = groupViewArray.valueAt(i);
				// 当前容器中的value
				GroupView groupView = this.mGroupViewArray.get(key);
				if (groupView == null) {// 当前容器中不存在就直接加入
					this.mGroupViewArray.put(key, entry);
				} else {
					groupView.addGroupView(entry);
				}
			}
		}
	}

	/**
	 * 在设置view中增加多组GroupView
	 * 
	 * @param groupViewArray
	 */
	public void addGroupView(int groupId,GroupView groupView) {
		GroupView delivery=this.mGroupViewArray.get(groupId);
		if(delivery==null){
			this.mGroupViewArray.put(groupId, groupView);
		}else{
			delivery.addGroupView(groupView);
		}
		 
	}

	public void commit() {
		notifyDataChanged();
	}

	public void notifyDataChanged() {
		if (mGroupViewArray != null && mGroupViewArray.size() > 0) {
			for (int i = 0; i < mGroupViewArray.size(); i++) {
				GroupView groupView = mGroupViewArray.valueAt(i);
				addView(groupView);
				groupView.notifyDataChanged();
			}
		} else {
			setVisibility(View.GONE);
		}

	}
}
