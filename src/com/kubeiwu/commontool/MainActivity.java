package com.kubeiwu.commontool;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.kubeiwu.commontool.setting.view.ContainerView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// RowView rowView1 = new
		// RowView.Builder(getBaseContext()).setLable("中国移动1").setAction(RowViewActionEnum.My_POSTS).create();
		// RowView rowView2 = new
		// RowView.Builder(getBaseContext()).setLable("中国移动2").setAction(RowViewActionEnum.My_POSTS).create();
		// RowView rowView3 = new
		// RowView.Builder(getBaseContext()).setLable("中国移动3").setAction(RowViewActionEnum.My_POSTS).create();
		// RowView rowView4 = new
		// RowView.Builder(getBaseContext()).setLable("中国移动4").setAction(RowViewActionEnum.My_POSTS).create();
		// RowView rowView5 = new
		// RowView.Builder(getBaseContext()).setLable("中国移动5").setAction(RowViewActionEnum.My_POSTS).create();
		// ArrayList<RowView> rowViews=new ArrayList<>();
		// rowViews.addItem(rowView1);
		// rowViews.addItem(rowView2);
		// rowViews.addItem(rowView3);
		// rowViews.addItem(rowView4);
		// rowViews.addItem(rowView5);
		//
		// GroupView groupView=new GroupView(getBaseContext());
		// groupView.addItemAllRowView(rowViews);
		// ContainerView containerView=new
		// ContainerView(getApplicationContext());
		//
		// containerView.addItemGroupView(groupView);
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
		// System.out.println("containerView"+containerView.hashCode());
		setContentView(containerView);
		// System.out.println("setViewUtil.getSettingView()"+setViewUtil.getSettingView().hashCode());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this addItems items to the action bar if it is
		// present.
		// menu.
//		 menu.addItem(groupId, itemId, order, title);
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
