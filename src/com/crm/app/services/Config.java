package com.crm.app.services;

public final class Config {

    enum File {

        CSV,
        JSON

    }

    public static File FILE_TYPE = File.JSON;
}
