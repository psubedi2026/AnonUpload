package com.theironyard.novauc.controllers;

import com.theironyard.novauc.services.AnonFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import com.theironyard.novauc.entities.AnonFile;

/**
 * Created by psubedi2020 on 3/20/17.
 */
@RestController
public class AnonFileController {

 @Autowired
 AnonFileRepository files;


 @RequestMapping(path = "/upload", method = RequestMethod.POST)
 public void upload(MultipartFile file, HttpServletResponse response) throws IOException {

    File dir = new File("public/files");

    dir.mkdirs();

    File f = File.createTempFile("file", file.getOriginalFilename(), dir);

    FileOutputStream fos = new FileOutputStream(f);

    fos.write(file.getBytes());


    AnonFile anonFile = new AnonFile(f.getName(), file.getOriginalFilename());
    files.save(anonFile);

    response.sendRedirect("/");

 }


 @RequestMapping(path = "/files", method = RequestMethod.GET)
 public List<AnonFile> getFiles() {
     return (List<AnonFile>) files.findAll();
 }


}
