package com.daiqiang.test;

import com.daiqiang.TrafficLamp.Car;
import com.daiqiang.TrafficLamp.EandWLamp;
import com.daiqiang.TrafficLamp.Lamp;
import com.daiqiang.constant.Diraction;
import com.daiqiang.constant.LampState;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car(Diraction.WEST,Diraction.NORTH);
		car.dirve();
		
		Lamp eandWLamp = EandWLamp.instantMyself();
		eandWLamp.alwaysChangeState();
		
		
	}

}
