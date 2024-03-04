package com.example.assigmentsdj.Model;

public class Borrowed implements State{


    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException("You cannot borrow borrowed vinyl");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        if(!vinyl.getBorrower().equals(person) && !vinyl.isToBeRemoved())
        {
            vinyl.setLendingState(new Borrowed_Reserved());
            System.out.println("Vinyl got reserved by " + person);
            vinyl.setReservist(person);
        }
        else
            throw new RuntimeException("You cannot reserve vinyl that you borrowed");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        if(vinyl.getBorrower().equals(person))
        {
            vinyl.setLendingState(new Available());
            System.out.println("Vinyl got returned by " + person);
            vinyl.setBorrower(null);
        }
        else
            throw new RuntimeException("You cannot return vinyl that you don't have");

        if(vinyl.isToBeRemoved())
        {
            vinyl.setLendingState(new Removed());
            System.out.println("Vinyl got removed");
            vinyl.setBorrower(null);
            vinyl.setReservist(null);
        }
    }
    @Override
    public void remove(Vinyl vinyl)
    {
        vinyl.setToBeRemoved(true);
    }
    public String toString()
    {
        return "borrowed";
    }
}
