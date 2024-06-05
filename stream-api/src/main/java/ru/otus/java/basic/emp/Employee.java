package ru.otus.java.basic.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private LocalDate birthday;
    private String jobName;
    private Double salary;
}
