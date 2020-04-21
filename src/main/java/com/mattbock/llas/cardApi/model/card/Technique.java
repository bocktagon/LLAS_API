package com.mattbock.llas.cardApi.model.card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="techniques")
public class Technique {

    @Id
    @Column(name="technique_id")
    private int id;

    private int lb0;
    private int lb1;
    private int lb2;
    private int lb3;
    private int lb4;
    private int lb5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLb0() {
        return lb0;
    }

    public void setLb0(int lb0) {
        this.lb0 = lb0;
    }

    public int getLb1() {
        return lb1;
    }

    public void setLb1(int lb1) {
        this.lb1 = lb1;
    }

    public int getLb2() {
        return lb2;
    }

    public void setLb2(int lb2) {
        this.lb2 = lb2;
    }

    public int getLb3() {
        return lb3;
    }

    public void setLb3(int lb3) {
        this.lb3 = lb3;
    }

    public int getLb4() {
        return lb4;
    }

    public void setLb4(int lb4) {
        this.lb4 = lb4;
    }

    public int getLb5() {
        return lb5;
    }

    public void setLb5(int lb5) {
        this.lb5 = lb5;
    }
}
