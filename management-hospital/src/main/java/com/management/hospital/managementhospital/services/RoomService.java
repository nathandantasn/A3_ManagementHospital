package com.management.hospital.managementhospital.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.management.hospital.managementhospital.models.RoomModel;
import com.management.hospital.managementhospital.repositories.RoomRepository;

@Service
public class RoomService {

    final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public boolean existsByRoomNumber(int roomNumber) {
        return roomRepository.existsByRoomNumber(roomNumber);
    }

    @Transactional
    public RoomModel save(RoomModel roomModel) {
        return roomRepository.save(roomModel);
    }

    public Page<RoomModel> findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    public Optional<RoomModel> findById(UUID id) {
        return roomRepository.findById(id);
    }

    public Optional<RoomModel> findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public void delete(RoomModel roomModel) {
        roomRepository.delete(roomModel);
    }

}
