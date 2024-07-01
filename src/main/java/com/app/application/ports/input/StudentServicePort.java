package com.app.application.ports.input;

import java.util.List;

import com.app.domain.model.Student;

public interface StudentServicePort {

  Student findById(Long id);
  List<Student> findAll();
  Student save(Student student);
  Student update(Long id, Student student);
  void deleteById(Long id);

}
