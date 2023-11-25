package com.crm.app.services;

import com.crm.app.data.Reader;
import com.crm.app.data.Writer;
import com.crm.app.models.Company;
import com.crm.app.services.interfaces.Service;

import java.util.*;

public class ClientService implements Service {

    private final Map<Integer, Company> companies;

    public ClientService() {
        this.companies = new HashMap<>();
        load();
    }

    private void load() {
        if (Config.FILE_TYPE == Config.File.JSON) {
            Reader.readJSONFile().forEach(company -> companies.put(company.getId(), company));
        } else {
        Reader.readCSVFile().forEach(line ->
        {
            int id = Integer.parseInt(line.get(0));
            String name = line.get(1);
            String industry = line.get(2);
            String contactPerson = line.get(3);
            double revenue = Double.parseDouble(line.get(4));
            String status = line.get(5);
            Company company = new Company(id, name, industry, contactPerson , revenue , status);
            companies.put(id, company);
        });
        }
    }

    @Override
    public void save() {
        if (Config.FILE_TYPE == Config.File.JSON) {
            Writer.writeJSONFile(companies);
        } else {
            StringBuilder dataString = new StringBuilder();
            for (Company company : companies.values()) {
                dataString.append(company.toString());
            }
            Writer.writeCSVFile(dataString.toString());
        }
    }

    @Override
    public void add(Company company) {
        companies.put(company.getId(), company);
    }

    @Override
    public void edit(int id, Company updatedCompany) {
        companies.put(id, updatedCompany);
    }

    @Override
    public void list() {
        for (Company company : companies.values()) {
            company.getDetails();
        }
    }

    @Override
    public Company searchById(int id) {
        return companies.get(id);
    }

    @Override
    public List<Company> searchByName(String name) {
       return  companies.values().stream().filter(company -> company.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    @Override
    public List<Company> searchByIndustry(String industry) {
        return companies.values().stream().filter(company -> company.getIndustry().toLowerCase().contains(industry.toLowerCase())).toList();
    }

    @Override
    public Map<Integer, Company> getAll() {
        return companies;
    }

    @Override
    public Set<String> getIndustries() {
        Set<String> departments = new HashSet<>();
        companies.values().forEach(company -> {
            departments.add(company.getIndustry());
        });
        return departments;
    }

}
