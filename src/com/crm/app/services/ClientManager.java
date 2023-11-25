package com.crm.app.services;

import com.crm.app.models.Company;
import com.crm.app.services.interfaces.Manager;
import com.crm.app.services.interfaces.Service;
import com.crm.app.ui.InputService;
import com.crm.app.ui.InputValidationsService;
import com.crm.app.ui.Menu;

import java.util.ArrayList;
import java.util.List;


public class ClientManager implements Manager {
    private final Service service;

    public ClientManager(Service service) {
        this.service = service;
    }

    public void performAction(String command) {
        ArrayList<String> data;
        List<Company> companies;
        switch (command) {

            // TODO create helper classes for each command in order to improve readability.

            // List All
            case "1":
                if (service.getAll().isEmpty()) {
                    Menu.noRecords();
                } else {
                    service.list();
                }
                break;

            // Add Command
            case "2":
                Menu.enterData();
                data = InputService.getData();
                if (InputService.validateData(data)) {
                    // Get next available ID
                    int id = service.getAll().size() + 1;
                    Company company = new Company(id, data.get(0), data.get(1), data.get(2), Double.parseDouble(data.get(3)));
                    service.add(company);
                    System.out.println("Company added successful!");
                } else {
                    System.out.println("Add company unsuccessful!");
                }
                break;

            // Edit Command
            case "3":
                Menu.enterId();
                String id = InputService.getId();
                if (InputValidationsService.isValidID(id, service)) {
                    Company company = service.searchById(Integer.parseInt(id));
                    Menu.enterUpdatedData(company);
                    data = InputService.getData();
                    if (InputService.validateData(data)) {
                        company = new Company(Integer.parseInt(id), data.get(0), data.get(1), data.get(2), Double.parseDouble(data.get(3)));
                        service.edit(Integer.parseInt(id), company);
                        System.out.println("Company edited successful!");
                    } else {
                        System.out.println("Edit company unsuccessful!");
                    }
                } else {
                    System.out.println("Edit company unsuccessful!");
                }
                break;

            // Search By Industry Command
            case "4":
                // Displays available industries based on already available entries in the DB file
                Menu.showAvailableIndustries(service);
                String industry = InputService.getIndustry();
                companies = service.searchByIndustry(industry);
                if (companies.isEmpty()) {
                    System.out.println("No companies found by the provided industry");
                } else {
                    for (Company company : companies) {
                        company.getDetails();
                    }
                }
                break;

            // Search By ID Command
            case "5":
                Menu.enterId();
                id = InputService.getId();
                if (InputValidationsService.isValidID(id, service)) {
                    service.searchById(Integer.parseInt(id)).getDetails();
                } else {
                    System.out.println("Command can not be executed!");
                }
                break;

            // Search By Name Command
            case "6":
                Menu.enterName();
                String name = InputService.getName();
                if (InputValidationsService.isValidName(name)) {
                    companies = service.searchByName(name);
                    if (companies.isEmpty()) {
                        System.out.println("No companies found by the provided name");
                    } else {
                        for (Company company : companies) {
                            company.getDetails();
                        }
                    }
                }
                break;

            // Remove Company Command
            case "7":
                Menu.enterId();
                id = InputService.getId();
                if (InputValidationsService.isValidID(id, service)) {
                    service.searchById(Integer.parseInt(id)).setStatus(false);
                    System.out.println("Company removed successful!");
                } else {
                    System.out.println("Remove company unsuccessful!");
                }
                break;

            // Save Command
            case "8":
                service.save();
                break;
            default:
                System.out.println("No such command");
                System.out.println("Available commands:");
                Menu.displayOptions();
                break;
        }
    }
}
