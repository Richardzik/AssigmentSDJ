package com.example.assigmentsdj.Model;

public class Person {
    private String name;
    public Person(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass()!=getClass())
            return false;
        Person other = (Person) obj;
        return other.name.equals(name);
    }


    // The person somehow needs to be identified and connected to the vinyl that he/she
    // borrowed or reserved. If not then the issues could appear
    // For example if person A reserve the Vinyl A, the vinyl becomes reserved
    // now the person B wants to borrow it, without some identification he will be able
    // to do it.
}
