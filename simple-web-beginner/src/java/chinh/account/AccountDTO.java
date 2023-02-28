/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.account;

/**
 *
 * @author Admin
 */
public class AccountDTO {

    private String userID;
    private String lastName;
    private String password;
    private String role;

    public AccountDTO() {
    }

    public AccountDTO(String userID, String lastName, String password, String role) {
        this.userID = userID;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "userID=" + userID + ", lastName=" + lastName + ", password=" + password + ", role=" + role + '}';
    }

}
