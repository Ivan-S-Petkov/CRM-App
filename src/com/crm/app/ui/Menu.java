package com.crm.app.ui;


import com.crm.app.models.Company;
import com.crm.app.services.interfaces.Service;

public class Menu {

    public static void displayOptions() {
        System.out.println(" 1 - List all");
        System.out.println(" 2 - Add");
        System.out.println(" 3 - Edit");
        System.out.println(" 4 - Search by Industry");
        System.out.println(" 5 - Search by ID");
        System.out.println(" 6 - Search by Name");
        System.out.println(" 7 - Remove company");
        System.out.println(" 8 - Save and Exit");
    }

    public static void enterData(){
        System.out.println("Please enter new record in the following format:\n 2Oceanic Enterprises, Finance, Sarah Smith, 500000.00");
    }
    public static void enterId(){
        System.out.print("Please enter ID: ");
    }

    public static void enterName(){
        System.out.print("Please enter name: ");
    }

    public static void showAvailableIndustries(Service service) {
        if (service.getIndustries().isEmpty()) {
            System.out.println("No industries found");
        } else {
            System.out.println("Available industries: ");
            service.getIndustries().forEach(department -> {
                System.out.printf(" * %s %n", department);
            });
        }
    }

    public static void noRecords() {
        System.out.println("No records found!");
    }

    public static void enterUpdatedData(Company company) {
        System.out.printf("Please enter updated record in the following format:%n %s, %s, %s, %.2f %n", company.getName(), company.getIndustry(),company.getContactPerson(),company.getRevenue());
    }
}
