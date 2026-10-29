package com.hospital.application.repository;

import com.hospital.application.entity.Patient;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface patientrepositry extends JpaRepository<Patient, Long> {

    //    Optional is a interface which give us ispresent, isequal, etc.
    Optional<Patient> findByPatientCode(String patientcode);

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByPhonenumber(String phonenumber);

    Optional<Patient> findByAadhaarnumber(String aadharnumber);


}