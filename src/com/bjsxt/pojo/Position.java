package com.bjsxt.pojo;

public class Position {
    private Integer posid;
    private String pname;
    private String pdesc;

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posid=" + posid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                '}';
    }
}
