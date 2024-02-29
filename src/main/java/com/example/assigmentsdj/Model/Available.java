package com.example.assigmentsdj.Model;

public class Available implements State{

    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException("You can not borrow without reserving the vinyl");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        vinyl.setLendingState(new Reserved());
        vinyl.setReservist(person);
        System.out.println(vinyl + " got reserved");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        throw new RuntimeException("The vinyl is available u can not return it");
    }
    @Override
    public void remove(Vinyl vinyl)
    {
        vinyl.setLendingState(new Removed());
        System.out.println(vinyl.getTitle() +" has been removed");
    }
    public String toString()
    {
        return "available";
    }
}
