package com.own.test;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class MyPanel extends JPanel implements Runnable{
	Vector<zombie> hum = new Vector<zombie>();
	Vector<zombie> infected = new Vector<zombie>();
	Vector<zombie> zm = new Vector<zombie>();
	
	public MyPanel(){
		
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
		for(int i=0;i<infected.size();i++){
			this.drawInf(g, infected.get(i).getX(), infected.get(i).getY());
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
				repaint();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
