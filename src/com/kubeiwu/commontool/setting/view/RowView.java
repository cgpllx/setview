package com.kubeiwu.commontool.setting.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kubeiwu.commontool.R;

public class RowView extends LinearLayout implements OnClickListener {

	private ImageView mWidgetRowActionImg;
	private TextView mWidgetRowLabel;
	private ImageView mWidgetRowIconImg;

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
		LayoutInflater.from(getContext()).inflate(R.layout.rowviewlayout, this);
		mWidgetRowActionImg = (ImageView) findViewById(R.id.mWidgetRowActionImg);
		mWidgetRowLabel = (TextView) findViewById(R.id.mWidgetRowLabel);
		mWidgetRowIconImg = (ImageView) findViewById(R.id.mWidgetRowIconImg);
		mWidgetRowIconImg.setBackgroundResource(R.id.icon);
	}

	private Builder rowDescriptor;

	public void initRowViewData(Builder rowDescriptor) {
		this.rowDescriptor = rowDescriptor;
		mWidgetRowActionImg.setBackgroundResource(rowDescriptor.getIconResId());
		mWidgetRowLabel.setText(rowDescriptor.getLable());
		if (rowDescriptor.getAction() != null) {
			setOnClickListener(this);
			setBackgroundResource(R.drawable.widgets_general_row_selector);
			mWidgetRowActionImg.setVisibility(View.VISIBLE);
		} else {
			setBackgroundColor(Color.WHITE);
			mWidgetRowActionImg.setVisibility(View.GONE);
		}

	}

	@Override
	public void onClick(View v) {
		if (rowDescriptor.getListener() != null) {
			rowDescriptor.getListener().onRowClick(rowDescriptor.getAction());
		}
	}

	public void notifyDataChanged() {

	}

	public static class Builder {
		private RowViewActionEnum action;
		private String lable;
		private OnRowClickListener listener;
		private int iconResId;
		private Context context;
		public Builder(Context context){
			this.context=context;
		}

		public String getLable() {
			return lable;
		}

		public void setLable(String lable) {
			this.lable = lable;
		}

		public OnRowClickListener getListener() {
			return listener;
		}

		public void setListener(OnRowClickListener listener) {
			this.listener = listener;
		}

		public int getIconResId() {
			return iconResId;
		}

		public void setIconResId(int iconResId) {
			this.iconResId = iconResId;
		}

		public RowViewActionEnum getAction() {
			return action;
		}

		public void setAction(RowViewActionEnum action) {
			this.action = action;
		}

		public RowView create() {
			final RowView rowView = new RowView(context);
			rowView.initRowViewData(this);
			return rowView;
		}
	}

}
