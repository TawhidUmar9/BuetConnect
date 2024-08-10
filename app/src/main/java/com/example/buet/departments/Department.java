package com.example.buet.departments;

import java.io.Serializable;

public class Department implements Serializable {
    private  String departmentName;
    private  int departmentImage;
    private  int websiteURL;
    private  int departmentAbbreviation;

    public Department() {
    }

    public Department(String departmentName, int departmentImage, int websiteURL, int departmentAbbreviation) {
        this.departmentName = departmentName;
        this.departmentImage = departmentImage;
        this.websiteURL = websiteURL;
        this.departmentAbbreviation = departmentAbbreviation;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentImage() {
        return departmentImage;
    }

    public int getWebsiteURL() {
        return websiteURL;
    }

    public int getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }
}
