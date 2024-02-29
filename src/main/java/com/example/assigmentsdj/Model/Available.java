package com.example.assigmentsdj.Model;

public class Available implements State{

    @Override
    public void borrow(Vinyl vinyl, Person person) {
        throw new RuntimeException("You can not borrow without reserving the vinyl");
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        vinyl.setLendingState(new Reserved());
        vinyl.setClient(person);
        System.out.println(vinyl + " got reserved");
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        throw new RuntimeException("The vinyl is available u can not return it");
    }
    public String toString()
    {
        return "Vinyl is available";
    }
}
