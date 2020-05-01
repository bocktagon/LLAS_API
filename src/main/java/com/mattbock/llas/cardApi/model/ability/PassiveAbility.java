package com.mattbock.llas.cardApi.model.ability;

import javax.persistence.*;

@Entity
@Table(name = "passive_abilities")
public class PassiveAbility {

    @Id
    private int id;

    private String abilityText;

    @OneToOne
    @JoinColumn(name = "buff_type_id")
    private BuffType buffedStat;

    @OneToOne
    @JoinColumn(name = "buff_target_id")
    private BuffTarget buffTarget;

    private double buffLvl0;
    private double buffLvl1;
    private double buffLvl2;
    private double buffLvl3;
    private double buffLvl4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbilityText() {
        return abilityText;
    }

    public void setAbilityText(String abilityText) {
        this.abilityText = abilityText;
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

    public double getBuffLvl0() {
        return buffLvl0;
    }

    public void setBuffLvl0(double buffLvl0) {
        this.buffLvl0 = buffLvl0;
    }

    public double getBuffLvl1() {
        return buffLvl1;
    }

    public void setBuffLvl1(double buffLvl1) {
        this.buffLvl1 = buffLvl1;
    }

    public double getBuffLvl2() {
        return buffLvl2;
    }

    public void setBuffLvl2(double buffLvl2) {
        this.buffLvl2 = buffLvl2;
    }

    public double getBuffLvl3() {
        return buffLvl3;
    }

    public void setBuffLvl3(double buffLvl3) {
        this.buffLvl3 = buffLvl3;
    }

    public double getBuffLvl4() {
        return buffLvl4;
    }

    public void setBuffLvl4(double buffLvl4) {
        this.buffLvl4 = buffLvl4;
    }
}
