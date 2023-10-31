package com.example.crudprometeusactuatorgrafana.repository;

import com.example.crudprometeusactuatorgrafana.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJPARepository extends JpaRepository<Student, Long> {
}

