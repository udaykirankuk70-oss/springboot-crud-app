/*package com.uday.crudapp.runner;

import com.uday.crudapp.entity.Student;
import com.uday.crudapp.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(StudentRepository repository) {
        return args -> {
            Student s = new Student("Uday", "uday@gmail.com", "Java");
            repository.save(s);
        };
    }
}*/
