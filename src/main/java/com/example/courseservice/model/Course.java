package com.example.courseservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Course entity")
public class Course {

    @Schema(description = "Unique course code", example = "CS101")
    @NotBlank(message = "Course code is required")
    private String courseCode;

    @Schema(description = "Course title", example = "Microservices Architecture")
    @NotBlank(message = "Title is required")
    private String title;

    @Schema(description = "Number of course credits", example = "3")
    @Min(value = 1, message = "Credits must be at least 1")
    @Max(value = 10, message = "Credits must be at most 10")
    private Integer credits;

    @Schema(description = "Assigned lecturer name", example = "Dr. Silva")
    @NotBlank(message = "Lecturer name is required")
    private String lecturerName;

    @Schema(description = "Department offering the course", example = "IT")
    @NotBlank(message = "Department is required")
    private String department;
}
