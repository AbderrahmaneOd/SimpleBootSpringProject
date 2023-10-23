package com.project.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.simple.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);
    @Query("select year(s.birthday) as annee, count(*) as nbr from Student s group by year(s.birthday) order by year(s.birthday)")
    Collection<?> findNbrStudentByYear();

}
