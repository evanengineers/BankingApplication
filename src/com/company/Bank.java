package com.company;

import java.util.ArrayList;

public class Bank {
//        1.  Bank
//        -  It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
//        -  A constructor that takes a String (name of the bank). It initialises name and instantiates branches.

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    //    -  And five methods, they are (their functions are in their names):
//    -  addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the branch was added successfully or false otherwise.
    public boolean addBranch(String nameOfTheBranch) {
        for (int i = 0; i < this.branches.size(); i++) {
            String branchName = branches.get(i).getName();
            if (branchName.equals(nameOfTheBranch)) {
                System.out.println("Branch name already exists. Unable to add.");
                return false;
            }
        }
        this.branches.add(new Branch(nameOfTheBranch));
        System.out.println("New Branch added Successfully!");
        System.out.println("Branch Name ---> " + nameOfTheBranch);
        return true;
    }


//-  addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double (initial transaction) and returns a boolean.
// It returns true if the customer was added successfully or false otherwise.

    public boolean addCustomer(String nameOfTheBranch, String nameOfTheCustomer, double initialTransaction) {

        if (findBranch(nameOfTheBranch) == null) {
            System.out.println("Branch does not exist. Please add an existing Branch.");
            return false;
        } else if ((findBranch(nameOfTheBranch).findCustomer(nameOfTheCustomer) != null)) {
            System.out.println("Customer already exists at this branch.");
            return false;
        } else {
            findBranch(nameOfTheBranch).newCustomer(nameOfTheCustomer, initialTransaction);
            return true;
        }
    }

    //    -  findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if it exists or null otherwise.
    public Branch findBranch(String nameOfTheBranch) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getName().equals(nameOfTheBranch)) {
                return branch;
            }
        }
        return null;
    }
//-  addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the customer), double (transaction) and returns a boolean.
// It returns true if the customers transaction was added successfully or false otherwise.

    public boolean addCustomerTransaction(String nameOfTheBranch, String nameOfTheCustomer, double transaction) {
        if (findBranch(nameOfTheBranch) == null) {
            System.out.println("Branch does not exist. Please add an existing Branch.");
            return false;
        } else if ((findBranch(nameOfTheBranch).findCustomer(nameOfTheCustomer) == null)) {
            System.out.println("Customer does not exist at this branch. Please add new customer.");
            return false;
        } else {
            findBranch(nameOfTheBranch).findCustomer(nameOfTheCustomer).addTransaction(transaction);
            System.out.println("Transaction added:");
            System.out.println(nameOfTheCustomer + " --> " + transaction);
            return true;
        }
    }

    public boolean listCustomers(String nameOfTheBranch, boolean printTransactions) {
        if (findBranch(nameOfTheBranch) == null) {
            System.out.println("Branch name does not exist.");
            return false;
        } else {
            System.out.println("Customer details for branch " + findBranch(nameOfTheBranch).getName());
            for (int i = 0; i < findBranch(nameOfTheBranch).getCustomers().size(); i++) {
                System.out.println("Customer: " + findBranch(nameOfTheBranch).getCustomers().get(i).getName() +
                        "[" + (i + 1) + "]");
                System.out.println("Transactions");
                for (int j = 0; j < (findBranch(nameOfTheBranch).getCustomers().get(i).getTransactions().size()); j++) {
                    System.out.println("[" + (j + 1) + "]  Amount  " +
                            (findBranch(nameOfTheBranch).getCustomers().get(i).getTransactions().get(j)));
                }
            }
            return true;
        }
    }


//    -  listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns a boolean. Return true if the branch exists or false otherwise.
// This method prints out a list of customers.
//→ TEST CODE
//        Bank bank = new Bank("National Australia Bank");
//        bank.addBranch("Adelaide");
//        bank.addCustomer("Adelaide", "Tim", 50.05);
//        bank.addCustomer("Adelaide", "Mike", 175.34);
//        bank.addCustomer("Adelaide", "Percy", 220.12);
//        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
//        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
//        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
//        bank.listCustomers("Adelaide", true);
//→ OUTPUT
//        The list of customers should be printed out in the following format if boolean parameter is true:
//        Customer details for branch Adelaide
//        Customer: Tim[1]
//        Transactions
//                [1]  Amount 50.05
//                [2]  Amount 44.22
//                [3]  Amount 12.44
//        Customer: Mike[2]
//        Transactions
//                [1]  Amount 175.34
//                [2]  Amount 1.65
//        Customer: Percy[3]
//        Transactions
//                [1]  Amount 220.12
//        and if false, only the customers - no transactions:
//        bank.listCustomers("Adelaide", false);
//        Customer details for branch Adelaide
//        Customer: Tim[1]
//        Customer: Mike[2]
//        Customer: Percy[3]
}
