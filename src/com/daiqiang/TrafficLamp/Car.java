package com.daiqiang.TrafficLamp;

import java.util.concurrent.Executors;

import com.daiqiang.constant.Diraction;

public class Car {
	private Diraction local;
	private Diraction distination;
	
	public Diraction getLocal() {
		return local;
	}

	public void setLocal(Diraction local) {
		this.local = local;
	}

	public Diraction getDistination() {
		return distination;
	}
	
	public void dirve(){
		Executors.newSingleThreadExecutor().execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
