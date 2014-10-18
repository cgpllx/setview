package com.kubeiwu.commontool;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ScrollView;

import com.kubeiwu.commontool.setting.view.ContainerView;
import com.kubeiwu.commontool.setting.view.GroupView;
import com.kubeiwu.commontool.setting.view.RowView;
import com.kubeiwu.commontool.setting.view.RowViewActionEnum;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ScrollView scrollView=new ScrollView(getApplicationContext());
		scrollView.addView(init3());
		setContentView(scrollView);
		// setContentView(init());
	}
	View init3() {
		ContainerView containerView = new ContainerView(getApplicationContext());
		containerView.addItem(1, 10, 1, "中国移动1");
		containerView.addItem(1, 20, 2, "中国移动2");
		containerView.addItem(1, 30, 2, "中国移动3");
		containerView.addItem(1, 40, 2, "中国移动4");
		containerView.addItem(2, 1, 1, "中国移动5");
		containerView.addItem(2, 2, 2, "中国移动6");
		containerView.addItem(2, 3, 3, "中国移动7");
		containerView.addItem(2, 4, 4, "中国移动8");
		containerView.addItem(3, 1, 1, "中国移动9");
		containerView.addItem(3, 2, 2, "中国移动9");
		containerView.addItem(3, 3, 3, "中国移动9");
		containerView.addItem(3, 4, 4, "中国移动9");
		
		
		//------------------------------------------
		RowView rowView1 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView2 = new RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView3 = new RowView.Builder(getBaseContext()).setLable("中国移动3").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView4 = new RowView.Builder(getBaseContext()).setLable("中国移动4").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView5 = new RowView.Builder(getBaseContext()).setLable("中国移动5").setAction(RowViewActionEnum.My_POSTS).create();
		SparseArray<RowView> lsits = new SparseArray<RowView>();
		lsits.put(1, rowView1);
		lsits.put(2, rowView2);
		lsits.put(3, rowView3);
		lsits.put(4, rowView4);
		lsits.put(5, rowView5);
		GroupView groupView = new GroupView(getApplicationContext());
		groupView.addAllRowView(lsits);
		containerView.addGroupView(0, groupView);
		containerView.commit();
		return containerView;
	}
	View init2() {
		ContainerView containerView = new ContainerView(getApplicationContext());
		// SetViewUtil setViewUtil=new SetViewUtil(containerView);
		containerView.addItem(1, 10, 1, "中国移动1");
		containerView.addItem(1, 20, 2, "中国移动2");
		containerView.addItem(1, 30, 2, "中国移动3");
		containerView.addItem(1, 40, 2, "中国移动4");
		containerView.addItem(2, 1, 1, "中国移动5");
		containerView.addItem(2, 2, 2, "中国移动6");
		containerView.addItem(2, 3, 3, "中国移动7");
		containerView.addItem(2, 4, 4, "中国移动8");
		containerView.addItem(3, 1, 1, "中国移动9");
		containerView.addItem(3, 2, 2, "中国移动9");
		containerView.addItem(3, 3, 3, "中国移动9");
		containerView.addItem(3, 4, 4, "中国移动9");
		containerView.commit();
		return containerView;
	}

	View init() {
		RowView rowView1 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView2 = new RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView3 = new RowView.Builder(getBaseContext()).setLable("中国移动3").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView4 = new RowView.Builder(getBaseContext()).setLable("中国移动4").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView5 = new RowView.Builder(getBaseContext()).setLable("中国移动5").setAction(RowViewActionEnum.My_POSTS).create();
		SparseArray<RowView> lsits = new SparseArray<RowView>();
		lsits.put(1, rowView1);
		lsits.put(2, rowView2);
		lsits.put(3, rowView3);
		lsits.put(4, rowView4);
		lsits.put(5, rowView5);
		GroupView groupView = new GroupView(getApplicationContext());
		groupView.addAllRowView(lsits);
		ContainerView containerView = new ContainerView(getApplicationContext());
		containerView.addGroupView(0, groupView);
		containerView.commit();
		return containerView;
	}

 
}
