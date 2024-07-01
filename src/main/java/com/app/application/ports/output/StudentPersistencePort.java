package com.app.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.app.domain.model.Student;

public interface StudentPersistencePort {

  Optional<Student> findById(Long id);
  List<Student> findAll();
  Student save(Student student);
  void deleteById(Long id);

}
