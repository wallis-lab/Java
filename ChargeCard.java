//Wenlong Wang
public abstract class ChargeCard 
{
    protected String name;
    protected String cardNumber;
    protected double balance;
    //constructors
     ChargeCard()
     {
      name = "";
      cardNumber = "";
      balance = 0;
     }
   
    ChargeCard(String name, String cardNumber) 
    {
        this.name = name;
        this.cardNumber = cardNumber;
        this.balance = 0;
    }
//Assessor methods
    public String getName() 
    {
        return name;
    }

    public String getCardNumber() 
    {
        return cardNumber;
    }

    public double getBalance() 
    {
        return balance;
    }




//Mutator methods
//Charge card is not operation in itself, only the interface function 
    public abstract void purchase(double pay);

    public abstract void increaseOverdraftLimit();

    public abstract void depositFunds(double deposit);

    public abstract void withdrawFunds(double fund);

    public abstract void payFees();
   

    public String toString() 
    {
        return "Name of card: " + name + " , card number: " + cardNumber+ " , balance: " + balance + "$";
    }

}

public class CreditCard extends ChargeCard
{
    private double overdraftLimit;
    private double feesIncurred;
    private double spendingLimit;
   //Constructor 
    CreditCard()
    {
     overdraftLimit = 0;
      feesIncurred = 0;
      spendingLimit = 0;
     }
    
    CreditCard(String name, String cardNumber) 
    {
        super(name, cardNumber);
        this.balance = 1000;
        spendingLimit = 8000;
    }
//Assessor Methods
 
  public double getoverdraftLimit()
  {
   return overdraftLimit;
   }
 
  public double getfeesIncurred()
  {
   return feesIncurred;
   }
 public double getspendingLimit()
 {
  return spendingLimit; 
  }
  //Mutator methods
  public void setoverdraftLimit( double ol)
  {
   overdraftLimit = ol;
   }
   
   public void setfeesIncurred(double fi)
   {
    feesIncurred = fi;
    }
 
  public void setspendingLimit(double sl)
  {
   spendingLimit = sl;
   } 
   
    public void purchase(double pay) //use credit card purchase should increase balance
    {
        balance += pay;
    }

    public void increaseOverdraftLimit() 
    {
        overdraftLimit += 100;
    }

    public void depositFunds(double deposit) //Credit card repayment will reduce the balance
    {
        balance -= deposit;
    }

    public void withdrawFunds(double fund) //Credit card could withdraw, increase balance, like use money for purchase
    {
        balance += fund;
    }

    public void payFees()//this Fee may after used credit card for withdraw or other 
    {
        feesIncurred = 0;
    }

    public String toString() 
    {
        return super.toString() + " , spending limit is "+ spendingLimit +", overdraftLimit: " + overdraftLimit + "$" + " , feesIncurred: " + feesIncurred + "$";
    }
    
    public boolean equals(CreditCard project)
    {
     if (super.equals(project) && project.overdraftLimit == overdraftLimit && project.feesIncurred == feesIncurred && project. spendingLimit == spendingLimit)
         return true;
         else
             return false;
    
     }
    
    }
    
  public class DebitCard extends ChargeCard 
    {
     private double overdraftLimit;
     private double overdraftFee;
     private double feesIncurred;
   //Constructor    
    DebitCard()
    {
     overdraftLimit = 0;   
     overdraftFee = 0;
     feesIncurred = 0;  
    }
   
   
    DebitCard(String name, String cardNumber) 
    {
        super(name, cardNumber);
        this.overdraftFee = 50;
        this.overdraftLimit = 100;
    }
//Assessor
    public double getFeesIncurred() 
    {
        return feesIncurred;
    }

    public double getOverdraftFee() 
    {
        return overdraftFee;
    }

    public double getOverdraftLimit() 
    {
        return overdraftLimit;
    }
//Mutator methods
    public void purchase(double pay) 
    {
        if (pay <= balance)
            balance -= pay;
        else if (pay > balance) {
            if (pay <= (balance + overdraftLimit + overdraftFee))
                balance -= pay + overdraftFee;
        }
    }

    public void increaseOverdraftLimit() 
    {
        overdraftLimit += 100;

    }

    public void depositFunds(double deposit) 
    {
        balance += deposit;

    }

    public void withdrawFunds(double fund) 
    {
        balance -= fund;

    }

    public void payFees() 
    {
        feesIncurred = 0;
    }

    public String toString() 
    {
        return super.toString() + " overdraftLimit: " + overdraftLimit + "$" + " overdraftFee: " + overdraftFee + "$"
                + " feesIncurred: " + feesIncurred + "$";
    }
   
    public boolean equals(DebitCard  project)
    {
     if (super.equals(project) && project.overdraftLimit == overdraftLimit && project.overdraftFee == overdraftFee &&  project.feesIncurred == feesIncurred)
         return true;
         else 
             return false;
    
     }
}
