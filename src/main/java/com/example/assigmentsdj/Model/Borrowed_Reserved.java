package com.example.assigmentsdj.Model;

public class Borrowed_Reserved implements State{

    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException("Vinyl is borrowed");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        throw new RuntimeException("Vinyl is reserved");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        if(vinyl.getBorrower().equals(person))
        {
            vinyl.setLendingState(new Reserved());
            System.out.println("Vinyl got returned");
        }
        else
            throw new RuntimeException("You cannot return vinyl that you did not borrowed");
    }
    @Override
    public void remove(Vinyl vinyl)
    {
        vinyl.setToBeRemoved(true);
    }
    public String toString()
    {
        return "borrowed and reserved";
    }
}
