package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Klass {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    @OneToOne(mappedBy = "klass",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="leader_id")
    private Leader leader;
    public Klass() {
    }

    public Klass(Long id,String name,Leader leader) {
        this.name = name;
        this.id=id;
        this.leader=leader;
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

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
