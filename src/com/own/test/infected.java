package com.own.test;

public class infected extends human{
	double time;
	public infected(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		speed = 10;
		time = Math.random()*40+20;// Random infectious time to become zombie
		color = "yellow";
	}

}
