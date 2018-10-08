package com.javaweb.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaweb.model.Inquiry;
import com.javaweb.repository.InquiryRepository;

@Named
@ViewScoped
public class InquiryView implements Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private InquiryRepository inquiryRepository;

  private List<Inquiry> inquiries;
  
@PostConstruct
  public void init() {
    inquiries = inquiryRepository.findAll();
  }

  public List<Inquiry> getInquiries() {
    return inquiries;
  }

}
