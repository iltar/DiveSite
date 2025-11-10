package hh.divesite.DiveSite.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column (nullable = false, unique = true)
    private String username;

    @Column (nullable = false)
    private String passwordHash;

    @Column (nullable = false, unique = true)
    private String email;
    private String description;
    private String level;
    private int dives;

    @Column (nullable = false)
    private String role;

    @JsonIgnoreProperties("diver")
    @OneToMany
    private List<Divelog> divelogs;

    public User() {
    }

    // only manditory fields, used for testing purposes mainly
    public User(String username, String passwordHash, String email, String role) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    public User(String username, String passwordHash, String email, String description, String level,
            int dives, String role, List<Divelog> divelogs) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.description = description;
        this.level = level;
        this.dives = dives;
        this.role = role;
        this.divelogs = divelogs;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
     public List<Divelog> getDivelogs() {
        return divelogs;
    }

    public void setDivelogs(List<Divelog> divelogs) {
        this.divelogs = divelogs;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", description=" + description
                + ", level=" + level + ", dives=" + dives + ", role=" + role + "]";
    }
    
}
