package hh.divesite.DiveSite.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Divelog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long divelogId;
    private LocalDateTime timeAdded;

    @JsonIgnoreProperties("divelogs")
    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User diver;

    @NotNull(message = "Dive number can't be empty")
    @Positive(message = "Dive number must be bigger than 0")
    private int diveNumber;

    private String description;

    @NotNull(message = "Dive date can't be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Dive date can't be in the future")
    private LocalDate diveDate;

    @NotBlank(message = "Start time can't be empty")
    private String startTime;

    @NotBlank(message = "End time can't be empty")
    private String endTime;

    @NotBlank(message = "Country can't be empty")
    private String country;

    private String region;

    @NotBlank(message = "Divesite can't be empty")
    private String divesite;

    private String diveType;

    @NotNull(message = "Max depth can't be empty")
    @Positive(message = "Max depth must be bigger than 0")
    private double maxDepth;

    @Positive(message = "Average depth must be bigger than 0")
    private double avgDepth;

    @Positive(message = "Start air must be bigger than 0")
    private int startAir;

    @PositiveOrZero(message = "End air can't be less than 0")
    private int endAir;

    @Positive(message = "Temperature must be bigger than 0")
    private int waterTemp;
    private String current;
    private String visibility;

    @PositiveOrZero(message = "Weight can't be less than 0")
    private int weights;
    private String wetsuit;
    private String gasBlend;

    public Divelog() {
    }

    // constructor with default start values
    public Divelog(int diveNumber) {
        this.diveNumber = diveNumber;
        this.timeAdded = LocalDateTime.now();
        this.diveDate = LocalDate.now();
        this.startAir = 200;
        this.endAir = 50;
        this.waterTemp = 24;
        this.maxDepth = 10;
        this.avgDepth = 5;
    }

    public Divelog(LocalDateTime timeAdded, User diver, int diveNumber, String description,
            LocalDate diveDate, String startTime, String endTime, String country, String region,
            String divesite, String diveType, double maxDepth, double avgDepth, int startAir, int endAir,
            int waterTemp, String current, String visibility, int weights, String wetsuit, String gasBlend) {
        this.timeAdded = timeAdded;
        this.diver = diver;
        this.diveNumber = diveNumber;
        this.description = description;
        this.diveDate = diveDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.country = country;
        this.region = region;
        this.divesite = divesite;
        this.diveType = diveType;
        this.maxDepth = maxDepth;
        this.avgDepth = avgDepth;
        this.startAir = startAir;
        this.endAir = endAir;
        this.waterTemp = waterTemp;
        this.current = current;
        this.visibility = visibility;
        this.weights = weights;
        this.wetsuit = wetsuit;
        this.gasBlend = gasBlend;
    }

    public Long getDivelogId() {
        return divelogId;
    }

    public void setDivelogId(Long divelogId) {
        this.divelogId = divelogId;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDateTime timeAdded) {
        this.timeAdded = timeAdded;
    }

    public int getDiveNumber() {
        return diveNumber;
    }

    public void setDiveNumber(int diveNumber) {
        this.diveNumber = diveNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDiveDate() {
        return diveDate;
    }

    public void setDiveDate(LocalDate diveDate) {
        this.diveDate = diveDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDivesite() {
        return divesite;
    }

    public void setDivesite(String divesite) {
        this.divesite = divesite;
    }

    public String getDiveType() {
        return diveType;
    }

    public void setDiveType(String diveType) {
        this.diveType = diveType;
    }

    public double getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(double maxDepth) {
        this.maxDepth = maxDepth;
    }

    public double getAvgDepth() {
        return avgDepth;
    }

    public void setAvgDepth(double avgDepth) {
        this.avgDepth = avgDepth;
    }

    public int getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(int waterTemp) {
        this.waterTemp = waterTemp;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int getWeights() {
        return weights;
    }

    public void setWeights(int weights) {
        this.weights = weights;
    }

    public String getWetsuit() {
        return wetsuit;
    }

    public void setWetsuit(String wetsuit) {
        this.wetsuit = wetsuit;
    }

    public String getGasBlend() {
        return gasBlend;
    }

    public void setGasBlend(String gasBlend) {
        this.gasBlend = gasBlend;
    }

    public int getStartAir() {
        return startAir;
    }

    public void setStartAir(int startAir) {
        this.startAir = startAir;
    }

    public int getEndAir() {
        return endAir;
    }

    public void setEndAir(int endAir) {
        this.endAir = endAir;
    }

    public User getDiver() {
        return diver;
    }

    public void setDiver(User diver) {
        this.diver = diver;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Divelog{");
        sb.append("divelogId=").append(divelogId);
        sb.append(", diver=").append(diver);
        sb.append(", timeAdded=").append(timeAdded);
        sb.append(", diveNumber=").append(diveNumber);
        sb.append(", description=").append(description);
        sb.append(", diveDate=").append(diveDate);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", country=").append(country);
        sb.append(", divestite=").append(divesite);
        sb.append(", maxDepth=").append(maxDepth);
        sb.append('}');
        return sb.toString();
    }
}
