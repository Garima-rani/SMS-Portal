package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.CommunicationLog;
import com.spring.service.SmsService;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    // Endpoint to fetch the generated SMS message based on the ID
    @GetMapping("/generate/{id}")
    public String generateSms(@PathVariable Long id) {
        try {
            return smsService.generateSmsMessage(id);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    @GetMapping("/logs")
    public List<CommunicationLog> getAllCommunicationLogs() {
        return smsService.getAllCommunicationLogs();
    }

    @GetMapping("/{id}")
    public CommunicationLog getCommunicationLogById(@PathVariable Long id) {
        return smsService.getCommunicationLogById(id);
    }
}