package com.productapp.user;
import java.util.regex.*; 

public class UserValidation { 
  
    public static boolean isValidUsername(String userName) 
    { 
    	
        String regex = "^[A-Za-z]\\w{5,29}$"; 
  
   
        Pattern p = Pattern.compile(regex); 
  
        if (name == null) { 
            return false; 
        } 
        Matcher m = p.matcher(userName); 
  
        
        return m.matches(); 
    } 
    
    
    public static boolean
    isValidPassword(String password) 
    { 
  
       
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$"; 
  
     
        Pattern p = Pattern.compile(regex); 
  
       
        if (password == null) { 
            return false; 
        } 
  
       
        Matcher m = p.matcher(password); 
  
       
        return m.matches(); 
    } 
} 

