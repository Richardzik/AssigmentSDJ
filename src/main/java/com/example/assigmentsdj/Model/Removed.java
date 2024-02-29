package com.example.assigmentsdj.Model;

public class Removed implements State{

    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException("You cannot borrow removed vinyl");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        throw new RuntimeException("You cannot reserve removed vinyl");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        throw new RuntimeException("You cannot return removed vinyl");
    }

    @Override
    public void remove(Vinyl vinyl) {
        throw new RuntimeException("You cannot remove removed vinyl");
    }
    public String toString()
    {
        return "removed";
    }
}
