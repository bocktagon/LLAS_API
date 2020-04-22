package com.mattbock.llas.cardApi.model.idol;

import javax.persistence.*;

@Entity
@Table(name = "idols")
public class Idol {

    @Id
    private int id;

    private String firstName;
    private String lastName;
    private String color;
    private int year;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToOne
    @JoinColumn(name = "idol_group_id")
    private IdolGroup idolGroup;

    @OneToOne
    @JoinColumn(name = "subunit_id")
    private Subunit subunit;

    public Idol() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public IdolGroup getIdolGroup() {
        return idolGroup;
    }

    public void setIdolGroup(IdolGroup idolGroup) {
        this.idolGroup = idolGroup;
    }

    public Subunit getSubunit() {
        return subunit;
    }

    public void setSubunit(Subunit subunit) {
        this.subunit = subunit;
    }
}
