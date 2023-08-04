package org.example.service;

import org.example.model.Document;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public boolean deleteFile(String fileName, String path) {
        File file = new File(path + fileName);
        if(file.exists()) {
            if(file.delete()) {
                System.out.println("File denominato " + fileName + " eliminato correttamente");
                return true;
            }
            else {
                System.out.println("Errore nell'eliminazione del file " + fileName);
                return false;
            }
        } else {
            System.out.println("Errore, il file non esiste");
            return false;
        }
    }


    public boolean move(Document document, String newPath) throws URISyntaxException {
        System.out.println("esiste? " + document.getFile().exists());
        URI uri = new URI("file:///C:/Users/lucam/OneDrive/Desktop/Gestore%20Progetti/untitled1/src/main/resources/datimove/ppp.txt");
        File finalFile = new File(uri);
        System.out.println("esite22??" + finalFile.exists());
        if(document.getFile().exists()) {
            if(document.getFile().renameTo(finalFile)) {
                System.out.println("Il file " + document.getFile().getName() + " è stato spostato con successo");
                document.setPath(newPath);
                System.out.println(document.getFile().getAbsolutePath());
                return true;
            } else {
                System.out.println("Il file " + document.getFile().getName() + " ha avuto un problema nel trasferimento");
                return false;
            }
        } else {
            System.out.println("Il documento non esiste o hai spagliato i path");
            return false;
        }
    }


    /*
    public boolean move(Document document, String newPath) {

        try {
            String originPath = document.getFile().getPath();
            Path sourcePath = Paths.get(originPath);
            Path destinationPath = Paths.get(newPath);

            Files.move(sourcePath, destinationPath);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    */


}
