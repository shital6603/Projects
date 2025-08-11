package com.javaprojects.EMS_Backend.dto;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
