package com.example.medisoft.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetails {

    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Active")
    @Expose
    private Integer active;
    @SerializedName("Admin")
    @Expose
    private Integer admin;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("ClientName")
    @Expose
    private String clientname;

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}