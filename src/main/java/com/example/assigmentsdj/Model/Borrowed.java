package com.example.assigmentsdj.Model;

public class Borrowed implements State{


    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException("You cannot borrow borrowed vinyl");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        if(!vinyl.getClient().equals(person))
        {
            vinyl.setLendingState(new Borrowed_Reserved());
            System.out.println("Vinyl got reserved by " + person);
        }
        else
            throw new RuntimeException("You cannot reserve vinyl that you borrowed");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        if(vinyl.getClient().equals(person))
        {
            vinyl.setLendingState(new Available());
            System.out.println("Vinyl got returned by " + person);
            vinyl.setClient(null);
        }
        else
            throw new RuntimeException("You cannot return vinyl that you don't have");
    }
}
