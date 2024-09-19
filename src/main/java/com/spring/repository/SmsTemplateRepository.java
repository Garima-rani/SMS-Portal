package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.CommunicationLog;
import com.spring.model.SMSTemplate;


public interface SmsTemplateRepository extends JpaRepository<SMSTemplate, Integer> {

	

	 SMSTemplate findBySmsId(Long smsId);

}
