package cn.edu.nju.spring.cms.rest;

import java.util.List;
import java.util.Collection;

import cn.edu.nju.spring.cms.model.Student;
import cn.edu.nju.spring.cms.service.StudentService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by bingo on 2017/6/21.
 */

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{stuID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Student> getStudent(@PathVariable("stuID") String stuID) {
        Student stu = studentService.findStudentByID(stuID);
        if(stu == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(stu, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Student>> getStudents() {
        Collection<Student> students = this.studentService.findAllStudent();
        if(students.isEmpty()) {
            return new ResponseEntity<Collection<Student>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<Student>>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Student> addStudent(Student stu) {
        if(stu == null) {
            return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
        }
        this.studentService.saveStudent(stu);
        return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{stuID}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable("stuID") String id, Student stu) {
        Student currentStudent = this.studentService.findStudentByID(id);
        if(currentStudent == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        currentStudent.setName(stu.getName());
        currentStudent.setMajor(stu.getMajor());
        currentStudent.setGrade_usual(stu.getGrade_usual());
        currentStudent.setGrade_homework(stu.getGrade_homework());
        currentStudent.setGrade_exam(stu.getGrade_exam());
        this.studentService.saveStudent(currentStudent);
        return new ResponseEntity<Student>(currentStudent, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{stuID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional
    public ResponseEntity<Void> deletePet(@PathVariable("stuID") String stuID){
        Student stu = this.studentService.findStudentByID(stuID);
        if(stu == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.studentService.deleteStudent(stuID);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
