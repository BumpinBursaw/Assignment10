/*Allan Bursaw
 CS 110
 Assignment 10 - Card.class
 card class to create playing cards
*/

public class Card
{
   private int rank;                      //holds the rank as an integer 
   private int suit;                      //holds the suit as an integer
   public static final int ACE = 14;
   public static final int QUEEN = 13;
   public static final int KING = 12;
   public static final int JACK = 11;
   
   public static final int SPADES = 1;
   public static final int HEARTS = 2;    
   public static final int CLUBS = 3;     
   public static final int DIAMONDS = 4;  
   
   public String rankString;              //holds the rank as an string
   public String suitString;              //holds the rank as an string
   
   
   
   /**
   This Card constructor accept the suit and rank as argument
   @param s suit
   @param r rank
   */
   public Card(int rank, int suit)
   {
      this.rank = rank;
      this.Suit = suit;
         
   }

   /**
   This getSuit mehtod return the Suit to the user as an int
   @return suit the suit of the card
   */
   public int getRank()
   {
      switch(suit)
      {
         case 2:
         rankString = "Two";
         break;
         
         case 3:
         rankString = "Three";
         break;
         
         case 4:
         rankString = "Four";
         break;
         
         case 5:
         rankString = "Five"
         break;
         
         case 6:
         rankString = "Six"
         break;
         
         case 7:
         rankString = "Seven"
         break;
         
         case 8:
         rankString = "Eight"
         break;
         
         case 9:
         rankString = "Nine"
         break;
         
         case 10:
         rankString = "Ten"
         break;
         
         case JACK:
         rankString = "Jack"
         break;
         
         case QUEEN:
         rankString = "Queen"
         break;
         
         case KING:
         rankString = "King"
         break;
         
         case ACE:
         rankString = "Ace"
         break;
      }
      return rankString;
   }
      
   /**
   This getRank method gives the user a rank based on an integer
   @return rank the rank of the card
   */
   public int getRank()
   {
      switch(suit)
      {
         case SPADES:
         suitString = "Spades"
         break;
         
         case HEARTS:
         suitString = "Hearts"
         break;
         
         case CLUBS:
         suitString = "Clubs"
         break;
         
         case DIAMONDS:
         suitString = "Diamonds"
         break;
      }
      return suitString;
   }
   
   /**
   This toString method return a string to print out
   */
   public String toString()
   {
      return "\nThis card is a " + rankString + " of " + suitString;
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