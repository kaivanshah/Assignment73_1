package com.kaivanshah.assignment73;

/**
 * Created by kaivanrasiklal.s on 17-03-2017.
 */

public class Employee {

    //private variables
    int _id;
    String _name;
    int _Age;
    int _PhotoURL;

    // Empty constructor
    public Employee(){

    }
    // constructor
    public Employee(int id, String name, int Age, int PhotoURL){
        this._id = id;
        this._name = name;
        this._Age = Age;
        this._PhotoURL = _PhotoURL;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting Age
    public int getAge(){
        return this._Age;
    }

    // setting Age
    public void setAge(int Age){
        this._Age = Age;
    }


    // getting PhotoURL
    public int getPhotoURL(){
        return this._PhotoURL;
    }

    // setting PhotoURL
    public void setPhotoURL(int PhotoURL){
        this._PhotoURL = PhotoURL;
    }
}
