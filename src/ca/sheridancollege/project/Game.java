/**
 * 
 * @modifier BlackJackPro group 2/4/20
 * */
 
package ca.sheridancollege.project;

import java.util.Scanner;

public abstract class Game 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to BlackJack Game");
        System.out.println("Group Name:BlackjackPro");
        
        GroupOfCards playingDeck = new GroupOfCards();//creating a deck and shuffling the cards
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        
        //creating player and dealer decks
        GroupOfCards playerDeck = new  GroupOfCards();
        GroupOfCards dealerDeck = new  GroupOfCards();
        String winner = "";
        
        double initalmoney = 100.0; //initial money the user have for betting
        
        while(initalmoney > 0)    //the game runs until there is enough money with user
        {
            System.out.println("\nYour current balance: $" + initalmoney + "\nHow much would you like to bet?");
            double bet = sc.nextDouble();
           
            if(bet > initalmoney) //when user goes out of money
            {
                System.out.println("You can not bet more than your intial money $" + bet);
                continue;
            }
            boolean end = false;
            
            //the player is getting two cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            
            //the dealer is getting two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            
            // Runing the game
            while(true)
            {
                System.out.println("\nYour cards:\n "+playerDeck.toString());
                System.out.println("Total of your cards\n: "+playerDeck.cardValue());
                System.out.println("Dealer's card:\n "+dealerDeck.getCard(0).toString()+" and the other card Faced Down");
                
                System.out.println("\n What you would like to do Hit or Stand?");
                System.out.println("Enter 0 for Hit and 1 for Stand");
                String response = sc.next();
                
                if(checkValue(response) == true)
                {
                    if(response.equals("0"))  // if user hits
                    {
                         playerDeck.draw(playingDeck);
                        System.out.println("\nYou got a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                        
                        if(playerDeck.cardValue() > 21)
                        {
                            System.out.println("\nBust. Sum of your cards: " + playerDeck.cardValue());
                            winner = "Dealer is the  winner.";
                            initalmoney = initalmoney - bet;
                            end = true;
                            break;
                        }
                    }
                    if(response.equals("1"))  // if user stands
                    {
                        break;
                    }
                }
                else
                    System.out.println("Please enter only 0 or 1");
            }
            
            System.out.println("Dealer's Cards: " + dealerDeck.toString());
          
            while((dealerDeck.cardValue() < 17) && end == false) //dealer's draws
            {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }
        
            if((dealerDeck.cardValue() > playerDeck.cardValue()) && end == false) // here dealer wins
            {
                System.out.println("Dealer Wins");
                winner = "Dealer is the winner.";
                initalmoney = initalmoney - bet;
                end = true;
            }
           
            System.out.println("Sum of dealer's cards : " +dealerDeck.cardValue()); // here user wins because dealer busts
            if((dealerDeck.cardValue() > 21) && end == false){
                System.out.println("Dealer Bust, You Win!!");
                winner = "You are winner.";
                initalmoney = initalmoney + bet;
                end = true;
            }
          
            if((playerDeck.cardValue()) == (dealerDeck.cardValue()) && end == false) //if there is a tie
            {
                System.out.println("It is a tie");
                winner = "None of you wins";
                end = true;
            }
            
            if((playerDeck.cardValue()) > dealerDeck.cardValue() && end == false) //user wins as the sum of cards is greater
            {
                System.out.println("You Win");
                winner = "You are winner";
                initalmoney = initalmoney + bet;
                end = true;
            }
            
            else if(end == false){
                initalmoney = initalmoney - bet;
                end = true;
            }
            
            //puting the cards back to the deck
            playerDeck.moveToDeck(playingDeck); 
            dealerDeck.moveToDeck(playingDeck);
            System.out.println("Round ended");
            System.out.println(winner);
        }
        System.out.println("You are out of money");
        System.out.println("Thank you for playing!");
    }
    public static boolean checkValue(String result)
    {
        if(result.equals("0") || (result.equals("1")))
        {
            return true;
        }
        return false;
    }
}