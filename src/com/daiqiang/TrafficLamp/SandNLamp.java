package com.daiqiang.TrafficLamp;

import com.daiqiang.constant.Diraction;
import com.daiqiang.constant.LampState;

public class SandNLamp extends Lamp{
	//指挥南北朝向的灯，标记它的方位为sorth
	private Diraction diraction = Diraction.SORTH;
	private SandNLamp(){
		super();
	}
	public static SandNLamp instantMyself(){
		return sandNLamp;
	}
	static SandNLamp sandNLamp = new SandNLamp();
	
	
}
