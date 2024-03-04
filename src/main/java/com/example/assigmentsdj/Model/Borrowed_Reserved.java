package com.example.assigmentsdj.Model;

public class Borrowed_Reserved implements State{

    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException(vinyl.getTitle() + " is borrowed");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        throw new RuntimeException(vinyl.getTitle() +" is reserved");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        if(vinyl.getBorrower().equals(person))
        {
            vinyl.setLendingState(new Reserved());
            System.out.println(vinyl.getTitle() +" got returned " + person);
            vinyl.setBorrower(null);
        }
        else
            throw new RuntimeException("You cannot return vinyl that you did not borrowed");
    }
    @Override
    public void remove(Vinyl vinyl)
    {
        vinyl.setToBeRemoved(true);
        System.out.println(vinyl.getTitle() + " is about to get removed soon");
    }
    public String toString()
    {
        return "B&R";
    }
}
