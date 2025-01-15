package org.example.interfaces;

public interface ICustomers {
    public int GetIdCustomer();
    public String GetName();
    public int GetAge();
    public String GetPhoneNumber();

    public void SetIdCustomer(int idCustomer);
    public void SetName(String name);
    public void SetAge(int age);
    public void SetPhoneNumber(String phoneNumber);
}
