import java.util.ArrayList;
import java.util.Scanner;

public class Wallet 
    {
    //use private ,only wallet class can use
    private double totalCash;
    private ArrayList<ChargeCard> cards = new ArrayList<>();
    private ArrayList<String> idCards = new ArrayList<>();
   //Construtor
   Wallet()
   {
    totalCash = 0;
    }
    public Wallet(double totalCash) 
    {
        this.totalCash = totalCash;
    }
//Accessors methods
 public double gettotalCash()
 {
  return totalCash;
   }
//Mutator methods 
 public void settotalCash(double tc)
 {
  totalCash = tc;
  }
 
    public void addCash(double cash) 
    {
        totalCash += cash;
    }

    public void purchase(double pay) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Cash");
        System.out.println("2 Charge card");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        if(choice == 1) 
        {
            totalCash -= pay;
          }
           else 
           {
            System.out.println("1 Debit card");
            System.out.println("2 Credit card");
            System.out.print("Choice: ");
            int choiceCard = sc.nextInt();
            if(choiceCard == 1)
              {
                for (int i = 0 ; i < cards.size(); i++) 
                    {
                     if(cards.get(i).getClass().getSimpleName() == "DebitCard") 
                     {
                        System.out.println(i + cards.get(i).toString());
                      }
                     }
                      System.out.print("Enter number card in list:");
                      int number = sc.nextInt();
                      cards.get(number).purchase(pay);
              }
               else
                   {
                    for (int i = 0 ; i < cards.size(); i++) 
                    {
                      if(cards.get(i).getClass().getSimpleName() == "CreditCard") {
                      System.out.println(i + cards.get(i).toString());
                     }
                }
                System.out.print("Enter number card in list:");
                int number = sc.nextInt();
                cards.get(number).purchase(pay);
            }

        }
    }

    public double totalCashOnHand() 
    {
        double total = 0;
        for (int i = 0; i < cards.size(); i++) 
        {
            total += cards.get(i).getBalance();
        }

        return total;
     }

    public double totalCanSpend() 
    {
        double total = 0;
        for (int i = 0; i < cards.size(); i++) {
            total += cards.get(i).getBalance();
        }
        return total;
    }

    public int allCardsID() 
    {
        return idCards.size();
     }

    public int allCards() 
    {
        return cards.size();
    }

    public void addDebitCard() 
    {
        Scanner sc = new Scanner(System.in);
        String name;
        String cardNumber;
        System.out.print("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter card number");
        cardNumber = sc.nextLine();
        cards.add(new DebitCard(name, cardNumber));
    }

    public void addCreditCard() 
    {
        Scanner sc = new Scanner(System.in);
        String name;
        String cardNumber;
        System.out.print("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter card number");
        cardNumber = sc.nextLine();
        cards.add(new CreditCard(name, cardNumber));
    }

    public void addCardID(String cardNumber) 
    {
        idCards.add(cardNumber);
    }

    public String toString() 
    {
        String allInfo = "Cash:" + totalCash + "$\n";
        if(cards.size() >= 1) {
            for (int i = 0; i < cards.size(); i++) 
            {
                allInfo += cards.get(i).toString();
                allInfo += "\n";
            }
        }
        return allInfo;
    }
}
