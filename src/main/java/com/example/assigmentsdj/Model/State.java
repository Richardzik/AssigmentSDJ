package com.example.assigmentsdj.Model;

public interface State {
    void borrow(Vinyl vinyl, Person person);
    void reserve(Vinyl vinyl, Person person);
    void returnIt(Vinyl vinyl, Person person);
    void remove(Vinyl vinyl);
}
