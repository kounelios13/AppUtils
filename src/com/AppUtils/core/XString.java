package com.AppUtils.core;
public class XString{
	/**
	 * A class that tries to mimic StringBuilder
	 * */
	private StringBuilder text = new StringBuilder();
	private int length = 0;
	public int length(){
		return length;
	}
	public void setText(String txt){
		/**
		 * Clear the current string builder and the append the received string
		 * */
		if(text == null)
			throw new NullPointerException("Cannot set to null");
		this.text.delete(0,length).append(txt);
		length = txt.length();
	}
	public String getText(){
		return toString();
	}
	public XString append(String name) {
		if(name == null)
			throw new NullPointerException("Can't append null");
		this.text.append(name);
		length +=name.length(); 
		return this;
	}
	public void appendNewLine(){
		this.text.append("\n");
	}
	public void appendNewLine(int times){
		for(int i=0;i<Math.abs(times);i++)
			appendNewLine();
	}
	public XString reverse(){
		 text.reverse();
		 return this;
	}
	public void clear(){
		length = 0;
		setText("");
	}
	@Override
	public String toString(){
		return text.toString();
	}
	/**
	 * Create an empty instance of XString
	 * which means an empty StringBuilder with a length of 0
	 * **/
	public XString(){}
	/*
	 * @param message Content of the StringBuffer
	 * **/
	public XString(String message){
		this.text.append(message);
		length = message.length();
	}
	public XString(CharSequence s){
		this.text.append(s);
		length = s.length();
	
	}
	public XString(char[] e){
		this.text.append(e);
		length = e.length;
	}
	public boolean isEmpty(){
		return length < 1;
	}
}

