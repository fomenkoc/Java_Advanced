package com.gmail.fomenkoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.fomenkoc.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
