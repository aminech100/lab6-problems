package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    ArrayList<Customer> customers;

    public Bank(String name, ArrayList<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public boolean addCustomer(String customerName){
        if (findCustomer(customerName) == null){
            customers.add(new Customer(customerName, new ArrayList<Double>()));
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName){
        for (Customer c : customers){
            if (c.getName().equalsIgnoreCase(customerName))
                return c;
        }
        return null;
    }

    public boolean addTransactionToCustomer(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public void printStatement(){
        System.out.println("========== Bank Statement for: " + name + "==========");
        for (Customer c : customers){
            System.out.println("Customer: " + c.getName());
            System.out.println("Transactions: ");
            for (Double t : c.getTransactions()){
                double amount = t;
                System.out.println("+ " + amount);
            }
            System.out.println("-----");
        }
    }
}
