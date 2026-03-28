package com.example.courseservice.service;

import com.example.courseservice.exception.ResourceNotFoundException;
import com.example.courseservice.model.Course;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final String COLLECTION_NAME = "courses";

    private final Firestore firestore;

    public CourseService(Firestore firestore) {
        this.firestore = firestore;
    }

    public Course createCourse(Course course) throws Exception {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(course.getCourseCode());

        DocumentSnapshot existing = docRef.get().get();
        if (existing.exists()) {
            throw new RuntimeException("Course with code " + course.getCourseCode() + " already exists");
        }

        ApiFuture<WriteResult> writeResult = docRef.set(course);
        writeResult.get();

        return course;
    }

    public List<Course> getAllCourses() throws Exception {
        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Course> courses = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            courses.add(document.toObject(Course.class));
        }

        return courses;
    }

    public Course getCourseByCode(String courseCode) throws Exception {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(courseCode);
        DocumentSnapshot snapshot = docRef.get().get();

        if (!snapshot.exists()) {
            throw new ResourceNotFoundException("Course not found with code: " + courseCode);
        }

        return snapshot.toObject(Course.class);
    }

    public Course updateCourse(String courseCode, Course updatedCourse) throws Exception {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(courseCode);
        DocumentSnapshot snapshot = docRef.get().get();

        if (!snapshot.exists()) {
            throw new ResourceNotFoundException("Course not found with code: " + courseCode);
        }

        // Keep route param as source of truth
        updatedCourse.setCourseCode(courseCode);

        ApiFuture<WriteResult> writeResult = docRef.set(updatedCourse);
        writeResult.get();

        return updatedCourse;
    }

    public String deleteCourse(String courseCode) throws Exception {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(courseCode);
        DocumentSnapshot snapshot = docRef.get().get();

        if (!snapshot.exists()) {
            throw new ResourceNotFoundException("Course not found with code: " + courseCode);
        }

        ApiFuture<WriteResult> writeResult = docRef.delete();
        return writeResult.get().getUpdateTime().toString();
    }
}
