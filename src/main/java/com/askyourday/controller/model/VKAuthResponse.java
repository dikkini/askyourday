package com.askyourday.controller.model;

import com.google.gson.annotations.SerializedName;

/**
 * akarapetov
 * com.askyourday.controller.model
 * fycapp
 * 11.01.2017
 */
public class VKAuthResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("expires_in")
    private Integer expiresIn;

    @SerializedName("email")
    private String email;

    @SerializedName("error")
    private String error;

    public String getAccessToken() {
        return accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getError() {
        return error;
    }
}
