package com.daiqiang.TrafficLamp;

import com.daiqiang.constant.Diraction;

public class EandWLamp extends Lamp{
	//ָ�Ӷ�������ĵƣ�������ķ�λΪeast
	private Diraction diraction = Diraction.EAST;
	
	private EandWLamp(){
		super();
	}
	public static EandWLamp instantMyself(){
		return eandWLamp;
	}
	static EandWLamp eandWLamp = new EandWLamp();
}
