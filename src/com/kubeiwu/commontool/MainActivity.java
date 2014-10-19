package com.kubeiwu.commontool;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ScrollView;

import com.kubeiwu.commontool.setting.view.KSettingView;
import com.kubeiwu.commontool.setting.view.GroupView;
import com.kubeiwu.commontool.setting.view.RowView;
import com.kubeiwu.commontool.setting.view.RowViewActionEnum;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ScrollView scrollView=new ScrollView(getApplicationContext());
		scrollView.addView(initKSettingView());
		setContentView(scrollView);
		// setContentView(init());
	}
	View initKSettingView() {
		KSettingView containerView = new KSettingView(getApplicationContext());
		// SetViewUtil setViewUtil=new SetViewUtil(containerView);
		RowView rowView1 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setDefaultValue("中国联通").setIconResourceId(R.drawable.qq_icon01).setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView21 = new RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView31 = new RowView.Builder(getBaseContext()).setLable("中国移动3").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView41= new RowView.Builder(getBaseContext()).setLable("中国移动4") .create();
		RowView rowView51 = new RowView.Builder(getBaseContext()).setLable("中国移动5").setDefaultValue("中国联通").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView11 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setIconResourceId(R.drawable.ic_launcher).setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView2 = new RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView3 = new RowView.Builder(getBaseContext()).setLable("中国移动3") .create();
		RowView rowView4 = new RowView.Builder(getBaseContext()).setLable("中国移动4").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView5 = new RowView.Builder(getBaseContext()).setLable("中国移动5").setDefaultValue("中国联通").setAction(RowViewActionEnum.My_POSTS).create();
		
		containerView.addItem(1, 1, rowView1);
		containerView.addItem(2, 1, rowView2);
		containerView.addItem(2, 1, rowView3);
		containerView.addItem(2, 1, rowView4);
		containerView.addItem(3, 2, rowView5);
		containerView.addItem(3, 3, rowView11);
		containerView.addItem(3, 4, rowView21);
		containerView.addItem(3, 6, rowView31);
		containerView.addItem(3, 7, rowView41);
		containerView.addItem(3, 8, rowView51);
		
		containerView.commit();
		return containerView;
	}
	View init3() {
		KSettingView containerView = new KSettingView(getApplicationContext());
		containerView.addItem(1, 10, 1, "中国移动1",R.drawable.ic_launcher);
		containerView.addItem(1, 20, 2, "中国移动2",R.drawable.ic_launcher);
		containerView.addItem(1, 30, 2, "中国移动3",R.drawable.ic_launcher);
		containerView.addItem(1, 40, 2, "中国移动4",R.drawable.ic_launcher);
		containerView.addItem(2, 1, 1, "中国移动5",R.drawable.ic_launcher);
		containerView.addItem(2, 2, 2, "中国移动6",R.drawable.ic_launcher);
		containerView.addItem(2, 3, 3, "中国移动7",R.drawable.ic_launcher);
		containerView.addItem(2, 4, 4, "中国移动8",R.drawable.ic_launcher);
		containerView.addItem(3, 1, 1, "中国移动9",R.drawable.ic_launcher);
		containerView.addItem(3, 2, 2, "中国移动9",R.drawable.ic_launcher);
		containerView.addItem(3, 3, 3, "中国移动9",R.drawable.ic_launcher);
		containerView.addItem(3, 4, 4, "中国移动9",R.drawable.ic_launcher);
		
		
		//------------------------------------------
		RowView rowView1 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setIconResourceId(R.drawable.ic_launcher).setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView21 = new RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView31 = new RowView.Builder(getBaseContext()).setLable("中国移动3").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView41= new RowView.Builder(getBaseContext()).setLable("中国移动4").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView51 = new RowView.Builder(getBaseContext()).setLable("中国移动5").setAction(RowViewActionEnum.My_POSTS).create();
		RowView rowView11 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setIconResourceId(R.drawable.ic_launcher).setAction(RowViewActionEnum.My_POSTS).create();
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
		containerView.addItem(0,0,rowView21);
		containerView.addItem(0,0,rowView31);
		containerView.addItem(0,0,rowView41);
		containerView.addItem(0,0,rowView51);
		containerView.addItem(0,0,rowView11);
		containerView.addGroupView(0, groupView);
		containerView.commit();
		return containerView;
	}
	View init2() {
		KSettingView containerView = new KSettingView(getApplicationContext());
		// SetViewUtil setViewUtil=new SetViewUtil(containerView);
		containerView.addItem(1, 10, 1, "中国移动1",R.drawable.ic_launcher);
		containerView.addItem(1, 20, 2, "中国移动2",R.drawable.ic_launcher);
		containerView.addItem(1, 30, 2, "中国移动3",R.drawable.ic_launcher);
		containerView.addItem(1, 40, 2, "中国移动4",R.drawable.ic_launcher);
		containerView.addItem(2, 1, 1, "中国移动5",R.drawable.ic_launcher);
		containerView.addItem(2, 2, 2, "中国移动6",R.drawable.ic_launcher);
		containerView.addItem(2, 3, 3, "中国移动7",R.drawable.ic_launcher);
		containerView.addItem(2, 4, 4, "中国移动8",R.drawable.ic_launcher);
		containerView.addItem(3, 1, 1, "中国移动9",R.drawable.ic_launcher);
		containerView.addItem(3, 2, 2, "中国移动9",R.drawable.ic_launcher);
		containerView.addItem(3, 3, 3, "中国移动9",R.drawable.ic_launcher);
		containerView.addItem(3, 4, 4, "中国移动9",R.drawable.ic_launcher);
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
		KSettingView containerView = new KSettingView(getApplicationContext());
		containerView.addGroupView(0, groupView);
		containerView.commit();
		return containerView;
	}

 
}
