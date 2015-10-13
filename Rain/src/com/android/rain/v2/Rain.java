package com.android.rain.v2;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Rain {
	private int width;
	private int height;
	private Random rand;
	private float startX;
	private float startY;
	private float stopX;
	private float stopY;
	private float sizeX;
	private float sizeY;
	private Paint paint = new Paint();
	
	public Rain(int width,int height){
		this.width = width;
		this.height = height;
		init();
	}
	
	public  void init(){
		rand = new Random();
		sizeX=10;
		sizeY=30;
		startX=rand.nextInt(width);
		startY=rand.nextInt(height);
		stopX=startX+sizeX;
		stopY=startY+sizeY;

		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		paint.setARGB(255,r,g,b);
	}
	
	public void draw(Canvas canvas){
		canvas.drawLine(startX, startY, stopX, stopY, paint );
	}
	
	public void move(){
		float opt = 0.6f;
		startX +=sizeX*opt;
		stopX+=sizeX*opt;
		startY+=sizeY*opt;
		stopY+=sizeY*opt;
		
		if (startY>height) {
			init();
		}
	}

}
