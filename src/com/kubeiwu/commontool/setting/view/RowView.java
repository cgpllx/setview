package com.kubeiwu.commontool.setting.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kubeiwu.commontool.R;
import com.kubeiwu.commontool.setting.ItemBgSelectorUtil;

public class RowView extends LinearLayout implements OnClickListener {

	private ImageView mWidgetRowAction_Icon;
	private TextView mWidgetRow_Label;
	private TextView mWidgetRow_Value;
	private ImageView mWidgetRow_righ_Common_arrow;
	private int itemId;
	private RowView next = null;
	private RowViewPosition mRowViewPosition;

	public void setRowViewPosition(RowViewPosition postion) {
		this.mRowViewPosition = postion;
	}

	public enum RowViewPosition {
		UP, MIDDLE, DOWM;
	}

	public RowView getNext() {
		return next;
	}

	public boolean hasNext() {
		return next != null;
	}

	private RowView lastRowView = this;

	public void addRowViewLastNode(RowView rowView) {
		lastRowView.next = rowView;
		lastRowView = rowView;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

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
		setBackground(ItemBgSelectorUtil.createSelector(getContext(), android.R.color.darker_gray, android.R.color.white,//
				android.R.color.holo_blue_light, android.R.color.holo_blue_light));
	}

	private Builder rowBuilder;

	public void initRowViewData(Builder rowBuilder) {
		this.rowBuilder = rowBuilder;
		mWidgetRow_Label.setText(rowBuilder.getLable());
		if (rowBuilder.getAction() != null) {
			setOnClickListener(this);
			// setBackgroundResource(R.drawable.widgets_general_row_selector);
			// set
			mWidgetRow_righ_Common_arrow.setVisibility(View.VISIBLE);// 可以点击时候显示箭头
		} else {
			// setBackgroundColor(Color.WHITE);
			mWidgetRow_righ_Common_arrow.setVisibility(View.GONE);// 不可以点击时候隐藏箭头
		}
		if (rowBuilder.getIconResourceId() != 0) {
			mWidgetRowAction_Icon.setImageResource(rowBuilder.getIconResourceId());
		} else {
			mWidgetRowAction_Icon.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(rowBuilder.getDefaultValue())) {
			mWidgetRow_Value.setText(rowBuilder.getDefaultValue());
		} else {
			mWidgetRow_Value.setVisibility(View.GONE);
		}
		itemId = rowBuilder.getItemId();

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
		private String defaultValue;

		public int getItemId() {
			return itemId;
		}

		public Builder setItemId(int itemId) {
			this.itemId = itemId;
			return this;
		}

		private int itemId;

		public Builder(Context context) {
			this.context = context;
		}

		public String getDefaultValue() {
			return defaultValue;
		}

		public Builder setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
			return this;
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

		public Builder setIconResourceId(int iconResourceId) {
			this.iconResourceId = iconResourceId;
			return this;
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
