package com.ela.hibernateproject.model;

import javax.persistence.*;

@Entity
@Table(name = "t_Employee")
public class Employee extends Entities {

    @Column(name = "c_Name")
    private String name;

    @Column(name = "c_LastName")
    private String lastName;

    @Column(name = "c_head")
    private String head;

    @ManyToOne
    @JoinColumn(name = "c_categoryElements")
    private CategoryElement categoryElement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public CategoryElement getCategoryElement() {
        return categoryElement;
    }

    public void setCategoryElement(CategoryElement categoryElement) {
        this.categoryElement = categoryElement;
    }
}
