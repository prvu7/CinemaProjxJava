package org.example.models;

import org.example.interfaces.ICustomers;

public class Customers implements ICustomers {
    private int idCustomer;
    private String name;
    private int age;
    private String phoneNumber;

    //Constructors
    public Customers() {}
    public Customers(int idCustomer, String name, int age, String phoneNumber) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public int GetIdCustomer() {
        return idCustomer;
    }
    public String GetName() {
        return name;
    }
    public int GetAge() {
        return age;
    }
    public String GetPhoneNumber() {
        return phoneNumber;
    }

    //Setters
    public void SetIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public void SetAge(int age) {
        this.age = age;
    }
    public void SetPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "idCustomer=" + idCustomer +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
