package com.board.games.bean;

import java.util.Date;

public class GamePartake {
    private Integer id;

    private String userId;

    private String launchId;

    private Date partakeTime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLaunchId() {
        return launchId;
    }

    public void setLaunchId(String launchId) {
        this.launchId = launchId;
    }

    public Date getPartakeTime() {
        return partakeTime;
    }

    public void setPartakeTime(Date partakeTime) {
        this.partakeTime = partakeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}