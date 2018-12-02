package com.example.nate.second_app;

/**
 * Created by Nate on 11/23/2018.
 */

public class AllItems {
    private Integer id;
    private String item_name;
    private Boolean used;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return item_name;
    }

    public void setName(String name) {
        this.item_name = name;
    }

    public Boolean getUsed() { return used; }

    public void setUsed(Boolean used_flag) { this.used = used_flag; }
}
