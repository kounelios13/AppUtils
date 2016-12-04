package com.AppUtils.core;

/**
 * 
 * @author Manos Kounelakis
 * **/
public class XString{
	/**
	 * A class that tries to mimic StringBuilder
	 * */
	private StringBuilder text = new StringBuilder();
	private int length = 0;
	/**
	 *@return The length of the string builder
	 * */
	public int length(){
		return length;
	}
	/**
	 * Set the text of the string builder
	 * @param txt the text for the string builder to be set to
	 * * */
	public void setText(String txt){
		
		if(text == null)
			throw new NullPointerException("Cannot set to null");
		this.text.delete(0,length).append(txt);
		length = txt.length();
	}
	/***
	 * @return the text of the string builder
	 * **/
	public String getText(){
		return toString();
	}
	/**
	 * 
	 * Append a new string to the string builder
	 * @param name the text to append
	 * @return the current XString Object
	 * ***/
	public XString append(String name) {
		if(name == null)
			throw new NullPointerException("Can't append null");
		this.text.append(name);
		length +=name.length(); 
		return this;
	}
	/**
	 * Append a new line to the current String Builder
	 * @return the object that called the method
	 * */
	public XString appendNewLine(){
		this.text.append("\n");
		return this;
	}
	
	/**
	 * 
	 * 
	 * Append times new line to the current String Builder
	 * @param times The number of new line character to append 
	 * @return the object that called the method
	 * */
	public XString appendNewLine(int times){
		
		for(int i=0;i<Math.abs(times);i++)
			appendNewLine();
		return this;
	}
	/**
	 * Reverse the contents of the string builder
	 * @return The current XString object
	 * */
	public XString reverse(){
		 text.reverse();
		 return this;
	}
	/**
	 * 
	 * 
	 * Clear the contents of the string builder
	 * @return The current XString object
	 * **/
	public XString clear(){
		
		length = 0;
		setText("");
		return this;
	}
	/**
	 * @return  True if the string builder is empty else false
	 * */
	public boolean isEmpty(){
		return length < 1;
	}
	@Override
	public String toString(){
		return text.toString();
	}
	
	public XString(){
		
		/**
		 * 
		 * Create an empty instance of XString
		 * which means an empty StringBuilder with a length of 0
		 * **/
	}
	
	public XString(String message){
		/**
		 * 
		 * Create an instance of XString that contains message
		 *@param message Content of the StringBuilder
		 * **/
		this.text.append(message);
		length = message.length();
	}
	
	/**
	 * 
	 * 	 
	 * @param s Content of the StringBuilder
	 * **/
	public XString(CharSequence s){
		
		
		this.text.append(s);
		length = s.length();
	
	}
	
	public XString(char[] e){
		/**
		 * @param e Content of the StringBuilder
		 * **/
		this.text.append(e);
		length = e.length;
	}

}

