package com.management.hospital.managementhospital.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pacient")
public class PacientModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 130)
    private String name;

    @Column(nullable = false, length = 10)
    private String date;

    @Column(nullable = false, length = 3)
    private Integer age;

    @Column(nullable = false, length = 11)
    private String CPF;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    // ligação entre tabela product e pacient não funcionou
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_pacient", joinColumns = @JoinColumn(name = "pacient_id"), 
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductModel> products; */

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    /*public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }*/

}
