package com.codefactory.team3.model;

import javax.persistence.*;

@Entity
@Table(name = "login")

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loginid")
    private int id;
    @Column(name = "loginname")
    private String loginName;
    @Column(name = "loginpassword")
    private String loginPassword;
    @Column(name = "fk_userid")
    private int fk_userID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getFk_userID() {
        return fk_userID;
    }

    public void setFk_userID(int fk_userID) {
        this.fk_userID = fk_userID;
    }
}
