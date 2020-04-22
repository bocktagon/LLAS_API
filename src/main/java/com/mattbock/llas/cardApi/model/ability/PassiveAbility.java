package com.mattbock.llas.cardApi.model.ability;

import javax.persistence.*;

@Entity
@Table(name = "passive_abilities")
public class PassiveAbility {

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "buff_type_id")
    private BuffType buffedStat;

    @OneToOne
    @JoinColumn(name = "buff_target_id")
    private BuffTarget buffTarget;

    private double buffLb0;
    private double buffLb1;
    private double buffLb2;
    private double buffLb3;
    private double buffLb4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuffType getBuffedStat() {
        return buffedStat;
    }

    public void setBuffedStat(BuffType buffedStat) {
        this.buffedStat = buffedStat;
    }

    public BuffTarget getBuffTarget() {
        return buffTarget;
    }

    public void setBuffTarget(BuffTarget buffTarget) {
        this.buffTarget = buffTarget;
    }

    public double getBuffLb0() {
        return buffLb0;
    }

    public void setBuffLb0(double buffLb0) {
        this.buffLb0 = buffLb0;
    }

    public double getBuffLb1() {
        return buffLb1;
    }

    public void setBuffLb1(double buffLb1) {
        this.buffLb1 = buffLb1;
    }

    public double getBuffLb2() {
        return buffLb2;
    }

    public void setBuffLb2(double buffLb2) {
        this.buffLb2 = buffLb2;
    }

    public double getBuffLb3() {
        return buffLb3;
    }

    public void setBuffLb3(double buffLb3) {
        this.buffLb3 = buffLb3;
    }

    public double getBuffLb4() {
        return buffLb4;
    }

    public void setBuffLb4(double buffLb4) {
        this.buffLb4 = buffLb4;
    }
}
