package com.kubeiwu.commontool.setting.view;

import com.kubeiwu.commontool.R;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RowView extends LinearLayout implements OnClickListener {

	private ImageView mWidgetRowAction_Icon;
	private TextView mWidgetRow_Label;
	private TextView mWidgetRow_Value;
	private ImageView mWidgetRow_righ_Common_arrow;

	private RowView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initRowView();
	}

	private RowView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	private RowView(Context context) {
		super(context);
		initRowView();
	}

	private void initRowView() {
		LayoutInflater.from(getContext()).inflate(R.layout.setting_view_basic_item_h, this);
		mWidgetRowAction_Icon = (ImageView) findViewById(R.id.mWidgetRowAction_Icon);
		mWidgetRow_Label = (TextView) findViewById(R.id.mWidgetRow_Label);
		mWidgetRow_Value = (TextView) findViewById(R.id.mWidgetRow_Value);
		mWidgetRow_righ_Common_arrow = (ImageView) findViewById(R.id.mWidgetRow_righ_Common_arrow);
	}

	private Builder rowBuilder;

	public void initRowViewData(Builder rowBuilder) {
		this.rowBuilder = rowBuilder;
		mWidgetRowAction_Icon.setBackgroundResource(rowBuilder.getIconResourceId());
		mWidgetRow_Label.setText(rowBuilder.getLable());
		if (rowBuilder.getAction() != null) {
			setOnClickListener(this);
//			setBackgroundResource(R.drawable.widgets_general_row_selector);
			mWidgetRow_righ_Common_arrow.setVisibility(View.VISIBLE);
		} else {
//			setBackgroundColor(Color.WHITE);
			mWidgetRow_righ_Common_arrow.setVisibility(View.GONE);
		}

	}

	@Override
	public void onClick(View v) {
		if (rowBuilder.getListener() != null) {
			rowBuilder.getListener().onRowClick(rowBuilder.getAction());
		}
	}

	public void notifyDataChanged() {

	}

	public static class Builder {
		private RowViewActionEnum action;
		private String lable;
		private OnRowClickListener listener;
		private int iconResourceId;
		private Context context;

		public Builder(Context context) {
			this.context = context;
		}

		public String getLable() {
			return lable;
		}

		public Builder setLable(String lable) {
			this.lable = lable;
			return this;
		}

		public OnRowClickListener getListener() {
			return listener;
		}

		public Builder setListener(OnRowClickListener listener) {
			this.listener = listener;
			return this;
		}


		public int getIconResourceId() {
			return iconResourceId;
		}

		public void setIconResourceId(int iconResourceId) {
			this.iconResourceId = iconResourceId;
		}

		public RowViewActionEnum getAction() {
			return action;
		}

		public Builder setAction(RowViewActionEnum action) {
			this.action = action;
			return this;
		}

		public RowView create() {
			final RowView rowView = new RowView(context);
			rowView.initRowViewData(this);
			return rowView;
		}
	}

}
