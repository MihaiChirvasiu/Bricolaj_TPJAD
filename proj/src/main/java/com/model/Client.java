package com.model;

import java.io.Serializable;

public class Client extends User implements Serializable {
    public Client(){
        this.setRole("CLIENT");
    }
}
