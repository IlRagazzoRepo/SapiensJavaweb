package com.javaweb.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.Inquiry;
import com.javaweb.service.InquiryService;

@RestController
@SessionScoped
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;
    
    private Inquiry inquiry = new Inquiry();
    
    public Collection<Inquiry> getInquiries() {
        Collection<Inquiry> inquiries = inquiryService.findAll();
        return inquiries;
    }
    
    public Collection<Inquiry> getInquiriesSortedByLastName() {
        Collection<Inquiry> inquiries = inquiryService.findAllSortedByLastName();
        return inquiries;
    }
    
    public Inquiry getInquiry( Long id) {
        Inquiry inquiry = inquiryService.findOne(id);
        if (inquiry == null) {
            return null;
        }
        return inquiry;
    }

    public String createInquiry() {
    	Date date = Calendar.getInstance().getTime();
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String today = null;
         try {
        	 today = formatter.format(date);
             inquiry.setTimeStamp(today);
         } catch (Exception e) {
             e.printStackTrace();
         }
   
    	this.inquiryService.create(inquiry);
    	this.inquiry = new Inquiry();
    	return "inquiries";
    }
    
    public String addInquiry() {
    	this.inquiry = new Inquiry();
    	return "add_inquiry";
    }

    public void updateInquiry(Inquiry inquiry) {
        inquiryService.update(inquiry);
    }
    
    public void deleteInquiry(Inquiry inquiry){
		this.inquiryService.delete(inquiry);
	}
    
    public String editInquiry(Inquiry inquiry){
		this.inquiry = inquiry;
		return "edit_inquiry";
	}
	
	public String editInquiry(){
		this.inquiryService.update(this.inquiry);
		//this.inquiry = new Inquiry();
		return "inquiries";
	}
 
    public Inquiry getInquiry() {
	  	return inquiry;
	  }
	
	public void setInquiry(Inquiry inquiry) {
	  	this.inquiry = inquiry;
	}
    
}