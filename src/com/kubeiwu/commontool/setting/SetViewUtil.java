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
	ContainerView containerView;
 
	public ContainerView getContainerView() { 
		return containerView;
	}
	SparseArray<GroupView> groupViewArray = new SparseArray<GroupView>();
	
	public void add(int groupId, int itemId, int order, String title) {
		RowView rowView=new RowView.Builder(context).setGroupId(groupId).setItemId(itemId)//
				.setLable(title).setAction(RowViewActionEnum.My_POSTS).create();
		
		GroupView groupView =groupViewArray.get(rowView.getGroupId());
		if(groupView==null){
			groupView=new GroupView(context);
			groupViewArray.put(groupId, groupView);
		}
		
//		GroupView groupView = groupViewArray.get(rowView.getGroupId(), new GroupView(context));
//		if(groupViewArray.){
//			
//		}
		groupView.addRowView(rowView);		
		
		groupViewArray.put(groupId, groupView);
		System.out.println("groupViewArray"+groupViewArray.size());
		
	};
	
	public void addCompleted(){
		containerView=new ContainerView(context);
		System.out.println("groupViewArraykkk=="+groupViewArray.size());
		containerView.addAllGroupView(groupViewArray);
	}

}
