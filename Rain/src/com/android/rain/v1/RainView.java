package com.android.rain.v1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class RainView extends BaseView {

	private float startX;
	private float startY;
	private float stopX;
	private float stopY;
	private float sizeX;
	private float sizeY;
	private Paint paint = new Paint();


	public RainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		sizeX=10;
		sizeY=30;
		startX=100;
		startY=0;
		stopX=startX+sizeX;
		stopY=startY+sizeY;
		
		paint.setColor(0xffffffff);
		
	}

	public RainView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void drawSub(Canvas canvas) {
		// TODO Auto-generated method stub
			canvas.drawLine(startX, startY, stopX, stopY, paint );
		
	}
	
	
	@Override
	protected void logic() {
		float opt = 0.6f;
		startX +=sizeX*opt;
		stopX+=sizeX*opt;
		startY+=sizeY*opt;
		stopY+=sizeY*opt;
		
		if (startY>getHeight()) {
			startX=100;
			startY=0;
			stopX=startX+10;
			stopY=startY+30;
		}
		
	}

}
