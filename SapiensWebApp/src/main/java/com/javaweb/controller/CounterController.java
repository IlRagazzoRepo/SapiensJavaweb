package com.javaweb.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class CounterController implements Serializable {
     
    private int number;
    
    public String countChars(String s) {
    	if(s.length()>150){
    		return Integer.toString(s.length()) + " Excede los 150 caracteres";
    	} else {
    		return Integer.toString(s.length()) + " No excede los 150 caracteres";
    	}
    }
 
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number++;
    }
}
