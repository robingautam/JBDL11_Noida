package org.gfg.SpringBootDemo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class GenericController {


    @PostMapping(value = "/get/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(){
        return "<html><head></head><body><h1>Hello !! This is first API</h1></body></html>";
    }



}
