package com.mattbock.llas.cardApi.model.idol;

import javax.persistence.*;

@Entity
@Table(name = "idol_groups")
public class IdolGroup {

    @Id
    @Column(name="idol_group_id")
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
