package com.example.assigmentsdj.Model;

public class Vinyl {
    private String title;
    private String artist;
    private int year;
    private State lendingState;
    private Person client;
    public Vinyl(String title, String artist, int year, Person client)
    {
        this.title=title;
        this.artist=artist;
        this.year = year;
        this.lendingState = new Available();
        this.client = client;
    }

    public State getLendingState() {
        return lendingState;
    }

    public void setLendingState(State lendingState) {
        this.lendingState = lendingState;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

}
