package com.android.rain.v2;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class RainView extends BaseView {
	
	private ArrayList<Rain> list = new ArrayList<Rain>();
	private int size = 30;

	public RainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	public RainView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void drawSub(Canvas canvas) {
		for(Rain rain:list){
			rain.draw(canvas);
		}
	}
	
	
	@Override
	protected void logic() {
		for(Rain rain:list){
			rain.move();
		}
	}

	@Override
	protected void init() {
		for (int i = 0; i < size ; i++) {
			Rain rain = new Rain(getWidth(),getHeight());
			list.add(rain);
		}
		
	}

}
