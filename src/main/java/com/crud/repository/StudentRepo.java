package com.crud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {


	List<Student> findBystudentName(String name);
	
}
