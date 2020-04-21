package com.mattbock.llas.cardApi.model.card;



import javax.persistence.*;

@Entity
@Table(name = "rarities")
public class Rarity {

    @Id
    @Column(name = "rarity_id")
    private int id;
    private String name;
    private String abbreviation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
