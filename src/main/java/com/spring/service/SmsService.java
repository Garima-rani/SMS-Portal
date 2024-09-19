package com.spring.service;



import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.CommunicationLog;
import com.spring.model.SMSTemplate;
import com.spring.repository.CommunicationLogRepository;
import com.spring.repository.SmsTemplateRepository;

import java.util.HashMap;
import java.util.List;
@Service
public class SmsService {

    @Autowired
    private CommunicationLogRepository communicationLogRepository;

    @Autowired
    private SmsTemplateRepository smsTemplateRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Method to fetch and process the SMS message
    public String generateSmsMessage(Long id) throws Exception {
        // Fetch the communication log entry by ID
        Optional<CommunicationLog> logOptional = communicationLogRepository.findById(id);

        if (logOptional.isPresent()) {
            CommunicationLog log = logOptional.get();

            // Parse the request_body JSON
            Map<String, Object> requestBodyMap = objectMapper.readValue(log.getRequestBody(), Map.class);

            // Extract the SmsBody and SmsId from the request_body JSON
            Map<String, String> smsBody = (Map<String, String>) requestBodyMap.get("SmsBody");
            Long smsId = Long.valueOf(requestBodyMap.get("SmsId").toString());

            // Fetch the SMS template from the sms_template table using the SmsId
            SMSTemplate smsTemplate = smsTemplateRepository.findBySmsId(smsId);
            if (smsTemplate == null) {
                throw new Exception("No SMS template found for SmsId: " + smsId);
            }

            // Populate the template with values from SmsBody
            return populateTemplate(smsTemplate.getSmsTemplateText(), smsBody);
        } else {
            throw new Exception("Communication log entry not found for id: " + id);
        }
    }

    // Method to replace placeholders in the template
    private String populateTemplate(String template, Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()) {
            template = template.replace("{#" + entry.getKey() + "#}", entry.getValue());
        }
        return template;
    }
    
    public List<CommunicationLog> getAllCommunicationLogs() {
        return communicationLogRepository.findAll();
    }

    public CommunicationLog getCommunicationLogById(Long id) {
        return communicationLogRepository.findById(id).orElse(null);
    }
}

