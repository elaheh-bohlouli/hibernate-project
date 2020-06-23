package com.ela.hibernateproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@EntityListeners({Entities.class})
@Entity
@Table(name = "t_Category")
public class Category extends Entities {

    @Column(name = "c_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

