package com.example.contract;

import com.example.model.Employment;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class EmploymentDto {
    private String company;
    private String position;
    private Date startDate;
    private Date endDate;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // Getter and setter methods for other fields
    // ...
}