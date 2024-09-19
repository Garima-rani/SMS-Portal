package com.spring.model;

public class CommunicationLogDTO {
	
	    private Long id;
	    private String sourceIp;
	    private String latency;
	    private String userName;
	    private String mobileNumber;
	    private String smsAccountId;

	    public CommunicationLogDTO(Long id, String sourceIp, String latency, String userName, String mobileNumber, String smsAccountId) {
	        this.id = id;
	        this.sourceIp = sourceIp;
	        this.latency = latency;
	        this.userName = userName;
	        this.mobileNumber = mobileNumber;
	        this.smsAccountId = smsAccountId;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getLatency() {
	        return latency;
	    }
//
	    public void setLatency(String latency) {
	        this.latency = latency;
	    }

	    public String getMobileNumber() {
	        return mobileNumber;
	    }

	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }

	    public String getSourceIp() {
	        return sourceIp;
	    }

	    public void setSourceIp(String sourceIp) {
	        this.sourceIp = sourceIp;
	    }

	    public String getSmsAccountId() {
	        return smsAccountId;
	    }

	    public void setSmsAccountId(String smsAccountId) {
	        this.smsAccountId = smsAccountId;
	    }

}
