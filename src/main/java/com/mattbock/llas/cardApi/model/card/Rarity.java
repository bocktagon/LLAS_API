package com.mattbock.llas.cardApi.model.card;



import javax.persistence.*;

@Entity
@Table(name = "rarities")
public class Rarity extends CardProperty {

    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
