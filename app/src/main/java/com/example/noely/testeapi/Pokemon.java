package com.example.noely.testeapi;

public class Pokemon {
    private String Name;

    public Pokemon (String Name)
    {
        this.setName(Name);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
