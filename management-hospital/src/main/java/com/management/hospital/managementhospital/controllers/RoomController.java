package com.management.hospital.managementhospital.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.management.hospital.managementhospital.dtos.RoomDto;
import com.management.hospital.managementhospital.models.RoomModel;
import com.management.hospital.managementhospital.services.RoomService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Object> saveRoom(@RequestBody @Valid RoomDto roomDto) {

        if (roomService.existsByRoomNumber(roomDto.getRoomNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Room Number already exists");
        }

        var RoomModel = new RoomModel();
        BeanUtils.copyProperties(roomDto, RoomModel);
        RoomModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.save(RoomModel));
    }

    @GetMapping
    public ResponseEntity<Page<RoomModel>> getAllRooms(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.findAll(pageable));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getOneRoom(@PathVariable(value = "id") Long id) {
        Optional<RoomModel> roomModelOptional = roomService.findById(id);

        if (!roomModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(roomModelOptional.get());
    }

    @GetMapping("/roomNumber/{roomNumber}")
    public ResponseEntity<Object> getOneRoomByNumber(@PathVariable(value = "roomNumber") int roomNumber) {
        Optional<RoomModel> roomModelOptional = roomService.findByRoomNumber(roomNumber);

        if (!roomModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room not found. Please make sure the room is registered");
        }
        return ResponseEntity.status(HttpStatus.OK).body(roomModelOptional.get());
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Object> updateRoom(@PathVariable(value = "id") Long id, @RequestBody @Valid RoomDto roomDto) {
        Optional<RoomModel> roomModelOptional = roomService.findById(id);
        if (!roomModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        }
        var roomModel = new RoomModel();
        BeanUtils.copyProperties(roomDto, roomModel);
        roomModel.setId(roomModelOptional.get().getId());
        roomModel.setRoomNumber(roomModelOptional.get().getRoomNumber());
        roomModel.setRegistrationDate(roomModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(roomService.save(roomModel));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable(value = "id") Long id) {
        Optional<RoomModel> roomModelOptional = roomService.findById(id);
        if (!roomModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        }
        roomService.delete(roomModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Room deleted successfully");
    }

}
