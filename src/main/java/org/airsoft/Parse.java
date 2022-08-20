package org.airsoft;

import org.airsoft.exception.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Parse {

    private static File file = null;
    private static List<String> list;

    public static List<String> parseFileToList() {
        try {
            file = new File("src/main/resources/static/airports.csv");

            if (file == null) {
                throw new ParseException("Файл пустой");
            }
            list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
