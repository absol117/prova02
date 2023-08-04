package org.example.main;

import org.example.model.Document;
import org.example.service.FileService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main2 {
    public static void main(String[] args) {

        String path = "C:/Users/lucam/OneDrive/Desktop/Gestore Progetti/untitled1/src/main/resources/database/test01.txt";
        String context = "prova di scrittura";
        Document document2 = new Document(1,"tag2");
        document2.write(path,context);

        Document document = new Document(1,"tag1","file:///C:/Users/lucam/OneDrive/Desktop/Gestore%20Progetti/untitled1/src/main/resources/database/test01.txt");
        System.out.println(document.read());



        String fileNameToDelete = "prova.txt";
        String pathDelete = "C:/Users/lucam/OneDrive/Desktop/Gestore Progetti/untitled1/src/main/resources/database/";

        FileService fileService = new FileService();


        //fileService.deleteFile(fileNameToDelete, pathDelete);

        String newPath = "C:/Users/lucam/OneDrive/Desktop/Gestore Progetti/untitled1/src/main/resources/datimove/test0133.txt";
        try {
            System.out.println(fileService.move(document, newPath));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String perc = "/database";
        File file = new File(perc);
        System.out.println("il file stronzo " + file.exists());


        String sourceFileName = "az.txt"; // Nome del file sorgente
        String destinationFileName = "destination_file.txt"; // Nome del file di destinazione

        try {
            Path sourcePath = Paths.get("resources", sourceFileName);
            System.out.println(sourcePath);
            Path destinationPath = Paths.get("resources", destinationFileName);
            System.out.println(destinationPath);

            // Sposta il file sorgente nella destinazione
            Files.move(sourcePath, destinationPath);

            System.out.println("Il file è stato spostato con successo da '" + sourcePath + "' a '" + destinationPath + "'.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante lo spostamento del file: " );
        }

    }




}
