package com.management.hospital.managementhospital.repositories;

import com.management.hospital.managementhospital.models.PacientModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepository extends JpaRepository<PacientModel, Long> {

    public boolean existsByCPF(String string);

}
