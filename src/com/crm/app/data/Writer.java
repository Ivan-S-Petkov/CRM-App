package com.crm.app.data;

import com.crm.app.models.Company;
import com.fasterxml.jackson.databind.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static com.crm.app.data.Constants.*;

public class Writer {
    public static void writeCSVFile(String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_DATA))) {
            bw.write(data);
            System.out.printf("Successfully saved in %s %n", CSV_DATA);
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + CSV_DATA);
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void writeJSONFile(Map<Integer, Company> companies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_DATA))) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, companies.values());
            System.out.printf("Successfully saved in %s %n", JSON_DATA);
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + JSON_DATA);
            System.out.println("Error: " + e.getMessage());
        }
    }
}
