package com.daiqiang.TrafficLamp;

import java.util.concurrent.Executors;

import com.daiqiang.constant.Diraction;
import com.daiqiang.constant.LampState;

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
	
	public Car(){
		local = Diraction.SORTH;
		distination = Diraction.NORTH;
	}
	public Car(Diraction loacl,Diraction distination){
		this.local = loacl;
		this.distination = distination;
	}
	/**
	 * 功能：通过车的当前位置和目的地计算车的行驶方向
	 * */
	private LampState dirveDiraction(){
		switch(local){
		case SORTH:
			if(distination == Diraction.NORTH){
				return LampState.BEFORE;
			}else if(distination == Diraction.EAST){
				return LampState.RIGHT;
			}else if(distination == Diraction.WEST){
				return LampState.LEFT;
			}else{
				System.out.println("目的地到达");
			}
			break;
		case NORTH:
			if(distination == Diraction.SORTH){
				return LampState.BEFORE;
			}else if(distination == Diraction.WEST){
				return LampState.RIGHT;
			}else if(distination == Diraction.EAST){
				return LampState.LEFT;
			}else{
				System.out.println("目的地到达");
			}
			break;
		case EAST:
			if(distination == Diraction.WEST){
				return LampState.BEFORE;
			}else if(distination == Diraction.NORTH){
				return LampState.RIGHT;
			}else if(distination == Diraction.WEST){
				return LampState.LEFT;
			}else{
				System.out.println("目的地到达");
			}
			break;
		case WEST:
			if(distination == Diraction.EAST){
				return LampState.BEFORE;
			}else if(distination == Diraction.NORTH){
				return LampState.LEFT;
			}else if(distination == Diraction.WEST){
				return LampState.RIGHT;
			}else{
				System.out.println("目的地到达");
			}
			break;
		}
		return null;
	}
	
	/**
	 * 功能：根据灯的指示来开车
	 * */
	public void dirve(){
		Executors.newSingleThreadExecutor().execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					if(local == Diraction.SORTH || local == Diraction.NORTH){
						//关联南北灯
						if(SandNLamp.instantMyself().getLampState() == dirveDiraction()){
							Diraction temp = local;
							setLocal(getDistination());
							System.out.println("该车从" + temp +"边来，驶向" + getDistination() +"边。现已在" + getLocal() +"边");
							return;
						}
					}else{
						//关联东西灯
						if(EandWLamp.instantMyself().getLampState() == dirveDiraction()){
							Diraction temp = local;
							setLocal(getDistination());
							System.out.println("该车从" + temp +"边来，驶向" + getDistination()  +"边。现已在" + getLocal() +"边");
							return;
						}
					}
				}
				
			}
			
		});
	}
}
