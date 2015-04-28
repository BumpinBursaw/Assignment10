/*Allan Bursaw
 CS 110
 Assignment 10 - Card.class
 card class to create playing cards
*/

public class Card
{
   private CardRank Rank;     //used to hold enum card rank
   private CardSuit Suit;     //used to hold enum card rank
   private int rank;          //holds the rank as an integer 
   private int suit;          //holds the suit as an integer
   
   /**
   This Card constructor accept the suit and rank as argument
   @param s suit
   @param r rank
   */
   public Card(CardRank Rank, CardSuit Suit)
   {
      this.Rank = Rank;
      this.Suit = Suit;
         
   }

   /**
   This getSuit mehtod return the Suit to the user as an int
   @return suit the suit of the card
   */
   public int getSuit()
   {
      switch (Suit)
      {
         case SPADES:
            suit = 1;
            break;
         case CLUBS:
            suit = 2;
            break;
         case HEARTS:
            suit = 3;
            break;
         case DIAMONDS:
            suit = 4;
            break;
      }
      return suit;
   }
      
   /**
   This getRank method gives the user a rank based on an integer
   @return rank the rank of the card
   */
   public int getRank()
   {
      switch (Rank)
      {
         case TWO:
            rank = 1;
            break;
         case THREE:
            rank  = 2;
            break;
         case FOUR:
            rank = 3;
            break;
         case FIVE:
            rank = 4;
            break;
         case SIX:  
            rank = 5;
            break;
         case SEVEN:
            rank = 6;
            break;
         case EIGHT:
            rank = 7;
            break;
         case NINE:
            rank = 8;
            break;
         case TEN:
            rank = 9;
            break;
         case JACK:
            rank = 10;
            break;
         case QUEEN:
            rank = 11;
            break;
         case KING:
            rank = 12;
            break;
         case ACE:
            rank = 13;
            break;
         default:
            rank = 1;
            break;
      }
      return rank;
   }
   
   /**
   This toString method return a string to print out
   */
   public String toString(){
      return "\nThis card is a " + Rank + " of " + Suit;
   }
   
   /**
   This equals method takes another card and compares it to the card object
   @param otherCard a Card object
   */
   public boolean equals(Card otherCard)
   {
      boolean equality;
      if (this.rank == otherCard.getRank()){
         equality = true;
         return equality;
      } else {
         equality = false;
         return equality;
      }
   }
}