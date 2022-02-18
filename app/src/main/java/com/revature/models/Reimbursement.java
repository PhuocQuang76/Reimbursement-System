package com.revature.models;

import java.util.Date;

public class Reimbursement {
    private int reimbursementId;
    private int userId;
    private int managerId;
    private String title;
    private String description;
    private int status;
    private Date submittedDate;
    private Date approvedDate;
    private Date transactionDate;
    private int typeId;
    private int amount;
//    private String receipt;

    public Reimbursement(){};

    public Reimbursement(int reimbursementId, int userId, int managerId, String tittle, String description, int status,
                         Date submittedDate,Date approvedDate,Date transactionDate,int typeId,int amount){
        this.reimbursementId = reimbursementId;
        this.userId = userId;
        this.managerId = managerId;
        this.title = tittle;
        this.description = description;
        this.status = status;
        this.submittedDate = submittedDate;
        this.approvedDate = approvedDate;
        this.transactionDate = transactionDate;
        this.typeId = typeId;
        this.amount = amount;

    }


    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getUserID() {
        return userId;
    }

    public void setUserID(int userId) {
        this.userId = userId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerID(int managerId) {
        this.managerId = managerId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
