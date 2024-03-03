package com.example.assigmentsdj.Model;

public class Vinyl {
    private final String title;
    private final String artist;
    private final int year;
    private State lendingState;
    private Person borrower;
    private Person reservist;
    private boolean toBeRemoved;
    public Vinyl(String title, String artist, int year, Person borrower, Person reservist)
    {
        this.title=title;
        this.artist=artist;
        this.year = year;
        this.lendingState = new Available();
        this.borrower = borrower;
        this.reservist = reservist;
        toBeRemoved = false;
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


    public String getArtist() {
        return artist;
    }


    public String getTitle() {
        return title;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }

    public Person getReservist() {
        return reservist;
    }

    public void setReservist(Person reservist) {
        this.reservist = reservist;
    }

    public boolean isToBeRemoved() {
        return toBeRemoved;
    }

    public void setToBeRemoved(boolean toBeRemoved) {
        this.toBeRemoved = toBeRemoved;
    }
    public void borrow(Vinyl vinyl, Person person)
    {
        lendingState.borrow(vinyl,person);
    }
    public void reserve(Vinyl vinyl, Person person)
    {
        lendingState.reserve(vinyl,person);
    }
    public void returnIt(Vinyl vinyl, Person person)
    {
        lendingState.returnIt(vinyl,person);
    }
    public void remove(Vinyl vinyl)
    {
        lendingState.remove(vinyl);
    }
}
