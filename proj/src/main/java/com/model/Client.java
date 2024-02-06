package com.model;

import java.io.Serializable;

public class Client extends User implements Serializable {
    public Client(){
        super();

    }
    public Client(String username, String password, String email){
        super(username, password, email,"CLIENT");
    }
}
