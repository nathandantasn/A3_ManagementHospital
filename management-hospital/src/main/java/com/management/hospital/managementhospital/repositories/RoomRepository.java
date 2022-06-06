package com.management.hospital.managementhospital.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.hospital.managementhospital.models.RoomModel;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {

    public boolean existsByRoomNumber(int roomNumber);

    public Optional<RoomModel> findByRoomNumber(int roomNumber);
}
