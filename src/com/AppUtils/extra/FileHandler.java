package com.AppUtils.extra;
import static messages.Message.error;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//@SuppressWarnings("unused")
/*
* This class is used to handle an file operations like copying
* */
@SuppressWarnings("all")
public class FileHandler{
	private static String sep = File.separator + File.separator;
	private static boolean logApplicationErrors = true;
	private ResourceLoader loader = new ResourceLoader(this);
	public static void setAdvancedLogs(boolean value){
		/*
		 * Decide if we want to log errors messages that were not caused by an exception
		 * but from a mistake made by the user
		 * **/
		logApplicationErrors = value;
	}
	public static boolean isNull(Object... items){
		for(Object o:items)
			if(o==null)
				return true;
		return false;
	}
	public static void log(Throwable th){
		log(th.getMessage());
	}
	public static void log(String message){
		File logFile = new File("app"+sep+"log.txt"),
				dir	 = new File("app");
		/**
		 * Make sure that 'app' directory exists 
		 * before creating log file*/
		if(!dir.exists())
			dir.mkdirs();
		if(!logFile.exists())
			try {
				logFile.createNewFile();
			} catch (IOException exc) {
				String errorMessage = 
						(logFile.exists()?"IOException occured:":"Couldn't create log file:")
							+"\n"+exc.getMessage();	
				error(errorMessage);
				if(logFile.exists())
					log(errorMessage);
				return;
			}
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));//Append to file
				StringBuilder str = new StringBuilder();
				str.append(System.lineSeparator()+"\t||||--------_Log Message_-------||||\n");
				str.append(System.lineSeparator()+message);
				writer.write(str.toString());
				writer.close();
			} catch (IOException exc) {
				if(!logFile.canWrite())
				{
					logFile.setWritable(true);
					if(logFile.canWrite())
						log(message);
					else
						error("Cannot write to log file.Please change permissions manually");
				}
				else
					error("IOException :"+exc.getMessage());
				if(logFile.exists() && logFile.canWrite())
					log(exc);
			}
	}
	public FileHandler(){
	}
	
	
}
