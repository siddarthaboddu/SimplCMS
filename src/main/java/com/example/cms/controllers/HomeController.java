package com.example.cms.controllers;

import com.example.cms.models.Page;
import com.example.cms.services.PageService;
import liqp.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

@Controller
public class HomeController {

    @Autowired
    private PageService pageService;
    private ServletContext servletContext;

    @GetMapping({"/**","/error"})
    public ResponseEntity<String> genericLoader(final HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        String route = request.getRequestURI();
        System.out.println(route);
        Page page = pageService.getPage(route);
        if (page == null) {
            page = pageService.getPage("/error");
        }
        System.out.println("____________________________________________________________");
        System.out.println(page);
        System.out.println("____________________________________________________________");
        Template template = Template.parse(page.getContent());
        String rendered = template.render("name", "tobi");
        System.out.println(rendered);
        return new ResponseEntity<String>(rendered, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/resources/**", produces = {"text/javascript;charset=utf-8", "text/css;charset=utf-8"})
    public ResponseEntity<byte[]> getFile(final HttpServletRequest request) throws IOException {
        String[] URI = request.getRequestURI().split("/resources/");

        final File file = ResourceUtils.getFile("classpath:static/" + URI[1]);
        final InputStream targetStream = new DataInputStream(new FileInputStream(file));


        HttpHeaders responseHeaders = new HttpHeaders();
        String[] fileNameArray = file.getName().toString().split("\\.");
        System.out.println("**********************************");
        System.out.println(Arrays.toString(URI));
        System.out.println(file.getName());
        System.out.println(Arrays.toString(fileNameArray));
        System.out.println("**********************************");
        String fileType = fileNameArray[fileNameArray.length - 1];
        if(fileType.equals("js")) fileType = "javascript";
        String contentType = "text/"+fileType;


        responseHeaders.add("Content-Disposition","attachment; filename=" + file.getName());
        responseHeaders.add("Content-Type",contentType + "; charset=UTF-8");
//        return ResponseEntity.ok()
//                .(responseHeaders)
//                .body(Files.readAllBytes(file.toPath()));
        return ResponseEntity.ok().headers(responseHeaders).body(Files.readAllBytes(file.toPath()));
    }

//    @GetMapping("/resources/images/**")
//    public ResponseEntity<byte[]> getImage()



    @GetMapping("/hi")
    public ResponseEntity<String> hii() {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("<p> YAY </p>", HttpStatus.ACCEPTED);
        return responseEntity;
    }


}
