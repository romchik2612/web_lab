package lab.football.models;

import java.util.ArrayList;
import java.util.List;

public class League {
    private int id;
    private String name;
    private int prizefond;

    public League() {
    }

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

    public int getPrizefond() {
        return prizefond;
    }

    public void setPrizefond(int prizefond) {
        this.prizefond = prizefond;
    }
}
