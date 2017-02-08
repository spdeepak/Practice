package com.movie.ticketing.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Deepak
 *
 */
@Entity
public class Concert {

    private long concertID;

    private String artist;

    private String name;

    private String duration;

    private String type;

    private int cost;

    private List<Event> events;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getConcertID() {
        return concertID;
    }

    public void setConcertID(long concertID) {
        this.concertID = concertID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
