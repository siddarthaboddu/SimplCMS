package com.example.cms.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Controller
public class UploadController {
    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";

    @GetMapping("/admin/upload")
    public ModelAndView uploadView(Model model){

//        for(int i=0;i<1000;i++) System.out.println("sdfsdffsd");
        File file = new File(uploadingDir);
        ModelAndView modelAndView = new ModelAndView("admin/upload");
        modelAndView.addObject("files",file.listFiles());
//        file.

        return modelAndView;
    }

    @PostMapping("/admin/upload")
    public String uploadingFile(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        for(MultipartFile uploadedFile : uploadingFiles){
            File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "redirect:/admin/upload";
    }

    @GetMapping("/resources/user-uploaded-images/**")
    public void getImageAsByteArray(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        String[] requestURIs = request.getRequestURI().split("/");
        String fileName = requestURIs[requestURIs.length - 1].replaceAll("%20", " ");
        System.out.println(Arrays.toString(requestURIs));
        System.out.println(fileName);
        final File file = ResourceUtils.getFile(uploadingDir + fileName);
        final InputStream in = new FileInputStream(file);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

}
