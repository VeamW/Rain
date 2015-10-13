package com.android.rain.v1;


import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public  abstract  class   BaseView extends View {

	private MyThread thread;
	
	public BaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public BaseView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	
	protected abstract void drawSub(Canvas canvas);
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		if (thread==null) {
			thread = new MyThread();
			thread.start();
		}else{
			drawSub(canvas);
		}
		
	}
	
	protected abstract void logic();
	
	
	class MyThread extends Thread{
		@Override
		public void run() {
			while (true) {
				logic();
				postInvalidate();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
					
				}
			}
			
			
		}
	}


