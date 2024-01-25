package com.model;

import java.io.Serializable;

public class WarehouseAdmin extends User implements Serializable {
    public WarehouseAdmin(String username, String password){
        super(username, password, "ADMIN");
    }
}
