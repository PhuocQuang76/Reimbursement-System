package com.revature.dao;

import com.revature.dto.ReimbursementHistoryDTO;
import com.revature.models.Reimbursement;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ReimbursementDao {
    public boolean createReimbursementRecord(int userId, int managerId, String tittle, String description, int status,
                                             Date submittedDate, Date transactionDate, int typeId, double amount) throws SQLException;

    public boolean updateReimbursement(Reimbursement reimbursement);

    public List<ReimbursementHistoryDTO> getPendingReimbursement(int userId) throws SQLException;

    public List<ReimbursementHistoryDTO>  getResolvedReimbursement(int userId) throws SQLException;
}
