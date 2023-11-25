package com.crm.app.ui;

import com.crm.app.services.interfaces.Service;
import com.crm.app.utils.ValidationUtils;

public class InputValidationsService {

    public static boolean isValidID(String id, Service service) {
        if (ValidationUtils.isInteger(id)) {
            if (!service.getAll().containsKey(Integer.parseInt(id))) {
                System.out.println("ID does not exist");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public static boolean isValidName(String name) {
        // TODO Could implement additional validation if name already exists in the DB.
        if (ValidationUtils.isNotNullOrEmpty(name)) {
            return true;
        } else {
            System.out.println("Invalid name");
            return false;
        }
    }

    public static boolean isValidIndustry(String industry) {
        if (ValidationUtils.isNotNullOrEmpty(industry)) {
            return true;
        } else {
            System.out.println("Invalid industry");
            return false;
        }
    }

    public static boolean isValidContactPerson(String contactPerson) {
        if (ValidationUtils.isNotNullOrEmpty(contactPerson)) {
            return true;
        } else {
            System.out.println("Invalid contact person");
            return false;
        }
    }

    public static boolean isValidRevenue(String revenue) {
        if (ValidationUtils.isDouble(revenue) && ValidationUtils.isPositiveDouble(revenue)) {
            return true;
        } else {
            System.out.println("Invalid revenue value");
            return false;
        }
    }


}
