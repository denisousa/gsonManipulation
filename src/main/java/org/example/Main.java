package org.example;

import static org.example.JsonOperations.*;

public class Main {
    public static void main(String[] args) {
        createJsonFile();
        readJsonFile("person.json");
        deleteFile("person.json");
    }
}
