package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {
    Customers customer = new Customers(101, "Marco", 23, "0741009621");

    @Test
    void getIdCustomer() {
        assertEquals(101, customer.GetIdCustomer());
    }

    @Test
    void getName() {
        assertEquals("Marco", customer.GetName());
    }

    @Test
    void getAge() {
        assertEquals(23, customer.GetAge());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("0741009621", customer.GetPhoneNumber());
    }

    @Test
    void setIdCustomer() {
        assertEquals(102, customer.GetIdCustomer());
    }

    @Test
    void setName() {
        assertEquals("Mariah", customer.GetName());
    }

    @Test
    void setAge() {
        assertEquals(17, customer.GetAge());
    }

    @Test
    void setPhoneNumber() {
        assertEquals("0771550223", customer.GetPhoneNumber());
    }
}