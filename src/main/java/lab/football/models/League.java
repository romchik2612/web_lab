package lab.football.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class League {
    private int id;
    @NotEmpty(message = "Name should not empty")
    @Size(min=2,max=30, message = "Wrong name")
    private String name;
    @Max(value = 10000, message = "Wrong number")
    @Min(value = 0,message = "Wrong number")
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

    @Override
    public String toString() {
        return "League{" + "\n" +
                "id = " + id + "," + "\n" +
                "name = '" + name + '\'' + "," + "\n" +
                "prizefond = " + prizefond + "\n" +
                '}';
    }

}