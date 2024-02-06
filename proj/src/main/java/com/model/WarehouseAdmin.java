package com.model;

import java.io.Serializable;

public class WarehouseAdmin extends User implements Serializable {

    public WarehouseAdmin(){
        super();
    }
    public WarehouseAdmin(String username, String password, String email){
        super(username, password, email, "ADMIN");
    }
}
