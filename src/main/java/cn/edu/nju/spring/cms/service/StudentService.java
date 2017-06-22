package cn.edu.nju.spring.cms.service;

import java.util.List;
import cn.edu.nju.spring.cms.model.Student;

/**
 * Created by bingo on 2017/6/21.
 */
public interface StudentService {

    Student findStudentByID(String id);

    List<Student> findAllStudent();

    void saveStudent(Student stu);

    void deleteStudent(String id);

}
