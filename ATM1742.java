import java.time.LocalDate;
import java.util.Scanner;


    class Account{
        private int id;
        private double balance;
        private double annualInterestRate;
        private LocalDate dateCreated;
        
        //this is the default constructor 
        public Account(){
            id = 0;
            balance = 0;
            annualInterestRate = 0;
            dateCreated = LocalDate.now();
        }

        //this is the second constructor 
        public Account(int id, double balance, double annualInterestRate){
            this.id = id;
            this.balance = balance;
            this.annualInterestRate = annualInterestRate;
            dateCreated = LocalDate.now();
        }

        // set the id
        public void setId (int id){
            this.id = id;
        }

        // set the balance
        public void setBalance (double balance){
            this.balance = balance;
        }

        //set the interest rate
        public void setInterestRate(double annualInterestRate){
            this.annualInterestRate = annualInterestRate;
        }

        //get the id
        public int getId(){
            // System.out.println("The id for this account is " + id);
            return this.id;
        }

        // get the balance
        public double getBalance(){
            return this.balance;
        }

        //get the interest rate
        public double getInterestRate(){
            System.out.println("Your interest rate is " + annualInterestRate);
            return this.annualInterestRate;
        }

        //get the date is was created
        public LocalDate getDateCreated(){ 
            System.out.println("This is the date is was created " + dateCreated);
            return this.dateCreated;
        }

        //get the monthly rate
        public double getMonthlyInterestRate(){
            System.out.println("Your monthly interest is $" + (this.annualInterestRate / 100) / 12);
            return (this.annualInterestRate / 100) / 12;
        }

        // get the monthly interest amount
        public double getMonthlyInterest(){
            return this.getMonthlyInterestRate() * balance;
        }

        //withdraw money from the account 
        public void withdraw(double withdraw){
            if(withdraw > balance){
                System.out.println("You dont have enough money to withdraw this amount");
                return;
            }

            balance = balance - withdraw;            
            System.out.println("You have withdrew $" + withdraw);
            System.out.println("Your new balance is $" + balance);
        }

        //deposit money from the account
        public void deposit(double deposit){
            balance = balance + deposit;            
            System.out.println("You have desposited $" + deposit);
            System.out.println("Your new balance is $" + balance);
        }

        //this is the class that is being used to test out the bankaccount class 
        public void bankTest(){
            Account money = new Account(1122, 20000.00, 4.5);
            money.withdraw(2500.00);
            money.deposit(3000.00);

            money.getBalance();
            money.getMonthlyInterest();
            money.getDateCreated();
        }
    
    }

    
    //This is the atm class thats going to use the Account class
    public class ATM1742{
        static Scanner input = new Scanner(System.in);
        static Account[] accounts = new Account[10];
        static int id;
        
        //main class where all the logic is going to run
        public static void main(String[] args){

            int continousLoop = 1;
            accountCreation();

            //making a continous loop, making it never ending program.
            do{ 
                enterId();
                mainMenu(id);
            }while(continousLoop!= 100);
        }

        //this creates the 10 accounts and places them inside a array        
        public static void accountCreation(){
            for(int i = 0; i < accounts.length; i++){      
                // Account users = new Account(i, 100.0, 0.4);  
                accounts[i] = new Account (i ,100.0, 0.4);
            }
        }

        //prompts the user to enter hes/her id
        public static void enterId(){ 

            System.out.print("\nPlease Enter Your Id number: ");
            id = input.nextInt();
            do{
                for(int i = 0; i < 1; i++){
                    for(int j = 0; j < accounts.length; j++){
                        if(accounts[j].getId() == id){
                            return;
                        }
                    }
                    //if the id was entered wrong the user will try again or quit the process
                    System.out.print("\nYou have entered a wrong id, try again: ");
                    id = input.nextInt();

                }
            }while(accounts.length == accounts.length); //setting a condition thats always true

        }

        //this is the main menu for the ATM application 
        public static void mainMenu(int id){

            int choice;
            double subtractCash;
            double addCash;

            do{ 
                System.out.print("\nMain Menu" +
                "\n1: Check Balance" +
                "\n2: Widthdraw" +
                "\n3: Deposit" +
                "\n4: Exit" + 
                "\nEnter a choice: "
                );

                choice = input.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Your current balance is $" + accounts[id].getBalance());
                        break;
                    case 2: 
                        System.out.print("\nHow much do you want to withdraw: $");
                        subtractCash = input.nextDouble();
                        accounts[id].withdraw(subtractCash);
                        accounts[id].getBalance();
                        break;
                    case 3:
                        System.out.print("\nHow much do you want to deposit: $");
                        addCash = input.nextDouble();
                        accounts[id].deposit(addCash);
                        break;
                    case 4: 
                        break;
                    default:
                        System.out.println("Not a valid input, try again");
                        break;
                }
            }while(choice != 4);
        }
    }



    



