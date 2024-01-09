package com.virtualthread.virtualmethod.Domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "vthr")
public class Vthr {
    @Id
    @Column(name = "id")
    private Long id;


    @Override
    public String toString() {
        return "Vthr{" +
                "id=" + id +
                '}';
    }
}
