package com.mattbock.llas.cardApi.model.ability;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CardAbility {

    @Id
    private int Id;
    private String effect;
    private String appliesTo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(String appliesTo) {
        this.appliesTo = appliesTo;
    }
}
