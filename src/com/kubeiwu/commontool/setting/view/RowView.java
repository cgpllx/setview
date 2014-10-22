package com.kubeiwu.commontool.setting.view;

import android.content.Context;
import android.graphics.Canvas;
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
	private int mRowViewPosition = RowViewPosition.MIDDLE;

	public void setRowViewPosition(int rowViewPosition) {
		this.mRowViewPosition = rowViewPosition;
	}

	public interface RowViewPosition {
		int UP = 0, MIDDLE = 1, DOWM = 2, ALL = 3;
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

	private Drawable upSelector;
	private Drawable middleSelector;
	private Drawable downSelector;
	private Drawable allSelector;

	public void setLastRowView(RowView lastRowView) {
		this.lastRowView = lastRowView;
	}

	public void setMiddleSelector(Drawable middleSelector) {
		this.middleSelector = middleSelector;
	}

	public void setDownSelector(Drawable downSelector) {
		this.downSelector = downSelector;
	}

	public void setAllSelector(Drawable allSelector) {
		this.allSelector = allSelector;
	}

	private int out_circle_Size = 15;
	private int linewidth = 1;

	public void initSelector(Context context, int idNormalLineColor, int idNormalBackgroundColor, int idPressedLineColor, int idPressedBackgroundColor) {
		initSelector(context, idNormalLineColor, idNormalBackgroundColor, idPressedLineColor, idPressedBackgroundColor, 15, 1);
	}

	public void initSelector(Context context, int idNormalLineColor, int idNormalBackgroundColor, int idPressedLineColor, int idPressedBackgroundColor, int out_circle_Size, int linewidth) {
		ItemBgSelectorUtil itemBgSelectorUtil = new ItemBgSelectorUtil(out_circle_Size, linewidth);
		upSelector = itemBgSelectorUtil.createSelector(context, idNormalLineColor, idNormalBackgroundColor, idPressedLineColor, idPressedBackgroundColor, RowViewPosition.UP);
		middleSelector = itemBgSelectorUtil.createSelector(context, idNormalLineColor, idNormalBackgroundColor, idPressedLineColor, idPressedBackgroundColor, RowViewPosition.MIDDLE);
		downSelector = itemBgSelectorUtil.createSelector(context, idNormalLineColor, idNormalBackgroundColor, idPressedLineColor, idPressedBackgroundColor, RowViewPosition.DOWM);
		allSelector = itemBgSelectorUtil.createSelector(context, idNormalLineColor, idNormalBackgroundColor, idPressedLineColor, idPressedBackgroundColor, RowViewPosition.ALL);
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
		mWidgetRow_Label.setText(rowBuilder.lable);
		if (rowBuilder.action != null) {
			setOnClickListener(this);
			mWidgetRow_righ_Common_arrow.setVisibility(View.VISIBLE);// 可以点击时候显示箭头
		} else {
			mWidgetRow_righ_Common_arrow.setVisibility(View.GONE);// 不可以点击时候隐藏箭头
		}
		if (rowBuilder.iconResourceId != 0) {
			mWidgetRowAction_Icon.setImageResource(rowBuilder.iconResourceId);
		} else {
			mWidgetRowAction_Icon.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(rowBuilder.defaultValue)) {
			mWidgetRow_Value.setText(rowBuilder.defaultValue);
		} else {
			mWidgetRow_Value.setVisibility(View.GONE);
		}
		out_circle_Size = rowBuilder.out_circle_Size > 0 ? rowBuilder.out_circle_Size : out_circle_Size;
		linewidth = rowBuilder.linewidth > 0 ? rowBuilder.linewidth : linewidth;
		initSelector(getContext(), rowBuilder.normalLineColorId, rowBuilder.normalBackgroundColorId,//
				rowBuilder.pressedLineColorId, rowBuilder.pressedBackgroundColorId);
		// initSelector(getContext(), R.color.setting_view_item_bg_pressed, android.R.color.white,//
		// android.R.color.holo_blue_light, android.R.color.holo_blue_light);

	}

	@Override
	public void onClick(View v) {
		if (rowBuilder.getListener() != null) {
			rowBuilder.getListener().onRowClick(rowBuilder.action);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// AlertDialog.Builder d
		// AlertController d;
		super.onDraw(canvas);
	}

	public void notifyDataChanged() {

		switch (mRowViewPosition) {
		case RowView.RowViewPosition.UP:
			setBackground(upSelector);
			break;
		case RowView.RowViewPosition.MIDDLE:
			setBackground(middleSelector);
			break;
		case RowView.RowViewPosition.DOWM:
			setBackground(downSelector);
			break;
		case RowView.RowViewPosition.ALL:
			setBackground(allSelector);
			break;

		}
	}

	public static class Builder {
		private RowViewActionEnum action;
		private String lable;
		private OnRowClickListener listener;
		private int iconResourceId;
		private Context context;
		private String defaultValue;
		private int normalLineColorId;
		private int normalBackgroundColorId;
		private int pressedLineColorId;
		private int pressedBackgroundColorId;
		private int out_circle_Size;
		private int linewidth;

		public void setOut_circle_Size(int out_circle_Size) {
			this.out_circle_Size = out_circle_Size;
		}

		public void setLinewidth(int linewidth) {
			this.linewidth = linewidth;
		}

		public int getItemId() {
			return itemId;
		}

		/**
		 * 设置默认时候的线条颜色
		 * 
		 * @param normalLineColorId
		 */
		public void setNormalLineColorId(int normalLineColorId) {
			this.normalLineColorId = normalLineColorId;
		}

		/**
		 * 设置默认时候的背景颜色
		 * 
		 * @param normalBackgroundColorId
		 */

		public void setNormalBackgroundColorId(int normalBackgroundColorId) {
			this.normalBackgroundColorId = normalBackgroundColorId;
		}

		/**
		 * 设置按下时候的线条颜色，一般和默认时候一样
		 * 
		 * @param pressedLineColorId
		 */
		public void setPressedLineColorId(int pressedLineColorId) {
			this.pressedLineColorId = pressedLineColorId;
		}

		/**
		 * 按下时候背景颜色
		 * 
		 * @return
		 */
		public void setPressedBackgroundColorId(int pressedBackgroundColorId) {
			this.pressedBackgroundColorId = pressedBackgroundColorId;
		}

		public Builder setItemId(int itemId) {
			this.itemId = itemId;
			return this;
		}

		private int itemId;

		public Builder(Context context) {
			this.context = context;
		}

		public Builder setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
			return this;
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

		public Builder setIconResourceId(int iconResourceId) {
			this.iconResourceId = iconResourceId;
			return this;
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
