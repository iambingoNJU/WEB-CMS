package cn.edu.nju.spring.cms.repository;

import cn.edu.nju.spring.cms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bingo on 2017/6/21.
 */

public interface StudentRepository extends JpaRepository<Student,String> {

}