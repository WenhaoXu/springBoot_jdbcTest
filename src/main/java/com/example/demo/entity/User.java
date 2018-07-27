package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "user_Group",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "Group_id"))
    private List<Group> groupList=new ArrayList<>();

    public User(String name, List<Group> groupList) {
        this.name = name;
        this.groupList = groupList;
    }

    public User() {
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

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
