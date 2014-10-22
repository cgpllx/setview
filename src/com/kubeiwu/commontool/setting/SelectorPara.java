package com.kubeiwu.commontool.setting;

/**
 * 选择器的参数
 * 
 * @author Administrator
 */
public class SelectorPara {
	private int normalLineColorId=android.R.color.darker_gray;// 线条颜色资源id  FFD6D6D6
	private int normalBackgroundColorId=android.R.color.white;// 默认时候的背景
	private int pressedLineColorId=android.R.color.darker_gray;// 按下时候的线条颜色id
	private int pressedBackgroundColorId=android.R.color.holo_blue_light;// 按下时候的背景颜色资源id
	private int out_circle_Size = 15; // 圆角大小
	private int linewidth = 1;// 线宽
	
	// initSelector(getContext(), R.color.setting_view_item_bg_pressed, android.R.color.white,//
	// android.R.color.holo_blue_light, android.R.color.holo_blue_light);

	public int getNormalLineColorId() {
		return normalLineColorId;
	}

	public SelectorPara() {
		super();
	}

	public void setNormalLineColorId(int normalLineColorId) {
		this.normalLineColorId = normalLineColorId;
	}

	public int getNormalBackgroundColorId() {
		return normalBackgroundColorId;
	}

	public SelectorPara(int normalLineColorId, int normalBackgroundColorId, int pressedLineColorId, int pressedBackgroundColorId, int out_circle_Size, int linewidth) {
		super();
		this.normalLineColorId = normalLineColorId;
		this.normalBackgroundColorId = normalBackgroundColorId;
		this.pressedLineColorId = pressedLineColorId;
		this.pressedBackgroundColorId = pressedBackgroundColorId;
		this.out_circle_Size = out_circle_Size;
		this.linewidth = linewidth;
	}

	public void setNormalBackgroundColorId(int normalBackgroundColorId) {
		this.normalBackgroundColorId = normalBackgroundColorId;
	}

	public int getPressedLineColorId() {
		return pressedLineColorId;
	}

	public void setPressedLineColorId(int pressedLineColorId) {
		this.pressedLineColorId = pressedLineColorId;
	}

	public int getPressedBackgroundColorId() {
		return pressedBackgroundColorId;
	}

	public void setPressedBackgroundColorId(int pressedBackgroundColorId) {
		this.pressedBackgroundColorId = pressedBackgroundColorId;
	}

	public int getOut_circle_Size() {
		return out_circle_Size;
	}

	public void setOut_circle_Size(int out_circle_Size) {
		this.out_circle_Size = out_circle_Size;
	}

	public int getLinewidth() {
		return linewidth;
	}

	public void setLinewidth(int linewidth) {
		this.linewidth = linewidth;
	}
}
