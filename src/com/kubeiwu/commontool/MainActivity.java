package com.kubeiwu.commontool;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.kubeiwu.commontool.setting.SetViewUtil;
import com.kubeiwu.commontool.setting.view.ContainerView;
import com.kubeiwu.commontool.setting.view.GroupView;
import com.kubeiwu.commontool.setting.view.RowView;
import com.kubeiwu.commontool.setting.view.RowViewActionEnum;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		RowView rowView1 = new RowView.Builder(getBaseContext()).setLable("中国移动1").setAction(RowViewActionEnum.My_POSTS).create();
//		RowView rowView2 = new RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
//		RowView rowView3 = new RowView.Builder(getBaseContext()).setLable("中国移动3").setAction(RowViewActionEnum.My_POSTS).create();
//		RowView rowView4 = new RowView.Builder(getBaseContext()).setLable("中国移动4").setAction(RowViewActionEnum.My_POSTS).create();
//		RowView rowView5 = new RowView.Builder(getBaseContext()).setLable("中国移动5").setAction(RowViewActionEnum.My_POSTS).create();
//		ArrayList<RowView> rowViews=new ArrayList<>();
//		rowViews.add(rowView1);
//		rowViews.add(rowView2);
//		rowViews.add(rowView3);
//		rowViews.add(rowView4);
//		rowViews.add(rowView5);
//		
//		GroupView groupView=new GroupView(getBaseContext());
//		groupView.addAllRowView(rowViews);
//		ContainerView containerView=new ContainerView(getApplicationContext());
//		
//		containerView.addGroupView(groupView);
		SetViewUtil setViewUtil=new SetViewUtil(getApplicationContext());
		setViewUtil.add(1, 1, 1, "中国移动1");
		setViewUtil.add(1, 2, 1, "中国移动2");
		setViewUtil.add(1, 3, 1, "中国移动3");
		setViewUtil.add(1, 4, 1, "中国移动4");
		setViewUtil.add(2, 1, 1, "中国移动5");
		setViewUtil.add(2, 2, 1, "中国移动6");
		setViewUtil.add(2, 3, 1, "中国移动7");
		setViewUtil.add(2, 4, 1, "中国移动8");
		setViewUtil.add(3, 4, 1, "中国移动9");
		setViewUtil.addCompleted();
		setContentView(setViewUtil.getContainerView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		menu.
//		menu.a
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
