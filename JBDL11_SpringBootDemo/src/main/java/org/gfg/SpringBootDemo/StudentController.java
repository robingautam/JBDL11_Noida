package org.gfg.SpringBootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {


    Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

 /*   @RequestMapping(value = "/get/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(){
        Student student = new Student();
        student.setId(1);
        student.setEmail("robin@gmail.com");
        student.setName("Robin");
        return student;
    }*/


    @GetMapping("/get/student/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        LOGGER.info("Inside the info: getStudentById");
        LOGGER.debug("Inside the debug: getStudentById");
        LOGGER.warn("Inside the warn: getStudentById");
        LOGGER.error("Inside the error: getStudentById");
        LOGGER.trace("Inside the trace: getStudentById");
        if (id==1){
            LOGGER.info("Id is one");
            Student student = new Student();
            student.setId(1);
            student.setEmail("robin@gmail.com");
            student.setName("Robin");
            return student;
        }
        return new Student();
    }


    @GetMapping("/get/student")
    public ResponseEntity<Student> getStudentByQueryParam(@RequestParam("id") int id){
        if (id==1){
            Student student = new Student();
            student.setId(1);
            student.setEmail("robin@gmail.com");
            student.setName("Robin");
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Student(),HttpStatus.NO_CONTENT);
    }


   /* @PostMapping("/create/student")
    public String createStudent(@RequestBody Student student){
        System.out.println(student);
        return "OK";
    }*/


    @PostMapping("/create/student")
    public String createStudent(@RequestParam Map<String,String> map){
        for (String key: map.keySet()){
            System.out.println(key +": "+map.get(key));
        }
        return "OK";
    }


}
