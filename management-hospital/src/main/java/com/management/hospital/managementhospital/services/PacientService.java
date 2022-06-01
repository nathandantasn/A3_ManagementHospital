package com.management.hospital.managementhospital.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.management.hospital.managementhospital.models.PacientModel;
import com.management.hospital.managementhospital.repositories.PacientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacientService {

    final PacientRepository pacientRepository;

    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public boolean existsByCPF(String string) {
        return pacientRepository.existsByCPF(string);
    }

    @Transactional
    public PacientModel save(PacientModel pacientModel) {
        return pacientRepository.save(pacientModel);
    }

    public Page<PacientModel> findAll(Pageable pageable) {
        return pacientRepository.findAll(pageable);
    }

    public Optional<PacientModel> findById(UUID id) {
        return pacientRepository.findById(id);
    }

    @Transactional
    public void delete(PacientModel pacientModel) {
        pacientRepository.delete(pacientModel);
    }
    

}
