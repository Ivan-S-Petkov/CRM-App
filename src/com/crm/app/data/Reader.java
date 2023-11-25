package com.crm.app.data;

import com.crm.app.models.Company;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.crm.app.data.Constants.*;

public class Reader {

    public static List<List<String>> readCSVFile() {
        List<List<String>> companies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_DATA))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                companies.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + CSV_DATA);
            System.out.println("Error: " + e.getMessage());
        }
        return companies;
    }

    public static List<Company> readJSONFile() {
        List<Company> companies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(JSON_DATA))) {
            ObjectMapper mapper = new ObjectMapper();
            companies = mapper.readValue(br, new TypeReference<List<Company>>() {
            });
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + JSON_DATA);
            System.out.println("Error: " + e.getMessage());
        }
        return companies;
    }
}
