package lab.football.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Player {
    private int id;
    @NotEmpty(message = "Name should not empty")
    @Size(min=2,max=30, message = "Wrong name")
    private String name;
    @NotEmpty(message = "Sourname should not empty")
    @Size(min=2,max=30, message = "Wrong name")
    private String sourname;
    @Min(value = 1,message = "Wrong number")
    @Max(value = 99,message = "Wrong number")
    private int number;
    @Min(value = 0,message = "Wrong mark")
    @Max(value = 10, message = "Wrong mark")
    private double mark;

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    private int club_id;

    public Player() {
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

    public String getSourname() {
        return sourname;
    }

    public void setSourname(String sourname) {
        this.sourname = sourname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }
}
