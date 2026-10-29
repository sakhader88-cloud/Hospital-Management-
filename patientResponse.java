package com.hospital.application.dto;

import com.hospital.application.Enum.BloodGroup;
import com.hospital.application.Enum.Gender;
import com.hospital.application.Enum.PatientStatus;


public class patientResponse {

    private Long id;
    private String patientCode;
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private String phonenumber;
    private String email;
    private String aadharnumber;
    private BloodGroup bloodgroup;
    private String address;
    private String emergencyContact;
    private String admitDate;
    private PatientStatus status;
}