package com.hospital.application.dto;

import com.hospital.application.entity.Patient;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface patientMapper {

    Patient toEntity(patientRequest par);
    patientResponse toResponse(Patient p);

    void updatePatientFromRequests(patientRequest par, @MappingTarget Patient pt);
}