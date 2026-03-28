package com.example.courseservice.controller;

import com.example.courseservice.model.Course;
import com.example.courseservice.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
@Tag(name = "Course Controller", description = "APIs for managing courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new course")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCourse(course));
    }

    @GetMapping
    @Operation(summary = "Get all courses")
    public ResponseEntity<List<Course>> getAllCourses() throws Exception {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{courseCode}")
    @Operation(summary = "Get course by course code")
    public ResponseEntity<Course> getCourseByCode(@PathVariable String courseCode) throws Exception {
        return ResponseEntity.ok(service.getCourseByCode(courseCode));
    }

    @PutMapping("/{courseCode}")
    @Operation(summary = "Update course by course code")
    public ResponseEntity<Course> updateCourse(
            @PathVariable String courseCode,
            @Valid @RequestBody Course updatedCourse
    ) throws Exception {
        return ResponseEntity.ok(service.updateCourse(courseCode, updatedCourse));
    }

    @DeleteMapping("/{courseCode}")
    @Operation(summary = "Delete course by course code")
    public ResponseEntity<String> deleteCourse(@PathVariable String courseCode) throws Exception {
        return ResponseEntity.ok("Course deleted at: " + service.deleteCourse(courseCode));
    }
}
