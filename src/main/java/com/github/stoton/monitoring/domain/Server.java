package com.github.stoton.monitoring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "server")
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String server_token;

    @OneToMany(mappedBy = "server")
    private List<State> stateList;

    public Server() {}

    public String getServer_token() {
        return server_token;
    }

    public void setServer_token(String server_token) {
        this.server_token = server_token;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", stateList=" + stateList +
                '}';
    }
}
