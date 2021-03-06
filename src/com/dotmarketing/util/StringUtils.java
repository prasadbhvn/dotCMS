package com.dotmarketing.util;

import java.util.regex.Pattern;

public class StringUtils {
	public static String formatPhoneNumber(String phoneNumber){
		try{
			String s = phoneNumber.replaceAll("\\(|\\)|:|-|\\.", "");;
			s = s.replaceAll("(\\d{3})(\\d{3})(\\d{4})(\\d{3})*", "($1) $2-$3x$4");
			
			if (s.endsWith("x"))
				s = s.substring(0,s.length()-1);
			return s;
		}
		catch(Exception ex){
			return "";
		}
	}
	
	public static String sanitizeCamelCase(String variable, boolean firstLetterUppercase){
		
		Boolean upperCase = firstLetterUppercase;
		String velocityvar = "";
		String re = "[^a-zA-Z0-9]+";
		Pattern p = Pattern.compile(re);
		
		for(int i=0;i < variable.length() ; i++){
			Character c = variable.charAt(i);
			if(upperCase){
				c=Character.toUpperCase(c);
			}
			else{
				c=Character.toLowerCase(c);
			}
			if(p.matcher(c.toString()).matches() ){
				upperCase = true;
			}
			else{
				upperCase = false;
				velocityvar+=c;
			}
		}
		velocityvar = velocityvar.replaceAll(re, "");
		return velocityvar; 
		
	}
	public static String sanitizeCamelCase(String variable){
		
		return sanitizeCamelCase(variable, false);
		
	}
}
