package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.model.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}