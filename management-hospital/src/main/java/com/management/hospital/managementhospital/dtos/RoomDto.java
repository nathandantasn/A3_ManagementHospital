package com.management.hospital.managementhospital.dtos;

import javax.validation.constraints.Size;

public class RoomDto {

    private int roomNumber;

    @Size(max = 256)
    private String description;

    @Size(max = 1)
    private String department;

    private boolean allocated;

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

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

}
