package com.kortov.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Driver {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(Objects.requireNonNull(Driver.class.getClassLoader()
                    .getResource("data/sample-full.json")).getFile());
            Student student = objectMapper.readValue(file, Student.class);
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            Address address = student.getAddress();
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
            for (String language : student.getLanguages()) {
                System.out.println(language);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
