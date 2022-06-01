package com.management.hospital.managementhospital.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.management.hospital.managementhospital.dtos.PacientDto;
import com.management.hospital.managementhospital.models.PacientModel;
import com.management.hospital.managementhospital.services.PacientService;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pacient")
public class PacientController {
    
    final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }
    
    @PostMapping
    public ResponseEntity<Object> savePacient(@RequestBody @Valid PacientDto pacientDto){

        if (pacientService.existsByCPF(pacientDto.getCPF())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF is already in use");
        }

        var PacientModel = new PacientModel();
        BeanUtils.copyProperties(pacientDto, PacientModel);
        PacientModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientService.save(PacientModel));
    }

    @GetMapping
    public ResponseEntity<Page<PacientModel>> getAllPacients(@PageableDefault(page=0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(pacientService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePacient(@PathVariable(value = "id") UUID id){
        Optional<PacientModel> pacientModelOptional = pacientService.findById(id);
        if(!pacientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacient not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacientModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePacient(@PathVariable(value = "id") UUID id, @RequestBody @Valid PacientDto pacientDto){
        Optional<PacientModel> pacientModelOptional = pacientService.findById(id);
        if(!pacientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacient not found");
        }
        var pacientModel = new PacientModel();
        BeanUtils.copyProperties(pacientDto, pacientModel);
        pacientModel.setId(pacientModelOptional.get().getId());
        pacientModel.setRegistrationDate(pacientModelOptional.get().getRegistrationDate());
        pacientModel.setCPF(pacientModelOptional.get().getCPF());
        return ResponseEntity.status(HttpStatus.OK).body(pacientService.save(pacientModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePacient(@PathVariable (value = "id") UUID id){
        Optional<PacientModel> pacientModelOptional = pacientService.findById(id);
        if(!pacientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacient not found");
        }

        pacientService.delete(pacientModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pacient deleted successfully");
    }


}
