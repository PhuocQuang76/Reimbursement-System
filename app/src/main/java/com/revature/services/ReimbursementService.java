package com.revature.services;

import com.revature.dao.ReimbursementDao;
import com.revature.dto.ReimbursementHistoryDTO;
import com.revature.models.Reimbursement;

import javax.swing.plaf.PanelUI;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementService {
    ReimbursementDao reimbursementDao;

    public ReimbursementService(ReimbursementDao reimbursementDao) {
        this.reimbursementDao = reimbursementDao;
    }

    public boolean createReimbursementRecord(int userId, int managerId, String tittle, String description, int status,
                                             Date submittedDate, Date transactionDate,int typeId, double amount) throws SQLException {
        return reimbursementDao.createReimbursementRecord(userId,managerId,tittle,description,status,submittedDate,transactionDate,typeId,amount);
    }

    public List<ReimbursementHistoryDTO> getPendingReimbursement(int userId) throws SQLException {
        return reimbursementDao.getPendingReimbursement(userId);
    }

    public List<ReimbursementHistoryDTO> getResolvedReimbursement(int userId) throws SQLException {
        return reimbursementDao.getResolvedReimbursement(userId);
    }



}
