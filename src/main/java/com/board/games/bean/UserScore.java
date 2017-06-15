package com.board.games.bean;

public class UserScore {
    private Integer id;

    private String partakeId;

    private String evaluateUserId;

    private String beEvaluatedUserId;

    private String score;

    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartakeId() {
        return partakeId;
    }

    public void setPartakeId(String partakeId) {
        this.partakeId = partakeId;
    }

    public String getEvaluateUserId() {
        return evaluateUserId;
    }

    public void setEvaluateUserId(String evaluateUserId) {
        this.evaluateUserId = evaluateUserId;
    }

    public String getBeEvaluatedUserId() {
        return beEvaluatedUserId;
    }

    public void setBeEvaluatedUserId(String beEvaluatedUserId) {
        this.beEvaluatedUserId = beEvaluatedUserId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}