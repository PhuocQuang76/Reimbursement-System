package com.revature.models;

import java.sql.Date;

public class ReimbursementDetail extends Reimbursement {
    private Date submittedDate;
    private Date approvedDate;
    private Date transactionDate;
    private Enum expenseType;
    private int typeId;
    private int amount;
    private String decision;
    private String receipt;


    public ReimbursementDetail(){};

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

    public Enum getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(Enum expenseType) {
        this.expenseType = expenseType;
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

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}
