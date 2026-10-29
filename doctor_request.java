package com.health_management.Hospital_Management.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class doctor_request {


    @NotBlank(message = "required")
    private String doctorCode;

    @NotBlank(message = "name is required")
    private String firstName;

    @NotBlank(message = "required")
    private String lastName;

    @NotBlank(message = "specialization is required")
    private String specialization;

    @NotNull(message = "experience is required")
    private Integer experience;

    @NotBlank(message = "qualification is required")
    private String qualification;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "invalid phone")
    private String phoneno;

    @Email(message = "invalid")
    private String email;

    @NotBlank(message = "required")
    private String licenseNo;

    @NotBlank(message = "required")
    private String address;
}