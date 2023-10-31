package com.example.crudprometeusactuatorgrafana.service;

import com.example.crudprometeusactuatorgrafana.model.Student;
import com.example.crudprometeusactuatorgrafana.repository.StudentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentJPARepository studentRepository;


    public Student saveStudent (Student student){
        if (student.getId() == null){
            return studentRepository.save(student);
        }
        return null;
    }

    public Page<Student> getAllStudent (Integer page, Integer size, Boolean enablePagination){
        return studentRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student editStudent (Student student){
        if (student.getId() != null && studentRepository.existsById(student.getId())){
            return studentRepository.save(student);
        }
        return null;
    }

    public boolean existById(Long id) {
        return studentRepository.existsById(id);
    }
}
