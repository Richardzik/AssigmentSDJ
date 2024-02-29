package com.example.assigmentsdj.Model;

public class Reserved implements State{


    @Override
    public void borrow(Vinyl vinyl, Person person) {
        if(vinyl.getReservist().equals(person))
        {
            vinyl.setLendingState(new Borrowed());
            System.out.println(vinyl + " got borrowed by " + person);
            vinyl.setBorrower(person);
            vinyl.setReservist(null);
        }
        else
            throw new RuntimeException("Vinyl is reserved by someone else");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        throw new RuntimeException("Vinyl is reserved by someone else");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        throw new RuntimeException("You cannot return the reserved vinyl");
    }
    @Override
    public void remove(Vinyl vinyl)
    {
        vinyl.setToBeRemoved(true);
    }
    public String toString()
    {
        return "reserved";
    }
}
