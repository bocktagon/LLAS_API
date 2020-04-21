package com.mattbock.llas.cardApi.model.ability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ability_types")
public class AbilityType {

    // type (appeal boost, crit rate up, crit gain up, damage reduction, stam recovery, shield,
    //      skill activation rate up, sp gauge gain up, sp gauge boost, Vo boost, Vo gain increase,
    //      Vo boost on SP skill, passive stat buff)

    @Id
    @Column(name = "ability_type_id")
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
