package com.crm.app;

import com.crm.app.services.ClientManager;
import com.crm.app.services.ClientService;
import com.crm.app.services.interfaces.Manager;
import com.crm.app.services.interfaces.Service;

import java.util.Scanner;

import static com.crm.app.ui.Menu.displayOptions;

public class ClientManagementApp {
    public static void main(String[] args) {
        Service service = new ClientService();
        Manager manager = new ClientManager(service);

        System.out.println("Welcome to the Client Management System");
        displayOptions();

        boolean active = true;
        Scanner sc = new Scanner(System.in);
        while (active) {
            String command = sc.nextLine();
            manager.performAction(command);
            // Add Client
            //  Oceanic Enterprises, Finance, Sarah Smith, 500000.00
            // Update Client
            //  Oceanic Enterprises, Tech, Sarah Smith, 750000.00
            // View Clients
            // Search Industry Tech
            // Search ID 1
            // Remove Client 1
            // Search Name Oceanic
            // Save & Exit
        }
    }
}
