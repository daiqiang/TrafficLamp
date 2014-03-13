package com.daiqiang.TrafficLamp;

import java.util.concurrent.Executors;

import com.daiqiang.constant.LampState;

public class Lamp {
	protected LampState lampState;
	private int IntervalBefore2Left;
	private int IntervalLeft2Red;
	private int IntervalRed2Before;
	
	public Lamp(){
		IntervalBefore2Left=2000;
		IntervalLeft2Red=2000;
		IntervalRed2Before=4000;
		lampState=LampState.BEFORE;
	}
	public LampState getLampState() {
		return lampState;
	}

	public void setLampState (LampState lampState) {
		this.lampState = lampState;
	}
	
	public void alwaysChangeState(){
		//一个线程，红绿灯状态一直改变
		Executors.newSingleThreadExecutor().execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					switch(getLampState()){
					case BEFORE:
						System.out.println("此时绿灯亮，方向指向前");
						try {
							Thread.sleep(IntervalBefore2Left);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setLampState(LampState.LEFT);
						break;
					case LEFT:
						System.out.println("此时绿灯亮，方向指向左");
						try {
							Thread.sleep(IntervalLeft2Red);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setLampState(LampState.RED);
						break;
					case RED:
						System.out.println("此时红灯亮");
						try {
							Thread.sleep(IntervalRed2Before);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setLampState(LampState.BEFORE);
						break;
					case RIGHT:
						
					}
					
				}
				
			}
			
		});
	}
}
