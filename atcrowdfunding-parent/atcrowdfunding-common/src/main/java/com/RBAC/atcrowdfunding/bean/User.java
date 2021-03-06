package com.RBAC.atcrowdfunding.bean;

public class User {

    private Integer id;
    private String username;
    private String loginacct;
    private String userpswd;
    private String email;
    private String createtime;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Integer id, String username, String loginacct, String userpswd, String email) {
        this.id = id;
        this.username = username;
        this.loginacct = loginacct;
        this.userpswd = userpswd;
        this.email = email;
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }

    public String getUserpswd() {
        return userpswd;
    }

    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd;
    }

    public User() {
    }

    public User(Integer id, String username, String loginacct, String userpswd) {
        this.id = id;
        this.username = username;
        this.loginacct = loginacct;
        this.userpswd = userpswd;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginacct='" + loginacct + '\'' +
                ", userpswd='" + userpswd + '\'' +
                '}';
    }
}
