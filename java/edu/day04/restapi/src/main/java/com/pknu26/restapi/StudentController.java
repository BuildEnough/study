package com.pknu26.restapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pknu26.restapi.entity.Student;

@RestController
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()); // StudentController에 속하는 로거가 됨

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("이너프", 30);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
            new Student("이너프1", 31),
            new Student("이너프2", 32),
            new Student("이너프3", 33)
        );
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello " +  name;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return "User ID " +  id;
    }

    @PostMapping("/student")
    public Student createUser(@RequestBody Student student) {
        logger.info(student.getName());
        logger.info("age={}", student.getAge());

        return student;
    }
}
