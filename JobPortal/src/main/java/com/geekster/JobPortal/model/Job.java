package com.geekster.JobPortal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Job {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title cannot be null")
    @Length(min = 1, max = 255, message = "Title length should be between 1 and 255")
    private String title;

    @NotBlank(message = "Description cannot be null")
    @Length(max = 500)
    private String description;

    @NotBlank
    private String location;

    @NotNull(message = "Salary cannot be null")
    @PositiveOrZero(message = "Salary should be positive or zero")
    private Double salary;

    @NotBlank
    private String companyName;

    @NotBlank
    private String employerName;

    @NotNull(message = "Job type cannot be null")
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate appliedDate;
}
