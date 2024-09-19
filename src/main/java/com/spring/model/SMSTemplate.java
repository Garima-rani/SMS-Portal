package com.spring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;






import jakarta.persistence.*;

@Entity
@Table(name = "sms_template")
public class SMSTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sms_id")
    private Long smsId;

    @Column(name = "sms_template_text", columnDefinition = "TEXT")
    private String smsTemplateText;

    // Getters and Setters
    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getSmsTemplateText() {
        return smsTemplateText;
    }

    public void setSmsTemplateText(String smsTemplateText) {
        this.smsTemplateText = smsTemplateText;
    }
}
