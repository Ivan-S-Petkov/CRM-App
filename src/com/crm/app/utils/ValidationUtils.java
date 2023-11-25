package com.crm.app.utils;

public class ValidationUtils {

    public static boolean isNotNullOrEmpty(String data){
        return data != null && !data.trim().isEmpty();
    }

    public static boolean isInteger(String data){
        try{
            Integer.parseInt(data);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isDouble(String data){
        try{
            Double.parseDouble(data);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }


    public static boolean isPositiveDouble(String data){
        try {
            double value = Double.parseDouble(data);
            return value > 0;
        } catch (NumberFormatException e){
            return false;
        }
    }

}
