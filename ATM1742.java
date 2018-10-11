import java.time.LocalDate;

public class ATM1742{
    public static void main(String[] args){
      BankAccount();
    }

    public static class BankAccount(){
        private int id;
        private double balance;
        private double annualInterestRate;
        private LocalDate dateCreated;

        public BankAccount(){
            id = null;
            balance = 0;
            annualInterestRate = 0;
            dateCreated = LocalDate.now();
        }

        public BankAccount (int id, double balance, double annualInterestRate){
            this.id = id;
            this.balance = balance;
            this.annualInterestRate = annualInterestRate;
            dateCreated = LocalDate.now();
        }

        public static void setId (int id){
            this.id = id;
        }

        public static void setBalance (double balance){
            this.balance = balance;
        }
        public static void setInterestRate(double annualInterestRate){
            this.annualInterestRate = annualInterestRate;
        }

        public static int getId(){
            return this.id;
        }

        public static double getBalance(){
            return this.balance;
        }

        public static double getInterestRate(){
            return this.annualInterestRate;
        }

        public static LocalDate getDateCreated(){ 
            return this.dateCreated;
        }

        public static double getMonthlyInterestRate(){
            return (this.annualInterestRate / 100) / 12;
        }

        public static double getMonthlyInterest(){
            return this.getMonthlyInterestRate * balance;
        }

        public static void withdraw(double withdraw){
            if(withdraw > balance){
                System.out.println("You dont have enough money to withdraw this amount");
                withdraw(double withdraw);
            }
            balance = balance - withdraw;
        }

        public static void deposit(double deposit){
            balance = balance + deposit;
        }

        //this is the class that is being used to test out the bankaccount class 
        public static void main(String[] args){
            BankAccount(1122, 20000.00, 4.5);
            withdraw(2,500);
            deposit(3000.00);

            getBalance();
            getMonthlyInterest();
            getDateCreated();
        }
}