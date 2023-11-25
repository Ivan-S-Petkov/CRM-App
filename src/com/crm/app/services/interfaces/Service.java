package com.crm.app.services.interfaces;

import com.crm.app.models.Company;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Service {
    void add(Company company);

    void edit(int id, Company updatedCompany);

    void list();

    Company searchById(int id);

    List<Company> searchByName(String name);

    List<Company> searchByIndustry(String industry);

    Map<Integer,Company> getAll();

    Set<String> getIndustries();

    void save();
}
