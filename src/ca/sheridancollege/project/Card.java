/**
 * 
 * @modifier BlackJackPro group 2/4/20
 */
package ca.sheridancollege.project;

public abstract class Card 
{
      private Suit suit;
    private Value value;
   
    public Card(Suit s , Value v)   //constructor
    {
        this.suit = s;
        this.value = v;
    }
    
    //accessor and mutator methods
    public Suit getSuit()
    {
        return suit;
    }
    
    public Value getValue()
    {
        return value;
    }
    
    public void setSuit(Suit s)
    {
        this.suit = s;
    }
    
    public void setValue(Value v)
    {
        this.value = v;
    }
      
    /**
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public String toString(){
        return value.toString() + " of " + suit.toString();
    }
                                     
  
}
