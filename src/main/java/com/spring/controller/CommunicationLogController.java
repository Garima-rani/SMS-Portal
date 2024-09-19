package com.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.CommunicationLogService;

@RestController
@RequestMapping("/api/communication-logs")
public class CommunicationLogController {

    @Autowired
    private CommunicationLogService service;

    /**
     * Endpoint to get all communication log IDs.
     * 
     * @return ResponseEntity containing a list of IDs.
     */
    @GetMapping("/ids")
    public ResponseEntity<List<Long>> getAllIds() {
        try {
            List<Long> ids = service.getAllIds();
            return ResponseEntity.ok(ids);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            // For example: return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}