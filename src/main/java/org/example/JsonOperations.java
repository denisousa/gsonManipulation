package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonOperations {
    public static void createJsonFile() {
        Address address = new Address("12345678", "rua lalala", 1234);
        List<String> dreams = Arrays.asList("Passsar em POO", "Não reprovar");
        Certificates certificate1 = new Certificates("Curso POO", 2023);
        Certificates certificate2 = new Certificates("Curso Assembly", 2023);
        List<Certificates> certificatesList = Arrays.asList(certificate1, certificate2);

        Person person = new Person(
                "João",
                "Silva",
                30,
                dreams,
                address,
                certificatesList);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person);
        // String json = new Gson().toJson(person);


        try (FileWriter writer = new FileWriter("./person.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readJsonFile(String jsonFilePath) {

        try (FileReader reader = new FileReader(jsonFilePath)) {
            Gson gson = new Gson();
            Person person = gson.fromJson(reader, Person.class);

            System.out.println("Nome: " + person.getFirstName());
            System.out.println("Sobrenome: " + person.getLastName());
            System.out.println("Idade: " + person.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String jsonFilePath) {
        File file = new File(jsonFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

}
