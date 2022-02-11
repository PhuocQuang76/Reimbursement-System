package com.revature.dao;

import com.revature.utils.ConnectionUtil;

import java.sql.*;

public class ReimbursementDaoJDBC implements ReimbursementDao{
    ConnectionUtil connectionUtil = ConnectionUtil.getInstance();
    @Override
    public void createReimbursementRecord(){
        try{
            Connection con = connectionUtil.getConnection();
            String sql = "insert into ers_reimbursement(user_id,date_submitted,status_id,manager_id,date_approved_denied,title,description) \n" +
                    "values(?,?,?,?,?,?,?)";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setDate(2,new Date(12-12-2020));
            ps.setInt(3,1);
            ps.setInt(4,1);
            ps.setDate(5,null);
            ps.setString(6,"test");
            ps.setString(7,"test");

            ResultSet rs = ps.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
