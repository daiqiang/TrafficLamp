package com.daiqiang.TrafficLamp;

import java.util.concurrent.Executors;

import com.daiqiang.constant.LampState;

public class Lamp {
	private LampState lampState;
	private int IntervalBefore2Left;
	private int IntervalLeft2Red;
	private int IntervalRed2Before;
	
	public Lamp(){
		IntervalBefore2Left=2000;
		IntervalLeft2Red=2000;
		IntervalRed2Before=4000;
	}
	public LampState getLampState() {
		return lampState;
	}

	public void setLampState (LampState lampState) {
		this.lampState = lampState;
	}
	
	public void start(){
		//һ���̣߳�״̬һֱ�ı�
		Executors.newSingleThreadExecutor().execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Lamp tempLamp = new Lamp();
				tempLamp.setLampState(LampState.BEFORE);
				while(true){
					switch(tempLamp.getLampState()){
					case BEFORE:
						System.out.println("��ʱ�̵���������ָ��ǰ");
						try {
							Thread.sleep(IntervalBefore2Left);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tempLamp.setLampState(LampState.LEFT);
						break;
					case LEFT:
						System.out.println("��ʱ�̵���������ָ����");
						try {
							Thread.sleep(IntervalLeft2Red);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tempLamp.setLampState(LampState.RED);
						break;
					case RED:
						System.out.println("��ʱ�����");
						try {
							Thread.sleep(IntervalRed2Before);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tempLamp.setLampState(LampState.BEFORE);
						break;
					case RIGHT:
						
					}
					
				}
				
			}
			
		});
	}
}