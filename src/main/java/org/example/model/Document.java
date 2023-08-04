package org.example.model;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class Document {

    private int id;
    private String tag;
    private File file;
    private String path;

    public Document(int id, String tag, String path) {
        this.id = id;
        this.tag = tag;
        this.path = path;
        try {
            URI uri = new URI(path);
            this.file = new File(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    public Document(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        String ris;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while ((ris = bufferedReader.readLine()) != null) {

                stringBuilder.append(ris).append("\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public void write(String pathSave, String context) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathSave));
            bufferedWriter.write(context);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
