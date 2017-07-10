package com.founder.cxzx.mobilephonerefine.bean;

/**
 * Created by hyyx on 2017/6/7.
 */

public class KeShiMenZhenBean {
    private String departName;
    private String ExpertNum;
    private String DirectorNum;
    private String DoctorNum;

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getExpertNum() {
        return ExpertNum;
    }

    public void setExpertNum(String expertNum) {
        ExpertNum = expertNum;
    }

    public String getDirectorNum() {
        return DirectorNum;
    }

    public void setDirectorNum(String directorNum) {
        DirectorNum = directorNum;
    }

    public String getDoctorNum() {
        return DoctorNum;
    }

    public void setDoctorNum(String doctorNum) {
        DoctorNum = doctorNum;
    }

    public KeShiMenZhenBean(String departName, String expertNum, String directorNum, String doctorNum) {
        this.departName = departName;
        ExpertNum = expertNum;
        DirectorNum = directorNum;
        DoctorNum = doctorNum;
    }
}
