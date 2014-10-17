package com.kubeiwu.commontool.setting.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;

public class ContainerView extends LinearLayout {

	@SuppressLint("NewApi")
	public ContainerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	private void initView() {
		setOrientation(VERTICAL);
		setPadding(10, 10, 10, 10);
	}

	public ContainerView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ContainerView(Context context) {
		super(context);
		initView();
	}
	SparseArray<GroupView> groupViewArray = new SparseArray<>();
	
	public void addAllGroupView(SparseArray<GroupView> groupViewArray) {
		this.groupViewArray=groupViewArray;
		notifyDataChanged();
	}
 

//	private ArrayList<GroupView> groupViews = new ArrayList<>();

	public void notifyDataChanged() {
		
		 if(groupViewArray != null && groupViewArray.size() > 0){
			 for (int i = 0; i < groupViewArray.size(); i++) {
				 GroupView groupView = groupViewArray.valueAt(i);
				 addView(groupView);
				 groupView.notifyDataChanged();
			 }
		 }else{
			 setVisibility(View.GONE);
		 }
		
		
//		if (groupViews != null && groupViews.size() > 0) {
//			for (GroupView groupView : groupViews) {
//				addView(groupView);
//			}
//		} else {
//			setVisibility(View.GONE);
//		}
	}
}
