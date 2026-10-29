package com.hospital.application.dto;

import com.hospital.application.Enum.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class patientRequest {

    @NotBlank(message = "required")
    private String patientCode;
    @NotBlank(message = "Name is required")
    private String firstname;
    @NotBlank(message = "required")
    private String lastname;
    @NotNull(message = "required")
    private int age;
    @NotBlank(message = "gender is required")
    private Gender gender;
    @Pattern(regexp = "^[6_9]\\d{9}$", message = "invalid phone Number")
    private String phonenumber;
    @Email(message = "invalid mail format")
    private String email;
    @NotBlank(message = "required")
    private String aadharnumber;
    @NotNull(message = "required")
    private String bloodgroup;
    @NotBlank(message = "requires")
    private String address;
    @Pattern(regexp = "^[6_9]\\d{9}$", message = "invalid Phone number")
    private String emergencyContact;
    @NotBlank(message = "required")
    private String admitDate;
    @NotBlank(message = "required")
    private String status;
}