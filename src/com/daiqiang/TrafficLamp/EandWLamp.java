package com.daiqiang.TrafficLamp;

import com.daiqiang.constant.Diraction;

public class EandWLamp extends Lamp{
	//指挥东西朝向的灯，标记它的方位为east
	private Diraction diraction = Diraction.EAST;
	
	private EandWLamp(){
		super();
	}
	public static EandWLamp instantMyself(){
		return eandWLamp;
	}
	static EandWLamp eandWLamp = new EandWLamp();
}
