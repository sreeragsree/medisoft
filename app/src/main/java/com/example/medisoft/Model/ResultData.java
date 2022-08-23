package com.example.medisoft.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultData {

    @SerializedName("User_details")
    @Expose
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }


    @SerializedName("SupplierbyClient")
    @Expose
    private List<SupplierByClient> suppliern = null;

    public List<SupplierByClient> getSuppliern() {
        return suppliern;
    }

    public void setSuppliern(List<SupplierByClient> suppliern) {
        this.suppliern = suppliern;
    }
}