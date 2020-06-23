package com.ela.hibernateproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_AskDataOff")
public class AskDayOff extends Entities {

    @Column(name = "c_BeginDate")
    private Date beginDate;

    @Column(name = "c_EndDate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "c_status")
    private CategoryElement status;

    @ManyToOne
    @JoinColumn(name = "c_Employee")
    private Employee employee;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CategoryElement getStatus() {
        return status;
    }

    public void setStatus(CategoryElement status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

