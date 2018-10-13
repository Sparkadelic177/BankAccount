import java.time.LocalDate;

class ATM1742{

    private class BankAccount{
        private int id;
        private double balance;
        private double annualInterestRate;
        private LocalDate dateCreated;
        
        public BankAccount(){
            id = 0;
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

        private void setId (int id){
            this.id = id;
        }

        private void setBalance (double balance){
            this.balance = balance;
        }
        private void setInterestRate(double annualInterestRate){
            this.annualInterestRate = annualInterestRate;
        }

        public int getId(){
            return this.id;
        }

        public double getBalance(){
            System.out.println("Your Current Balance is" + balance);
            return this.balance;
        }

        public double getInterestRate(){
            return this.annualInterestRate;
        }

        public LocalDate getDateCreated(){ 
            return this.dateCreated;
        }

        public double getMonthlyInterestRate(){
            System.out.println("Your monthly interest is " + (this.annualInterestRate / 100) / 12);
            return (this.annualInterestRate / 100) / 12;
        }

        public double getMonthlyInterest(){
            return this.getMonthlyInterestRate() * balance;
        }

        private void withdraw(double withdraw){
            if(withdraw > balance){
                System.out.println("You dont have enough money to withdraw this amount");
                return;
            }
            balance = balance - withdraw;            
            System.out.println("You have withdrew " + withdraw);
            System.out.println("Your new balance is " + balance);
        }

        private void deposit(double deposit){
            balance = balance + deposit;            
            System.out.println("You have desposited " + deposit);
            System.out.println("Your new balance is " + balance);
        }
    }

        //this is the class that is being used to test out the bankaccount class 
        public void bankTest(){
            BankAccount money = new BankAccount(1122, 20000.00, 4.5);
            money.withdraw(2500.00);
            money.deposit(3000.00);

            money.getBalance();
            money.getMonthlyInterest();
            money.getDateCreated();
        }
    

        public static void main(String[] args){
            ATM1742 money = new ATM1742();
            money.bankTest();
        }
    }


