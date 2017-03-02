package com.own.test;
import java.util.*;

public class human implements Runnable{
	double x;
	double y;
	double envir_x;
	double envir_y;
	double speed;
	String color;
	int life;
	int direct;
	Vector<zombie> hum = new Vector<zombie>();
	Vector<zombie> infected = new Vector<zombie>();
	Vector<zombie> zm = new Vector<zombie>();
	boolean is_alive;
	public human(double x, double y){
		this.x=x;
		this.y=y;
		speed = 10;
		color = "green";
		life = 5;
		direct = 0;
	}
	
	public void set_envir(double x, double y){
		this.envir_x=x;
		this.envir_y=y;
	}
	
	public void setZom(Vector<zombie> zombie){
		zm = zombie;
	}
	
	public void setDierct(int x){
		this.direct=x;
	}
	public void moveUp(){
		this.y -= speed;
	}
	
	public void moveDown(){
		this.y += speed;
	}
	
	public void moveLeft(){
		this.x -= speed;
	}
	
	public void moveRight(){
		this.x += speed;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public boolean reachZombies(){
		for(int i = 0;i<zm.size();i++){
			if(this.x<zm.get(i).getX()+5&&this.x>zm.get(i).getX()-5
					&&this.y<zm.get(i).getY()+5&&this.y>zm.get(i).getY()-5){
				return true;
			}
		}
		return false;
	}
	
	public boolean is_live(){
		return this.is_alive;
	}
	
	public void setLive(boolean b){
		this.is_alive=b;
	}
	
	public boolean at_umb(double x,double y){
		if(this.x>x&&this.x<x+50&&this.y>y&&this.y<y+50){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean at_safe(double x,double y){
		if(this.x>x&&this.x<x+50&&this.y>y&&this.y<y+50){
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int moveTime=(int)(Math.random()*30+70);
		
		switch(direct){
		case 0:
			for(int i=0;i<30;i++){
				try {
					Thread.sleep(moveTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(y>0){
					this.moveUp();
				}
			}
			
			break;
		case 1:
			for(int i=0;i<30;i++){
				try {
					Thread.sleep(moveTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(y<597){
					this.moveDown();
				}
			}
			break;
		case 2:
			for(int i=0;i<30;i++){
				try {
					Thread.sleep(moveTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(x>0){
					this.moveLeft();
				}
			}
			break;
		case 3:
			for(int i=0;i<30;i++){
				try {
					Thread.sleep(moveTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(x<797){
					this.moveRight();
				}
			}
			break;
		}
		
		//Create a new direction
		direct = (int)(Math.random()*4);
		this.setDierct(direct);
		
	}
	
}
