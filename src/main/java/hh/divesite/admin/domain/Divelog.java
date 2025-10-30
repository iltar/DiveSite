package hh.divesite.admin.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Divelog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long divelogId;

    // private User diver;
    private LocalDate dateAdded;
    private LocalTime timeAdded;
    private int diveNumber;
    private String description;
    private LocalDate diveDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String country;
    private String region;
    private String divestite;
    private String diveType;
    private double maxDepth;
    private double avgDepth;
    private String waterTemp;
    private String current;
    private String visibility;
    private String weights;
    private String wetsuit;
    private String gasBlend;

        public Divelog() {
    }

    public Divelog(double avgDepth, String country, String current, LocalDate dateAdded, String description,
            LocalDate diveDate, int diveNumber, String diveType, Long divelogId, String divestite, LocalTime endTime,
            String gasBlend, double maxDepth, String region, LocalTime startTime, LocalTime timeAdded,
            String visibility, String waterTemp, String weights, String wetsuit) {
        this.avgDepth = avgDepth;
        this.country = country;
        this.current = current;
        this.dateAdded = dateAdded;
        this.description = description;
        this.diveDate = diveDate;
        this.diveNumber = diveNumber;
        this.diveType = diveType;
        this.divelogId = divelogId;
        this.divestite = divestite;
        this.endTime = endTime;
        this.gasBlend = gasBlend;
        this.maxDepth = maxDepth;
        this.region = region;
        this.startTime = startTime;
        this.timeAdded = timeAdded;
        this.visibility = visibility;
        this.waterTemp = waterTemp;
        this.weights = weights;
        this.wetsuit = wetsuit;
    }

    public Long getDivelogId() {
        return divelogId;
    }

    public void setDivelogId(Long divelogId) {
        this.divelogId = divelogId;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalTime timeAdded) {
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

    public String getDivestite() {
        return divestite;
    }

    public void setDivestite(String divestite) {
        this.divestite = divestite;
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

    public String getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(String waterTemp) {
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

    public String getWeights() {
        return weights;
    }

    public void setWeights(String weights) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Divelog{");
        sb.append("divelogId=").append(divelogId);
        sb.append(", dateAdded=").append(dateAdded);
        sb.append(", timeAdded=").append(timeAdded);
        sb.append(", diveNumber=").append(diveNumber);
        sb.append(", description=").append(description);
        sb.append(", diveDate=").append(diveDate);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", country=").append(country);
        sb.append(", divestite=").append(divestite);
        sb.append(", maxDepth=").append(maxDepth);
        sb.append('}');
        return sb.toString();
    }



}
