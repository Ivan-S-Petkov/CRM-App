package com.crm.app.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputService {

    public static Scanner sc = new Scanner(System.in);

    // Returns List of input data
    public static ArrayList<String> getData() {
        return new ArrayList<>(Arrays.stream(sc.nextLine().split(",")).map(String::trim).toList());
    }

    public static String getIndustry(){
        return sc.nextLine();
    }

    public static String getId() {
        return sc.nextLine();
    }

    public static String getName() {
        return sc.nextLine();
    }

    public static boolean validateData(ArrayList<String> data) {
        if (data.size() != 4) {
            System.out.println("Invalid data");
            return false;
        } else {
            String name = data.get(0);
            String industry = data.get(1);
            String contactPerson = data.get(2);
            String revenue = data.get(3);
            return InputValidationsService.isValidName(name) && InputValidationsService.isValidIndustry(industry) && InputValidationsService.isValidContactPerson(contactPerson) && InputValidationsService.isValidRevenue(revenue);
        }
    }


}
