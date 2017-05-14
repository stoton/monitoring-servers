package com.github.stoton.monitoring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "state")
@Proxy(lazy = false)
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Server server;

    private double cpuUsage;

    private double ramUsage;
    private long wholeRam;

    private double discUsage;
    private long wholeDisc;

    private double networkUsage;
    private int bandwidth;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAndTime;

    public State() {
        dateAndTime = LocalDateTime.now();
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public double getRamUsage() {
        return ramUsage;
    }

    public void setRamUsage(double ramUsage) {
        this.ramUsage = ramUsage;
    }

    public long getWholeRam() {
        return wholeRam;
    }

    public void setWholeRam(long wholeRam) {
        this.wholeRam = wholeRam;
    }

    public double getDiscUsage() {
        return discUsage;
    }

    public void setDiscUsage(double discUsage) {
        this.discUsage = discUsage;
    }

    public long getWholeDisc() {
        return wholeDisc;
    }

    public void setWholeDisc(long wholeDisc) {
        this.wholeDisc = wholeDisc;
    }

    public double getNetworkUsage() {
        return networkUsage;
    }

    public void setNetworkUsage(double networkUsage) {
        this.networkUsage = networkUsage;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", server=" + server +
                ", cpuUsage=" + cpuUsage +
                ", ramUsage=" + ramUsage +
                ", wholeRam=" + wholeRam +
                ", discUsage=" + discUsage +
                ", wholeDisc=" + wholeDisc +
                ", networkUsage=" + networkUsage +
                ", bandwidth=" + bandwidth +
                ", dateAndTime=" + dateAndTime +
                '}';
    }
}
