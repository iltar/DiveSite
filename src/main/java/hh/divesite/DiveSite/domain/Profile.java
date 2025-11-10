package hh.divesite.DiveSite.domain;

import jakarta.validation.constraints.PositiveOrZero;

public class Profile {
    private String username;
    private String level;

    @PositiveOrZero(message = "Number of dives can't be less than 0")
    private int dives;
    private String description;

    public Profile() {
    }

    public Profile(String username) {
        this.username = username;
        this.level = "";
        this.dives = 0;
        this.description = "";
    }

    public Profile(User user) {
        this.username = user.getUsername();
        this.level = user.getLevel();
        this.dives = user.getDives();
        this.description = user.getDescription();
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public int getDives() {
        return dives;
    }
    public void setDives(int dives) {
        this.dives = dives;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Profile [username=" + username + ", level=" + level + ", dives=" + dives + ", description="
                + description + "]";
    }
    
}
