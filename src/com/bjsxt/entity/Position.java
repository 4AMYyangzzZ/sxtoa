package com.bjsxt.entity;

public class Position {
    private int posId;
    private String pName;
    private String pDesc;

    public Position() {
    }

    public Position(int posId, String pName, String pDesc) {
        this.posId = posId;
        this.pName = pName;
        this.pDesc = pDesc;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posId=" + posId +
                ", pName='" + pName + '\'' +
                ", pDesc='" + pDesc + '\'' +
                '}';
    }
}
