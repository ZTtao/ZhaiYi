package pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto;

import java.util.Date;

/**
 * @author ZhangZhentao
 *         2017-08-06
 */
public class Manager {
    private int managerId;
    private String account;
    private String password;
    private int auth;
    private Date createdDate;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
