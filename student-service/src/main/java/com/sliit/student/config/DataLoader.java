package com.sliit.student.config;

import com.sliit.student.entity.Student;
import com.sliit.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(StudentRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Student(null, "IT2026001", "Saranga", "Perera", "saranga@gmail.com", "Information Technology", 4));
                repository.save(new Student(null, "IT2026002", "Nimal", "Silva", "nimal@gmail.com", "Software Engineering", 3));
            }
        };
    }
}