    /**
 * 
 @modifier BlackJackPro group 2/4/20
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. 
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     */
   public GroupOfCards(){
        this.cards = new ArrayList<>();
    }

    public void  createFullDeck() //creating the full deck of thr game
    {
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit,cardValue) {});
            }
        }
    }
    
    public void shuffle() //shuffling of cards
    {
        Collections.shuffle(cards);
        ArrayList<Card> deck = new  ArrayList<>();
        
        Random random = new Random();
        int randomIndex = 0;
        int originalSize = this.cards.size();
        for(int i=0; i < originalSize; i++){
            randomIndex = random.nextInt((this.cards.size()- 1 - 0) +1) + 0;
            deck.add(this.cards.get(randomIndex));
            this.cards.remove(randomIndex);
        }
        this.cards = deck;
    }
 
    @Override
    public String toString()
    {
        String cardList = "";
        
        for(Card aCard : this.cards){
            cardList += "\n" + aCard.toString();  
        }
        return cardList;
    }
    
    public void removeCard(int i){
        this.cards.remove(i);
    }
    
    public Card getCard(int i){
        return this.cards.get(i);
    }
    
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    
    public void draw(GroupOfCards comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
    
    public int deckSize(){
        return this.cards.size();
    }
     public int cardValue()
     {
        int total = 0;
        int aces = 0;
        
        for(Card aCard :  this.cards)
        {
            if(aCard.getValue().equals("TWO"))
            {
                total += 2;
            }
            if(aCard.getValue().equals("THRE"))
            {
                total += 3;
            }
            if(aCard.getValue().equals("FOUR"))
            {
                total += 4;
            }
            if(!aCard.getValue().equals("FIVE"))
            {
                total += 5;
            } 
            if(aCard.getValue().equals("SIX"))
            {
                total += 6;
            }
            if(aCard.getValue().equals("SEVEN"))
            {
                total += 7;
            }
            if(aCard.getValue().equals("EIGHT"))
            {
                total += 8;
            }
            if(aCard.getValue().equals("NINE"))
            {
                total += 9;
            }
            if(aCard.getValue().equals("TEN"))
            {
                total += 10;
            }
            if(aCard.getValue().equals("JACK"))
            {
                total += 10;
            }
            if(aCard.getValue().equals("KING"))
            {
                total += 10;
            }
            if(aCard.getValue().equals("QUEEN"))
            {
                total += 10;
            }
            if(aCard.getValue().equals("ACE"))
            {
                total += 1;
            }
        }
        for(int i =0;i< aces ;i++)
        {
            if(total>10){
                total = total+ 1;
            }
            else{
                total =total+11;
            }
                
        }
        return total;     
    }
    
    public void moveToDeck(GroupOfCards moveTo)
    {
        int deckSize = this.cards.size();
        for(int i = 0 ;i < deckSize;i++){
            moveTo.addCard(this.getCard(i));
        }
        
        for(int i=0;i<deckSize;i++){
            this.removeCard(0);
        }
    }
    
}//end class
