package com.management.hospital.managementhospital.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_room")
public class RoomModel implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;

@Column(nullable = false, unique = true)
private int roomNumber;

@Column(nullable = true, length = 256)
private String description;

@Column(nullable = false, length = 1)
private String department;

@Column(nullable = false)
private boolean allocated;

@Column(nullable = false)
private LocalDateTime registrationDate;

public static long getSerialversionuid() {
    return serialVersionUID;
}

public UUID getId() {
    return id;
}

public void setId(UUID id) {
    this.id = id;
}

public int getRoomNumber() {
    return roomNumber;
}

public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getDepartment() {
    return department;
}

public void setDepartment(String department) {
    this.department = department;
}

public LocalDateTime getRegistrationDate() {
    return registrationDate;
}

public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
}

public boolean isAllocated() {
    return allocated;
}

public void setAllocated(boolean allocated) {
    this.allocated = allocated;
}

}
