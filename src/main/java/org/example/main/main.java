package org.example.main;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class main {
    public static void main(String[] args) {

        try {
            URI uri = new URI("file:///C:/Users/lucam/OneDrive/Desktop/Gestore%20Progetti/untitled1/src/main/resources/vis/prova.txt");
            File file = new File(uri);

            if(file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
