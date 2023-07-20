package com.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {
   
	   
   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "std_id")
	private long studentId;
	
	@Column(name = "std_name")
	@NotBlank(message = "Student name cannot be blank")
	@Size(min = 3 , max = 50 , message = "Student name must be within 3-50 range")
	@Pattern(regexp = "[a-zA-Z\\s,]{3,50}" , message = "Student name must be in a proper formate")
	private String studentName;
	
	@Column(name = "std_father")
	@NotBlank(message = "Student Father name cannot be blank")
	@Size(min = 3 , max = 50 , message = "Student Father name must be within 3-50 range")
	@Pattern(regexp = "[a-zA-Z\\s,]{3,50}" , message = "Student Father name must be in a proper formate")
	private String studentFather;
	
	@Column(name = "std_add")
	@NotBlank(message = "Student address cannot be blank")
	@Size(min = 10 , max = 200 , message = "Student address must be within 10-200 range")
	@Pattern(regexp = "[A-Za-z0-9'\\.\\-\\s\\,]{10,200}" , message = "Student address must be in a proper formate")
	private String studentAddress;
	
	@Column(name = "std_course")
	@NotBlank(message = "Student Course cannot be blank")
	private String studentCourseName;
	
	@Column(name = "std_collage")
	@NotBlank(message = "Student Collage cannot be blank")
	@Size(min = 10 , max = 200 , message = "Student address must be within 10-200 range")
	@Pattern(regexp = "[A-Za-z\\s,]{10,200}" , message = "Student Collage must be in a proper formate")
	private String studentCollageName;
	
	@Column(name = "std_mobno")
	@NotBlank(message = "Student Mobile Number cannot be blank")
	@Min(value = 10 , message = "Mobile number cannot less than 10 digits")
	@Pattern(regexp = "(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}" , message = "Student mobile number must be in a proper formate")
	private String studentMobileNumber;
	
	@Column(name = "std_father_mobno")
	@NotBlank(message = "Student Mobile Number cannot be blank")
	@Min(value = 10 , message = "Mobile number cannot less than 10 digits")
	@Pattern(regexp = "(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}" , message = "Student Father mobile number must be in a proper formate")
	private String studentFatherMobileNumber;
}
