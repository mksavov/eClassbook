package com.example.demo.enums;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum Subjects {
    MATH, BIOLOGY, ENGLISH, GEOGRAPHY, HISTORY
    ;

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
