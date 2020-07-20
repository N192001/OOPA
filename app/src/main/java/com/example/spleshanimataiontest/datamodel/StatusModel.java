package com.example.spleshanimataiontest.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StatusModel implements Serializable {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("status")
        @Expose
        private String status;

        @SerializedName("message")
        @Expose
        private String message;

        @SerializedName("order_hdrs")
        @Expose
        private String order_hdrs;

        @SerializedName("sync_time")
        @Expose
        private String sync_time;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOrder_hdrs() {
            return order_hdrs;
        }

        public void setOrder_hdrs(String order_hdrs) {
            this.order_hdrs = order_hdrs;
        }

        public String getSync_time() {
            return sync_time;
        }

        public void setSync_time(String sync_time) {
            this.sync_time = sync_time;
        }
    }

    public class UserDetails {
        @SerializedName("role")
        @Expose
        private String role;

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("subscribed_user")
        @Expose
        private Integer subscribedUser;
        @SerializedName("subscribed_msg")
        @Expose
        private String subscribedMsg;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile_no")
        @Expose
        private String mobileNo;
        @SerializedName("profile_img")
        @Expose
        private String profileImg;

        public String getUserrole() {
            return role;
        }

        public String getUsername() {
            return username;
        }

        public void setUserrole(String role) {
            this.role = role;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Integer getSubscribedUser() {
            return subscribedUser;
        }

        public void setSubscribedUser(Integer subscribedUser) {
            this.subscribedUser = subscribedUser;
        }

        public String getSubscribedMsg() {
            return subscribedMsg;
        }

        public void setSubscribedMsg(String subscribedMsg) {
            this.subscribedMsg = subscribedMsg;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getProfileImg() {
            return profileImg;
        }

        public void setProfileImg(String profileImg) {
            this.profileImg = profileImg;
        }

    }
}