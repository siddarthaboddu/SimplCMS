package com.example.cms;

import com.example.cms.controllers.UploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args)
    {
        new File(UploadController.uploadingDir).mkdirs();
        SpringApplication.run(CmsApplication.class, args);
    }

}
