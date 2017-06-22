package cn.edu.nju.spring.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.spring.cms.model.Student;
import cn.edu.nju.spring.cms.repository.StudentRepository;
import cn.edu.nju.spring.cms.service.StudentService;

/**
 * Created by bingo on 2017/6/21.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByID(String id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void saveStudent(Student stu) {
        studentRepository.save(stu);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.delete(id);
    }
}
