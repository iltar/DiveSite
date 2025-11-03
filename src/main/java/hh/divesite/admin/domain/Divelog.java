package hh.divesite.admin.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Divelog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long divelogId;
    private LocalDateTime timeAdded;

    //@ManyToOne
    //@JoinColumn(name="userId")
    //private User diver;

    private int diveNumber;
    private String description;
    private LocalDate diveDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String country;
    private String region;
    private String divesite;
    private String diveType;
    private double maxDepth;
    private double avgDepth;
    private int startAir;
    private int endAir;
    private int waterTemp;
    private String current;
    private String visibility;
    private int weights;
    private String wetsuit;
    private String gasBlend;

    public Divelog() {
    }

    // parametri: User diver, 
    public Divelog(Long divelogId, LocalDateTime timeAdded, int diveNumber, String description,
            LocalDate diveDate, LocalTime startTime, LocalTime endTime, String country, String region,
            String divesite, String diveType, double maxDepth, double avgDepth, int startAir, int endAir,
            int waterTemp, String current, String visibility, int weights, String wetsuit, String gasBlend) {
        this.divelogId = divelogId;
        this.timeAdded = timeAdded;
        //this.diver = diver;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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
    /*
    public User getDiver() {
        return diver;
    }

    public void setDiver(User diver) {
        this.diver = diver;
    }
     */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Divelog{");
        sb.append("divelogId=").append(divelogId);
        //sb.append(", diver=").append(diver);
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
