package com.management.hospital.managementhospital.repositories;

import java.util.Optional;
import java.util.UUID;

import com.management.hospital.managementhospital.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, UUID> {

    public boolean existsByRoomNumber(int roomNumber);

    public Optional<RoomModel> findByRoomNumber(int roomNumber);
}
