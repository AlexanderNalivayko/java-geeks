package com.hillel.elementary.javageeks.students_grades;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class GradesFileReaderWriter {

    private GradesFileReaderWriter() { }

    public static String readFromFile(String pathToFile) {
        if (pathToFile == null || pathToFile.isEmpty()) {
            System.out.print("Invalid path to file");
            return null;
        }

        File file = new File(pathToFile);
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                                            new InputStreamReader(
                                            new FileInputStream(file), UTF_8))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }

    public static void writeToFile(String pathToFile, String text) {
        if (pathToFile == null || text == null || pathToFile.isEmpty()) {
            System.out.print("Invalid path to file or string");
            return;
        }

        File file = new File(pathToFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                                            new OutputStreamWriter(
                                            new FileOutputStream(file.getPath()), UTF_8))) {
            bufferedWriter.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
