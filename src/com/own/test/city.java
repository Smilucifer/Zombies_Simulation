package com.own.test;

public class city {
	double width;
	double length;
	double um_x;
	double um_y;
	double safe_x;
	double safe_y;
	
	//Constructor
	public city(double x,double y){
		this.width=x;
		this.length=y;
	}
	
	public void set_um(double x, double y){
		this.um_x=x;
		this.um_y=y;
	}
	
	public void set_safe(double x,double y){
		this.safe_x=x;
		this.safe_y=y;
	}

	public double getUm_x() {
		return um_x;
	}

	public double getUm_y() {
		return um_y;
	}

	public double getSafe_x() {
		return safe_x;
	}

	public double getSafe_y() {
		return safe_y;
	}

}
