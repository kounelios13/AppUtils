package com.AppUtils.core;
public class XString{
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
			throw new NullPointerException();
		this.text.delete(0,length).append(txt);
		length = txt.length();
	}
	public String getText(){
		return toString();
	}
	public XString append(String name) {
		if(name == null)
			throw new NullPointerException();
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
	public XString(){}
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

