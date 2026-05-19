package org.gfg.JBDL11_Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic")
public class GenericController {

    @GetMapping("/hello")
    public String hello(){

        System.out.println("Inside the hello api");
        return "Hello World";
    }


    @GetMapping("/private")
    public String privateUrl(){
        return "This is private url only admin can access";
    }

    @GetMapping("/protected")
    public String protectedURL(){
        return "This is protected url only logged in user can access";
    }

    @GetMapping("/public")
    public String publicUrl(){
        return "This is public url, anyone can access";
    }
}
