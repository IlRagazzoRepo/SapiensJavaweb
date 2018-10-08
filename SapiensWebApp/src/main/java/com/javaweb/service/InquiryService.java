package com.javaweb.service;

import java.util.Collection;
import java.util.List;

import com.javaweb.model.Inquiry;

public interface InquiryService {

    Collection<Inquiry> findAll();

    Collection<Inquiry> findAllSortedByLastName();
    
    Inquiry findOne(Long id);

    Inquiry create(Inquiry inquiry);

    void update(Inquiry inquiry);

    void delete(Inquiry inquiry);

}
