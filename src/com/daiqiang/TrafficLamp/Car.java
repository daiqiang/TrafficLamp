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
	 * ���ܣ�ͨ�����ĵ�ǰλ�ú�Ŀ�ĵؼ��㳵����ʻ����
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
				System.out.println("Ŀ�ĵص���");
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
				System.out.println("Ŀ�ĵص���");
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
				System.out.println("Ŀ�ĵص���");
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
				System.out.println("Ŀ�ĵص���");
			}
			break;
		}
		return null;
	}
	
	/**
	 * ���ܣ����ݵƵ�ָʾ������
	 * */
	public void dirve(){
		Executors.newSingleThreadExecutor().execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					if(local == Diraction.SORTH || local == Diraction.NORTH){
						//�����ϱ���
						if(SandNLamp.instantMyself().getLampState() == dirveDiraction()){
							Diraction temp = local;
							setLocal(getDistination());
							System.out.println("�ó���" + temp +"������ʻ��" + getDistination() +"�ߡ�������" + getLocal() +"��");
							return;
						}
					}else{
						//����������
						if(EandWLamp.instantMyself().getLampState() == dirveDiraction()){
							Diraction temp = local;
							setLocal(getDistination());
							System.out.println("�ó���" + temp +"������ʻ��" + getDistination()  +"�ߡ�������" + getLocal() +"��");
							return;
						}
					}
				}
				
			}
			
		});
	}
}
