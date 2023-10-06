package com.numberToText.numberToText.controller;

import com.numberToText.numberToText.Model.FileResponseTime;
import com.numberToText.numberToText.services.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class Controlador {

    @Autowired
    FileServiceImpl service;

    @PostMapping("/readFile")
    public ResponseEntity<List<FileResponseTime>> readFile() throws IOException {
        List<String> response = service.loadFile();
        List<FileResponseTime> respuestas = new ArrayList<>();
        for (String respuesta: response) {
            String[] arrOfStr = respuesta.split(":");
            FileResponseTime frt = new FileResponseTime();
            frt.setHour(Integer.parseInt(arrOfStr[0]));
            frt.setMinute(Integer.parseInt(arrOfStr[1]));

            String nums[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                    "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
                    "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine",
            };

            if (Integer.parseInt(arrOfStr[1]) == 0)
                frt.setTime(nums[Integer.parseInt(arrOfStr[0])] + " o' clock");
             else if (Integer.parseInt(arrOfStr[1]) == 1)
                frt.setTime("one minute past " +nums[Integer.parseInt(arrOfStr[0])]);
             else if (Integer.parseInt(arrOfStr[1]) == 59)
                frt.setTime("one minute to " +nums[(Integer.parseInt(arrOfStr[0]) % 12) + 1]);
             else if (Integer.parseInt(arrOfStr[1]) == 15)
                frt.setTime("quarter past " + nums[Integer.parseInt(arrOfStr[0])]);
             else if (Integer.parseInt(arrOfStr[1]) == 30)
                frt.setTime("half past " + nums[Integer.parseInt(arrOfStr[0])]);
             else if (Integer.parseInt(arrOfStr[1]) == 45)
                frt.setTime("quarter to " +nums[(Integer.parseInt(arrOfStr[0]) % 12) + 1]);
             else if (Integer.parseInt(arrOfStr[1]) <= 30)
                frt.setTime(nums[Integer.parseInt(arrOfStr[1])] + " minutes past " +nums[Integer.parseInt(arrOfStr[0])]);
             else if (Integer.parseInt(arrOfStr[1]) > 30)
                frt.setTime( nums[60 - Integer.parseInt(arrOfStr[1])] + " minutes to " + nums[(Integer.parseInt(arrOfStr[0]) % 12) + 1]);
            respuestas.add(frt);
        }
        return new ResponseEntity<>(respuestas, HttpStatus.OK);
    }
}
