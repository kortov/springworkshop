package com.kortov.springworkshop.annotationbeans;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {
    private ArrayList<String> data = new ArrayList<>();
    private Random myRandom = new Random();

    public FileFortuneService() {
        fillArray();
    }

    private void fillArray() {
        Path file = null;
        try {
            file = Paths.get(getClass().getClassLoader()
                    .getResource("File.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.size());
        return data.get(index);
    }
}
