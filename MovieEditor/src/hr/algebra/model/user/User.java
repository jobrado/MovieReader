/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model.user;

/**
 *
 * @author Jo
 */
public class User {

    private int ID;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;
    private int UserRoleID;

    public User(String FirstName, String LastName, String Username, String Password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Username = Username;
        this.Password = Password;

    }

    public User(int ID, String FirstName, String LastName, String Username, String Password, int UserRoleID) {
        this(FirstName, LastName, Username, Password);
        this.ID = ID;

        this.UserRoleID = UserRoleID;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public User(String Username, String Password, int UserRoleID) {

        this.Username = Username;
        this.Password = Password;
        this.UserRoleID = UserRoleID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUserRoleID() {
        return UserRoleID;
    }

    public void setUserRoleID(int UserRoleID) {
        this.UserRoleID = UserRoleID;
    }

}
