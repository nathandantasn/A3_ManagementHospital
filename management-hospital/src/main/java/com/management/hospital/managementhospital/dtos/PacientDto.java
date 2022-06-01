package com.management.hospital.managementhospital.dtos;

import javax.validation.constraints.Size;

public class PacientDto {

    private String name;

    @Size(max = 10)
    private String date;
    
    private Integer age;

    @Size(max = 11)
    private String CPF;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    
}
