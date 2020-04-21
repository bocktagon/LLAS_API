package com.mattbock.llas.cardApi.model.card;

import javax.persistence.*;

@Entity
@Table(name = "card_types")
public class CardType {

    @Id
    @Column(name="card_type_id")
    private int id;
    private String name;
    private String abbreviation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
