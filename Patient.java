package com.hospital.application.entity;

import com.hospital.application.Enum.BloodGroup;
import com.hospital.application.Enum.Gender;
import com.hospital.application.Enum.PatientStatus;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private long Id;
    @Column(nullable = false)
    private String patientcode;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String adhaarnumber;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, unique = true)
    private String emergencyContact;
    @Column(nullable = false)
    private String admitDate;
    @Enumerated(EnumType.STRING)
    private PatientStatus status;
}








