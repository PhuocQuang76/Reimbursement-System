package com.revature.dao;

import com.revature.dto.ReimbursementHistoryDTO;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReimbursementDaoJDBC implements ReimbursementDao{
    private String pattern = "yyyy-MM-dd";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    ConnectionUtil connectionUtil = ConnectionUtil.getInstance();

    @Override
    public boolean createReimbursementRecord(int userId, int managerId, String tittle, String description, int status,
                                             Date submittedDate, Date transactionDate,int typeId, double amount) throws SQLException {
        String sql = "insert into ers_reimbursement(user_id, date_submitted,status_id,manager_id,date_approved_denied,title,description,type_id ,cost,transaction_date) \n" +
                "values(?,?,?,?,?,?,?,?,?,?) RETURNING reimbursement_id";

        //Because default of autoCommit is trueConnection
        Connection con = connectionUtil.getConnection();
        con.setAutoCommit(false);
        try {
            if(userId < 7){
                managerId = 1;
            }else{
                managerId = 2;
            }
            PreparedStatement ps = con.prepareStatement(sql);
            //Set type as param for all indexes
            ps.setInt(1, userId);
            ps.setDate(2,java.sql.Date.valueOf(simpleDateFormat.format(LocalDate.now())));
            ps.setInt(3,2);
            ps.setInt(4, managerId);
            ps.setDate(5,java.sql.Date.valueOf(simpleDateFormat.format(null)));
            ps.setString(6, tittle);
            ps.setString(7, description);
            ps.setInt(8,typeId);
            ps.setDouble(9,amount);
            ps.setDate(10,transactionDate);

            ResultSet rs = ps.executeQuery();

            int returnReimbursementId = 0;
            if (rs.next()) {
                returnReimbursementId = rs.getInt(1);

                System.out.println("reimbursementId: " + returnReimbursementId);

                //Second statement
                //Prepare for another statement set value into ers_reimbursement_history
                String sql2 = "insert into ers_reimbursement_history (user_id,reimbursement_id," +
                        "create_date,date_submitted,status_id,date_approved_denied)\n" +
                        "values(?,?,?,?,?,?);";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, userId);
                ps2.setInt(2, returnReimbursementId);
                ps2.setDate(3,new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                ps2.setInt(4,2);
                ps2.setDate(5,java.sql.Date.valueOf(simpleDateFormat.format(null)));

                ps2.execute();

            }

            if (returnReimbursementId != 0) {
                con.commit();
                return true;
            } else {
                con.rollback();
                return false;
            }
        }finally{
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    @Override
    public List<ReimbursementHistoryDTO> getPendingReimbursement(int userId) throws SQLException {
        List<ReimbursementHistoryDTO> pendingLists = new ArrayList<>();
        ReimbursementHistoryDTO pendingItem;
        String firstName ="";
        String lastName ="";
        //String reimbursementType = "TRAVEL";
        int typeId = 0;
        int reimbursementId = 0;
        int userID = 0;
        Date submittedDate = null;
        String status = "PENDING";
        String title = "";
        double amount = 0;
        Date transactionDate = null;
        Date resolvedDate = null;
        String reimbursementType = "FOOD";

        String sql1 = "select first_name, last_name from ers_users where user_id = ?;";
        Connection con = connectionUtil.getConnection();
        con.setAutoCommit(false);
        try {
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                firstName = rs1.getString(1);
                lastName = rs1.getString(2);
            }

            //Second statement
            String sql2 = "select reimbursement_id,user_id,date_submitted,date_approved_denied,title," +
                    "type_id,cost,transaction_date " +
                    "from ers_reimbursement where user_id = ? and status_id = 2";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, userId);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                reimbursementId = rs2.getInt(1);
                System.out.println("reimbursementId: "+ reimbursementId);

                userID = rs2.getInt(2);
                submittedDate = rs2.getDate(3);
                title = rs2.getString(5);
                typeId = rs2.getInt(6);
                amount = rs2.getDouble(7);
                transactionDate = rs2.getDate(8);
                resolvedDate = rs2.getDate(4);


//                String sql3 = "select reimbursement_type from ers_reimbursement_type where reimbursement_type_id = ?";
//                PreparedStatement ps3 = con.prepareStatement(sql3);
//                ps3.setInt(1,typeId);
//                ResultSet rs3 = ps3.executeQuery();
//                while (rs3.next()) {
                switch (typeId){
                    case 1:
                        reimbursementType = "LODGING";
                        break;
                    case 2:
                        reimbursementType = "TRAVEL";
                        break;
                    case 3:
                        reimbursementType = "FOOD";
                        break;
                    case 4:
                        reimbursementType = "OTHER";
                        break;
                }
                System.out.println("reimbursementType: "+ reimbursementType);
                pendingItem = new ReimbursementHistoryDTO(userId, reimbursementId, firstName, lastName, status, submittedDate,
                        title, reimbursementType, amount, transactionDate, resolvedDate);
                pendingLists.add(pendingItem);
                //}
                System.out.println("reimbursementType2: "+ reimbursementType);
            }
           con.commit();

        } finally {
            if (con != null && !con.isClosed())
                con.close();
        }
        return pendingLists;
    };

    @Override
    public List<ReimbursementHistoryDTO>  getResolvedReimbursement(int userId) throws SQLException{
        List<ReimbursementHistoryDTO> resolvedLists = new ArrayList<>();
        ReimbursementHistoryDTO resolvedList;
        String firstName ="";
        String lastName ="";
        int typeId = 0;
        int reimbursementId = 0;
        int userID = 0;
        Date submittedDate = null;
        String status = "";
        String title = "";
        double amount = 0;
        Date transactionDate = null;
        Date resolvedDate = null;
        String reimbursementType = "";

        String sql1 = "select first_name, last_name from ers_users where user_id = ?;";
        Connection con = connectionUtil.getConnection();
        con.setAutoCommit(false);
        try {
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                firstName = rs1.getString(1);
                lastName = rs1.getString(2);
            }

            //Second statement
            String sql2 = "select reimbursement_id,user_id,date_submitted,status_id,date_approved_denied,title," +
                    "type_id,cost,transaction_date " +
                    "from ers_reimbursement where user_id = ? and status_id = 3 or user_id = ? and status_id = 4";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, userId);
            ps2.setInt(2, userId);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                reimbursementId = rs2.getInt(1);
                System.out.println("reimbursementId: "+ reimbursementId);
                userID = rs2.getInt(2);
                submittedDate = rs2.getDate(3);
                int statusId = rs2.getInt(4);
                title = rs2.getString(6);
                typeId = rs2.getInt(7);
                amount = rs2.getDouble(8);
                transactionDate = rs2.getDate(9);
                resolvedDate = rs2.getDate(5);
                switch (statusId){
                    case 3:
                        status = "APPROVED";
                        break;
                    case 4:
                        status = "DENIED";
                        break;
                }

                switch (typeId){
                    case 1:
                        reimbursementType = "LODGING";
                        break;
                    case 2:
                        reimbursementType = "TRAVEL";
                        break;
                    case 3:
                        reimbursementType = "FOOD";
                        break;
                    case 4:
                        reimbursementType = "OTHER";
                        break;
                }
                System.out.println("reimbursementType: "+ reimbursementType);
                resolvedList = new ReimbursementHistoryDTO(userId, reimbursementId, firstName, lastName, status, submittedDate,
                        title, reimbursementType, amount, transactionDate, resolvedDate);
                resolvedLists.add(resolvedList);
                //}
                System.out.println("reimbursementType2: "+ reimbursementType);
            }
            con.commit();

        } finally {
            if (con != null && !con.isClosed())
                con.close();
        }
        return resolvedLists;
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursementId){

//        String sql = "insert into ers_reimbursement(user_id,manager_id,title,description,status_id) \n" +
//                "values(?,?,?,?,?) RETURNING reimbursement_id;";
//
//        //Because default of autoCommit is trueConnection
//        Connection con = connectionUtil.getConnection();
//        con.setAutoCommit(false);
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            //Set type as param for all indexes
//            ps.setInt(1, reimbursement.getUserId());
//            ps.setInt(2, reimbursement.getManagerId());
//            ps.setString(3, reimbursement.getTitle());
//            ps.setString(4, reimbursement.getDescription());
//            ps.setInt(5, reimbursement.getStatus());
//
//            ResultSet rs = ps.executeQuery();
//
//            int returnReimbursementId = 0;
//            if (rs.next()) {
//                returnReimbursementId = rs.getInt(1);
//                System.out.println("reimbursementId: " + returnReimbursementId);
//
//                //Prepare for another statement set value into ers_reimbursement_history
//                String sql2 = "insert into ers_reimbursement_history(user_id,reimbursement_id,create_date,status_id)\n" +
//                        "values(?,?,?,?);";
//                PreparedStatement ps2 = con.prepareStatement(sql2);
//                ps2.setInt(1, reimbursement.getUserID());
//                ps2.setInt(2, returnReimbursementId);
//                ps2.setDate(3, reimbursement.getCreatedDate());
//                ps2.setInt(4, reimbursement.getStatus());
//
//                ps2.execute();
//            }
//
//            if (returnReimbursementId != 0) {
//                con.commit();
//                return true;
//            } else {
//                con.rollback();
//                return false;
//            }
//        }finally{
//            if (con != null && !con.isClosed()) {
//                con.close();
//            }
//        }
        return false;
    }
}
