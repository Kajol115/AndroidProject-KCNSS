package com.example.dell.navigationdrawer;

/**
 * Created by dell on 11/02/2018.
 */

public class model {
    String name;
    //int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */

    model(String name){
        this.name = name;
       // this.value = value;
    }
    public String getName(){
        return this.name;
    }
    /*public int getValue(){
        return this.value;
    }*/
}
