package com.AppUtils.gui;

import com.AppUtils.interfaces.IView;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public abstract class View extends JFrame implements IView{
	public View(String title,int width,int height){
		this.setTitle(title);
		this.setSize(width, height);
	}
	public View(String title,int width,int height,boolean resizable){
		this(title,width,height);
		this.setResizable(resizable);
	}
	public abstract String toString();
	protected abstract void initUIElements();
	@Override
	public void toggleUI(){
		this.setVisible(!this.isVisible());
	}
}	