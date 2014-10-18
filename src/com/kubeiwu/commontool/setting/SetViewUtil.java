package com.kubeiwu.commontool.setting;

import android.content.Context;
import android.util.SparseArray;

import com.kubeiwu.commontool.setting.view.ContainerView;
import com.kubeiwu.commontool.setting.view.GroupView;
import com.kubeiwu.commontool.setting.view.RowView;
import com.kubeiwu.commontool.setting.view.RowViewActionEnum;

public class SetViewUtil {
	private Context context;

	public SetViewUtil(Context context) {
		this.context = context;
		containerView = new ContainerView(context);
	}

	public SetViewUtil(ContainerView containerView) {
		this.context = containerView.getContext();
		System.out.println("SetViewUtil--containerView"+containerView.hashCode());
		this.containerView = containerView;
		System.out.println("SetViewUtil--this.containerView"+this.containerView.hashCode());
	}

	ContainerView containerView;

	public ContainerView getSettingView() {
		return containerView;
	}

	SparseArray<GroupView> groupViewArray = new SparseArray<GroupView>();

	public void add(int groupId, int itemId, int order, String title) {
		RowView rowView = new RowView.Builder(context). setItemId(itemId)//
				.setLable(title).setAction(RowViewActionEnum.My_POSTS).create();
		GroupView groupView = groupViewArray.get(groupId);
		if (groupView == null) {
			groupView = new GroupView(context);
			groupViewArray.put(groupId, groupView);
		}
		groupView.addRowView(order,rowView);
		groupViewArray.put(groupId, groupView);
	};

	public void addCompleted() {
		System.out.println("groupViewArraykkk==" + groupViewArray.size());
		containerView.addAllGroupView(groupViewArray);
	}
}
