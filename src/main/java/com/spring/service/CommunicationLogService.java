package com.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.CommunicationLogRepository;


import com.spring.model.CommunicationLog;


@Service
public class CommunicationLogService {

    @Autowired
    private CommunicationLogRepository repository;

    public List<Long> getAllIds() {
        try {
            return repository.findAllIds();
        } catch (Exception e) {
            // Log the exception and/or rethrow it as a custom exception
            // For example: throw new CustomException("Failed to fetch IDs", e);
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list or handle accordingly
        }
    }
}