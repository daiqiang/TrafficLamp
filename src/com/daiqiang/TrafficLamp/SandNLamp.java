package com.daiqiang.TrafficLamp;

import com.daiqiang.constant.Diraction;

public class SandNLamp extends Lamp{
	//ָ���ϱ�����ĵƣ�������ķ�λΪsorth
	private Diraction diraction = Diraction.SORTH;
	private SandNLamp(){
		super();
	}
	public static SandNLamp instantMyself(){
		return sandNLamp;
	}
	static SandNLamp sandNLamp = new SandNLamp();
}
