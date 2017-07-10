package com.founder.cxzx.mobilephonerefine.bean;

/**
 * Created by hyyx on 2017/6/7.
 */

public class MenZhenFeiYaoBiBean {
    private String deptName;
    private String deptNum;

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

    public MenZhenFeiYaoBiBean(String deptName, String deptNum) {
        this.deptName = deptName;
        this.deptNum = deptNum;
    }
}
