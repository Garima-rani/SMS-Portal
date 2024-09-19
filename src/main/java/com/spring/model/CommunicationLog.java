package com.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "communication_logs")
public class CommunicationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @Column(name = "UserName")
//    private String userName;
//
//    @Column(name = "Latency")
//    private String latency;
//
//    @Column(name = "mobile_number")
//    private String mobileNumber;
//
//    @Column(name = "source_ip")
//    private String sourceIp;
//
//    @Column(name = "sms_account_id")
//    private String smsAccountId;

    @Column(name = "request_body", columnDefinition = "TEXT")
    private String requestBody;

    // Add other necessary columns here, based on your table structure
    // Example: @Column(name = "mobile_number") private String mobileNumber;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

		

	public CommunicationLog(Long id, String requestBody) {
	super();
	this.id = id;
//	this.userName = userName;
//	this.latency = latency;
//	this.mobileNumber = mobileNumber;
//	this.sourceIp = sourceIp;
//	this.smsAccountId = smsAccountId;
	this.requestBody = requestBody;
}

	

	public CommunicationLog() {
		super();
		// TODO Auto-generated constructor stub
	}
    

    // Add other getters and setters as required
}
