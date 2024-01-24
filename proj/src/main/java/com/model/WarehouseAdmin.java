package com.model;

import java.io.Serializable;

public class WarehouseAdmin extends User implements Serializable {
    public WarehouseAdmin(){
        this.setRole("ADMIN");
    }
}
