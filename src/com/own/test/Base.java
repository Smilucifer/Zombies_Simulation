package com.own.test;
import javax.swing.*;
import java.awt.*;

public class Base extends JFrame{	
	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new Base();
	}
	
	public Base(){
		mp = new MyPanel();
		this.add(mp);
		Thread t = new Thread(mp);
		t.start();
		
		this.setSize(1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
