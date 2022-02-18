package com.revature.dto;

import com.revature.models.Reimbursement;

import java.sql.Date;

public class ReimbursementHistoryDTO {
    private int userId;
//    Reimbursement reimbursement;
    private int reimbursementId;
    private String firstName;
    private String lastName;
    private String status;
    private Date submittedDate;
    private String title;
    private String reimbursementType;
    private double amount;
    private Date transactionDate;
    private Date approvedDate;


    public ReimbursementHistoryDTO (){};
    public ReimbursementHistoryDTO (int userId,int reimbursementId,String firstName,String lastName,String status,
                                    Date submittedDate,String title,String reimbursementType,double amount,Date transactionDate,Date approvedDate){
        this.userId = userId;
        this.reimbursementId = reimbursementId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.submittedDate = submittedDate;
        this.title = title;
        this.reimbursementType = reimbursementType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.approvedDate = approvedDate;

    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }
}
