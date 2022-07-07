package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Director extends User {

    @OneToOne
    private School school;
}
