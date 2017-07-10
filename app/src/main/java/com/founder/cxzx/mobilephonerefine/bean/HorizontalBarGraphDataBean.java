package com.founder.cxzx.mobilephonerefine.bean;

/**
 * Created by hyyx on 2017/2/21.
 */

public class HorizontalBarGraphDataBean {

    private String deptName;

    private String deptNum;

    public HorizontalBarGraphDataBean(String deptName, String deptNum) {
        this.deptName = deptName;
        this.deptNum = deptNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum;
    }
}
