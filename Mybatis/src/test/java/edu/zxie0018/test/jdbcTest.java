package edu.zxie0018.test;

import org.junit.Test;

import java.sql.*;

public class jdbcTest {

    @Test
    public void Test1() {
        Connection con = null;

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm_mybatis", "root", "rootpwd!");

            String sql = "SELECT * FROM user WHERE u_sex =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "Male");
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("u_id"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }



    }


}
