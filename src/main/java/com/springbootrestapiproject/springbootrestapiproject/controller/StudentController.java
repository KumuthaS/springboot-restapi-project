package com.springbootrestapiproject.springbootrestapiproject.controller;

import com.springbootrestapiproject.springbootrestapiproject.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/student")//create a baseURL in classPath to avoid repitation in each methods
public class StudentController {
    /**
     * http://localhost:8080/student
     * @return
     */
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "kumu", "sri");
        return student;
    }
    @GetMapping("/studentRE")
    public ResponseEntity<Student> getStudentResponseEntity() {
        Student student = new Student(1, "kumu", "sri");
       // return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok().header("Custom-header","kumutha")
                .body(student);
    }



    /**
     * http://localhost:8080/list-student
     * @return
     */
    @GetMapping("/list-student")
    public List<Student> getListStudent() {
       /* List<Student> students= Arrays.asList(new Student(1,"kumu","sri"),
                new Student(2,"vino","L"));
        students.add(new Student(3,"ezhil","V"));

        */

        List<Student> student=new ArrayList<>();
        student.add(new Student(1,"kumu","sri"));
        student.add(new Student(1,"kumu","sri"));

        return student;
    }
    @GetMapping("/list-studentRE")
    public ResponseEntity<List<Student>> getListStudentRE() {
       /* List<Student> students= Arrays.asList(new Student(1,"kumu","sri"),
                new Student(2,"vino","L"));
        students.add(new Student(3,"ezhil","V"));

        */

        List<Student> student=new ArrayList<>();
        student.add(new Student(1,"kumu","sri"));
        student.add(new Student(1,"kumu","sri"));

        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //http://localhost:8080/list-student/1
    @GetMapping("/list-student/{id}")
    public List<Student> getStudentById(@PathVariable("id") int id){
        List<Student> student=new ArrayList<>();
        student.add(new Student(1,"kumu","sri"));
        student.add(new Student(2,"kumu","sri"));

        return student;

    }
    @GetMapping("/list-studentRE/{id}")
    public ResponseEntity<List<Student>> getStudentByIdRE(@PathVariable("id") int id){
        List<Student> student=new ArrayList<>();
        student.add(new Student(1,"kumu","sri"));
        student.add(new Student(2,"kumu","sri"));

        return ResponseEntity.ok().header("custom-header","public School")
                .body(student);

    }
    //http://localhost:8080/student/3
    @GetMapping("student/{id}")
    public Student getStudentByid(@PathVariable("id") int id){

        return new Student(id,"kumu","sri");

    }
    @GetMapping("studentRE/{id}")
    public ResponseEntity<Student> getStudentByidRE(@PathVariable("id") int id){

        Student student=new Student(id,"kumu","sri");
        return new ResponseEntity<>(student,HttpStatus.OK);

    }
    //Spring Boot Rest api - to get id from the student
    //http://localhost:8080/student/3/kumu/sri
    @GetMapping("student/{id}/{fisrName}/{lastName}")
    public Student getStudentByid(@PathVariable("id") int id,
                                  @PathVariable("fisrName") String fisrName,
                                  @PathVariable("lastName") String lastName){

        return new Student(id,"kumu","sri");

    }
    @GetMapping("studentRE/{id}/{fisrName}/{lastName}")
    public ResponseEntity<Student> getStudentByidRE(@PathVariable("id") int id,
                                                  @PathVariable("fisrName") String fisrName,
                                                  @PathVariable("lastName") String lastName){

        Student student=new Student(id,"kumu","sri");
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //Spring boot Rest api- using Request Param
    //http://localhost:8080/student/query?id=1
    @GetMapping("student/query")
    public Student getStudentParam(@RequestParam int id,@RequestParam String firstName){
        return new Student(1,"kumu","s");
    }
    @GetMapping("studentRE/query")
    public ResponseEntity<Student> getStudentParamRE(@RequestParam int id,@RequestParam String firstName){
        Student student=new Student(id,"kumu","sri");
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //Spring Boot Rest api- Create Student-PostMapping
   // http://localhost:8080/createStudent1
    @PostMapping("/createStudent1")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  student;

    }
    // http://localhost:8080/createStudent2
    @PostMapping("/createStudent2")
    public ResponseEntity<Student> createStudent2(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    //Spring boot Rest api that handles Http Put Request-Updating existing resource
    // http://localhost:8080/students/1/update
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  student;
    }
    @PutMapping("studentsRE/{id}/update")
    public ResponseEntity<Student> updateStudentRE(@RequestBody Student student,@PathVariable("id") int id){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  ResponseEntity.ok(student);
    }

    //Spring boot Rest api that handles Http Delete Request-Delete existing resource
   //http://localhost:8080/student/delete/1
    @DeleteMapping("student/delete/{id}")
    public String deleteStudent( @PathVariable("id") int id){

        return "Student deleted successfully";
    }
    @DeleteMapping("studentRE/delete/{id}")
    public ResponseEntity<String> deleteStudentRE( @PathVariable("id") int id){

        //return new ResponseEntity<String>(HttpStatus.OK);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
