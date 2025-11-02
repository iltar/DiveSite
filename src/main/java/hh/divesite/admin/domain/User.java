package hh.divesite.admin.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String username;
    private String passwordHash;
    private String email;
    private String description;
    private String level;
    private int dives;
    private String role;

    @OneToMany
    private List<Divelog> divelogs;

    public User() {
    }

    public User(Long userId, String username, String passwordHash, String email, String description, String level,
            int dives, String role, List<Divelog> divelogs) {
        this.userId = userId;
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
                + ", level=" + level + ", dives=" + dives + ", role=" + role + ", divelogs=" + divelogs + "]";
    }
    
}
