package com.mattbock.llas.cardApi.model.card;

import javax.persistence.*;

@Entity
@Table(name = "attributes")
public class Attribute {

    @Id
    @Column(name="attribute_id")
    private int id;
    private String name;

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
}
