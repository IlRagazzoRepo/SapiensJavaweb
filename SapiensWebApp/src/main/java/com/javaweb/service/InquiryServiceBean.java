package com.javaweb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.javaweb.util.HibernateUtil;
import com.javaweb.model.Inquiry;
import com.javaweb.repository.InquiryRepository;

@Service
public class InquiryServiceBean implements InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;
    
    private Environment env;
    
   // String keyValue = env.getProperty(key);

    @Override
    public Collection<Inquiry> findAll() {
        Collection<Inquiry> inquirys = inquiryRepository.findAll();
        return inquirys;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Collection<Inquiry> findAllSortedByLastName() {
    	 Collection<Inquiry> inquirys = inquiryRepository.findAll(new Sort(Sort.Direction.ASC, "lastName"));
         return inquirys;
    }

    @Override
    public Inquiry findOne(Long id) {

        Inquiry inquiry = inquiryRepository.findOne(id);

        return inquiry;
    }

    @Override
    public Inquiry create(Inquiry inquiry) {
        if (inquiry.getId() != null) {
            return null;
        }
        Inquiry savedInquiry = inquiryRepository.save(inquiry);
        return savedInquiry;
    }

    @Override
    public void update(Inquiry inquiry) {
        Inquiry inquiryToUpdate = findOne(inquiry.getId());
        
        if (inquiryToUpdate == null) {
            // Cannot update Inquiry that hasn't been persisted
            return;
        }

        inquiryToUpdate = inquiry;
        inquiryRepository.save(inquiryToUpdate);
    }

    @Override
    public void delete(Inquiry inquiry) {
        inquiryRepository.delete(inquiry);
    }
}
