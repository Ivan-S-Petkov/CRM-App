package com.crm.app.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Company {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Industry")
    private String industry;

    @JsonProperty("ContactPerson")
    private String contactPerson;

    @JsonProperty("Revenue")
    private double revenue;

    @JsonProperty("Status")
    private Boolean status;


    public Company(int id, String name, String industry, String contactPerson, double revenue) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
        this.status = true;
    }

    @JsonCreator
    public Company(@JsonProperty("Id") int id, @JsonProperty("Name") String name, @JsonProperty("Industry") String industry, @JsonProperty("ContactPerson") String contactPerson, @JsonProperty("Revenue") double revenue, @JsonProperty("Status") String status) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
        this.status = status.contains("true");
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void getDetails() {
        System.out.printf("%d. %s - %s - %s - %.2f - %s %n", id, name, industry, contactPerson, revenue, status ? "active" : "inactive");
    }

    public String toString() {
        String CSVString = String.join(",", String.valueOf(id), name, industry, contactPerson, String.valueOf(revenue), String.valueOf(status));
        CSVString += "\n";
        return CSVString;
    }

}
