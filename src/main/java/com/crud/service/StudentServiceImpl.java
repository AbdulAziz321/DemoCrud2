package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.exception.StudentNotFoundException;
import com.crud.model.Student;
import com.crud.repository.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;
	
	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
	return repo.save(student);
	}

	public Student getById(long id) {
		Optional<Student> studentOptional = repo.findById(id);
		return studentOptional.get();
	}
	
	@Override
	public Student updateStudent(Student studet,long id) {
		studet.setStudentId(id);
		return repo.save(studet);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Student> getSearch(String name) {
		
		List<Student> sOptional = repo.findBystudentName(name);
		
		if(sOptional.isEmpty()) {
			throw new StudentNotFoundException("Insert Full Student Name");
		}else {
			return sOptional;
		}
		
		}

}
