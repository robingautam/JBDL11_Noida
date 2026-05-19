package org.gfg.JBDL11_SpringJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jbdl11SpringJpaApplication implements CommandLineRunner {


	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jbdl11SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Student student = new Student();
		student.setId(1);
		student.setName("Robin");
		student.setEmail("robin@gmail.com");
		studentRepository.save(student);
		System.out.println("data saved");*/

	/*	Student student = studentRepository.findById(1).get();

		System.out.println(student);*/

	/*	Student student = studentRepository.findById(1).get();
		student.setName("Preeti");

		studentRepository.save(student);

		System.out.println("data saved");*/

	//	studentRepository.deleteById(1);

//	Student student	= studentRepository.findByNameAndEmailJPQL("Robin","robin@gmail.com");

		//System.out.println(student);

		int rows = studentRepository.deleteByEmail("robin@gmail.com");

		System.out.println(rows);

	}
}
