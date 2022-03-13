package ru.geekbrains.nostromo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Rover {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String model;


    public Rover(String name, String model) {
        this.name = name;
        this.model = model;
    }
}
