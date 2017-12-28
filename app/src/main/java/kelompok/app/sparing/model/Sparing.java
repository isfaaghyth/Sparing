package kelompok.app.sparing.model;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class Sparing {
    private int id;
    private Team team_a;
    private Team team_b;
    private Area area;
    private String date_playing;
    private String status;

    public int getId() {
        return id;
    }

    public Team getTeam_a() {
        return team_a;
    }

    public Team getTeam_b() {
        return team_b;
    }

    public Area getArea() {
        return area;
    }

    public String getDate_playing() {
        return date_playing;
    }

    public String getStatus() {
        return status;
    }
}
