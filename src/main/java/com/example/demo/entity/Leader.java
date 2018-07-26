package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
    private  Klass klass;
    public Leader() {
    }

    public Leader(Long id,String name,Klass klass) {
        this.name = name;
        this.id=id;
        this.klass=klass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

}
