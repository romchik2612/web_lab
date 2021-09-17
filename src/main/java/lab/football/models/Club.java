package lab.football.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private int id;
    @NotEmpty(message = "Name should not empty")
    @Size(min=2,max=30, message = "Wrong name")
    private String name;
    @Min(value = 1800, message = "Wrong year")
    @Max(value = 2021,message = "Wrong year")
    private int year_of_birth;
    private int league_id;
    @Min(value = 0,message = "Wrong number")
    @Max(value = 150,message = "Wrong number")
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Club() {
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

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    @Override
    public String toString() {
        return "Club{" + "\n" +
                "id = " + id + "," +"\n" +
                "name = '" + name + '\'' + "," + "\n" +
                "year_of_birth = " + year_of_birth + "," +"\n" +
                "points = " + points + "," + "\n" +
                "league_id = " + league_id + "," + "\n" +
                '}';
    }
}
