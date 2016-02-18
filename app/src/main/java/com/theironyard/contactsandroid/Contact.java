package com.theironyard.contactsandroid;

import java.io.Serializable;

/**
 * Created by alexanderhughes on 2/18/16.
 */
public class Contact {
    String name;
    String phone;

    public Contact(String name, String phone)  {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", name, phone);
    }
}
