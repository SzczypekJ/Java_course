package com.solvd.mavenproject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            String content = FileUtils.readFileToString(new File("src/test/new.txt"), StandardCharsets.UTF_8);

            String[] words = StringUtils.split(content.trim(), null);
            Map<String, Integer> wordCount = new HashMap<>();

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            FileUtils.writeStringToFile(new File("src/test/results.txt"), wordCount.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
