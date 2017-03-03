package com.own.test;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class MyPanel extends JPanel implements Runnable{
	Vector<human> hum = new Vector<human>();
	Vector<infected> infect = new Vector<infected>();
	Vector<zombie> zm = new Vector<zombie>();
	city lansing = null;
	human a = null;
	infected b = null;
	
	public MyPanel(){
		lansing=new city(800,600);
		for(int i=0;i<50;i++){
			double x = Math.random()*800;
			double y = Math.random()*600;
			human a = new human(x,y);
			hum.add(a);
		}
		zombie zomb = new zombie(400,300);
		zm.add(zomb);
		
	}
	public void paint(Graphics g){
		super.paint(g);
		//Draw the black background as city
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		
		//Draw human
		for(int i=0;i<hum.size();i++){
			this.drawHum(g, hum.get(i).getX(), hum.get(i).getY());
		}
		//Draw infected
		for(int i=0;i<infect.size();i++){
			this.drawInf(g, infect.get(i).getX(), infect.get(i).getY());
		}
		//Draw zombies
		for(int i=0;i<zm.size();i++){
			this.drawZom(g, zm.get(i).getX(), zm.get(i).getY());
		}
	}
	
	public void drawHum(Graphics g, double x,double y){
		g.setColor(Color.GREEN);
		g.fill3DRect((int)x, (int)y, 3, 3, false);
	}
	
	public void drawInf(Graphics g, double x,double y){
		g.setColor(Color.yellow);
		g.fill3DRect((int)x, (int)y, 3, 3, false);
	}
	
	public void drawZom(Graphics g, double x,double y){
		g.setColor(Color.RED);
		g.fill3DRect((int)x, (int)y, 3, 3, false);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(100);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			for(int i=0;i<hum.size();i++){
				if(hum.get(i).at_umb(lansing.getUm_x(),lansing.um_y)==true){
					infected inf1 = new infected(hum.get(i).getX(),hum.get(i).getY());
					infect.addElement(inf1);
					hum.remove(i);
				}
				for(int j=0;j<zm.size();j++){
					if (hum.get(i).getX()==zm.get(j).getX()&&hum.get(i).getY()==zm.get(j).getY()){
						infected inf1 = new infected(hum.get(i).getX(),hum.get(i).getY());
						infect.addElement(inf1);
						hum.remove(i);
					}
				}
			}
			for(int i=0;i<infect.size();i++){
				if (infect.get(i).time==0){
					zombie zom = new zombie(infect.get(i).getX(),infect.get(i).getY());
					zm.add(zom);
					infect.remove(i);
				}
				for(int j=0;j<zm.size();j++){
					if (infect.get(i).getX()==zm.get(j).getX()&&infect.get(i).getY()==zm.get(j).getY()){
						infect.get(i).setLife(infect.get(i).getLife()-1);
						if(infect.get(i).getLife()==0){
							infect.remove(i);
						}
					}
				}
				
			}
			repaint();
		}	
	}
}
