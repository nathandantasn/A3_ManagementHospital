package com.management.hospital.managementhospital.repositories;

import java.util.UUID;

import com.management.hospital.managementhospital.models.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepository extends JpaRepository<PacientModel, UUID> {

    public boolean existsByCPF(String string);

}
