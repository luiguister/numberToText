package com.numberToText.numberToText.services;

import com.numberToText.numberToText.Model.FileResponseTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {

    List<String> loadFile() throws FileNotFoundException, IOException;
}
