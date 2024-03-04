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
    public String toString()
    {
        return name;
    }
}
