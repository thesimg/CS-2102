public class BankAccount {
    /** a name in "First Last format */
    public String customer;
    /** a balance in $ USD */
    public double balance;

    /**
     * Constructs a bank account with a particular initial balance
     * @param customer a customer name in "First Last" format
     * @param balance a non-negative balance in USD
     */
    public BankAccount(String customer, double balance){
        this.customer = customer;
        this.balance = balance >= 0 ? balance : 0.0;
    }

    /**
     * Constructs a bank account with an initial balance of 0
     * @param customer a customer name in "First Last" format
     */
    public BankAccount(String customer){
        this(customer,0.0);
    }

    public double balance() {
        return this.balance;
    }


    public void deposit(double amount){
        this.balance += amount;
    }

    /**
     * withdraws an amount from the bankaccount
     * @param amount what we want to withdraw
     * @return how much of our balance we were able to withdraw
     */
    public double withdraw(double amount){
        if (this.balance >= amount){
            this.balance -= amount;
            return amount;
        } else {
            double amountWithdrawn = this.balance;
            this.balance = 0.0;
            return amountWithdrawn;
        }

    }

    public double transfer(BankAccount to, double amount){ //NOT FINISHED
        double amountWithdrawn = this.withdraw(amount);
        to.deposit(amount);
        return amountWithdrawn;
    }

}
