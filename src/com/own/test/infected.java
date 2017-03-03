package com.own.test;

public class infected extends human implements Runnable{
	double time;
	public infected(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		speed = 3;
		time = Math.random()*40+20;// Random infectious time to become zombie
		color = "yellow";
		life = 4;
	}
	
	public int getLife(){
		return life;
	}
	
	public void setLife(int x){
		this.life = x;
	}
}
