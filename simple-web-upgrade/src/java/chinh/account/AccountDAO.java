/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.account;

import chinh.utils.DBUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean checkLogin(String lastName, String password) throws NoSuchAlgorithmException, SQLException, NamingException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = " select * from tblAccount where lastName = ? and password = ?";

                ps = con.prepareStatement(sql);
                ps.setString(1, lastName);
                ps.setString(2, password);

                rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    private List<AccountDTO> listAccount;

    public List<AccountDTO> getListAccount() {
        return listAccount;
    }

    public void searchLastName(String searchValue) throws SQLException, NamingException {
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "select * from tblAccount where lastName like ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");

                rs = ps.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String lastName = rs.getString("lastName");
                    String password = rs.getString("password");
                    String role = rs.getString("role");

                    AccountDTO dto
                            = new AccountDTO(userID, lastName, password, role);

                    if (this.listAccount == null) {
                        this.listAccount = new ArrayList<AccountDTO>();
                    }

                    this.listAccount.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void deleteByLastName(String userID, String lastName) {

        String sql = "delete from tblAccount where userID like ? and lastName like ?";
        try {
            con = new DBUtils().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, lastName);

            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public boolean updateByLastName(String lastName, String password, String role, String userID) throws SQLException, NamingException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "update tblAccount \n"
                        + "set lastName = ?, password= ?, role = ?\n"
                        + "where userID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, lastName);
                ps.setString(2, password);
                ps.setString(3, role);
                ps.setString(4, userID);

                int row = ps.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void createNewACcount(String userID, String lastName, String password, String role) throws NoSuchAlgorithmException {
        String sql = " insert into tblAccount(userID, lastName, password, role)\n"
                + "values(?, ?, ?, ?) ";
        try {
            con = new DBUtils().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, lastName);
            ps.setString(3, password);
            ps.setString(4, role);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public AccountDTO existUserID(String tempUserID) {
        String userID = tempUserID.toLowerCase().trim();

        String sql = " select * from tblAccount\n"
                + "where userID=? ";
        try {
            con = new DBUtils().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accUserID = rs.getString(1).trim();
                String lastName = rs.getString(2).trim();
                String password = rs.getString(3).trim();
                String role = rs.getString(4).trim();

                return new AccountDTO(accUserID, lastName, password, role);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, NamingException {
        AccountDAO dao = new AccountDAO();
//        System.out.println(dao.updateByLastName("SE111111","test","1","US"));
        System.out.println(dao.existUserID("SE140526"));
    }
}
