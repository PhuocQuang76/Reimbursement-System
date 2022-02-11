package com.revature.models;

import java.sql.Date;

public class ReimbursementDetail extends Reimbursement {
    private Date submittedDate;
    private Date createdDate;
    private Date approvedDeniedDate;
    private Date transactionDate;
    private int status;
    private int type;
    private double cost;
    private String description;


    //Constructor
    public ReimbursementDetail(){
        super();
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getApprovedDeniedDate() {
        return approvedDeniedDate;
    }

    public void setApprovedDeniedDate(Date approvedDeniedDate) {
        this.approvedDeniedDate = approvedDeniedDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
