package com.numberToText.numberToText.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public List<String> loadFile() throws FileNotFoundException, IOException {

        Path uploadPath = Paths.get("Files-Upload");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        File file = null;
        String content;
        try {
            file = ResourceUtils.getFile(uploadPath+"/Cm1yJ1x3-horas.txt");
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException ioe) {
            throw new IOException("Could not read file: " + file, ioe);
        }
        List<String> lista = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    lista.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
