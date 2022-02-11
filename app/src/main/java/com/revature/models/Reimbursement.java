package com.revature.models;

import java.sql.Date;

public class Reimbursement {
    private int reimbursementID;
    private int userId;
    private Date submittedDate;
    private int managerId;
    private Date approvedDeniedDate;
    private String title;
    private String description;

    //Constructors
    public Reimbursement(){

    };

    public Reimbursement(int userId,Date submittedDate,int managerId,Date approvedDeniedDate,String title, String description){
        this.userId = userId;
        this.submittedDate = submittedDate;
        this.managerId = managerId;
        this.approvedDeniedDate = approvedDeniedDate;
        this.title = title;
        this.description = description;
    }

    //Getter and setter


    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getApprovedDeniedDate() {
        return approvedDeniedDate;
    }

    public void setApprovedDeniedDate(Date approvedDeniedDate) {
        this.approvedDeniedDate = approvedDeniedDate;
    }
}
