/*Allan Bursaw
 CS 110
 Assignment 10 - Card.class
 card class to create playing cards
*/

public class Card
{
   private int rank;                      //holds the rank as an integer 
   private int suit;                      //holds the suit as an integer
   
   //ranks for all the upper cards as finals
   public static final int ACE = 14;
   public static final int QUEEN = 13;
   public static final int KING = 12;
   public static final int JACK = 11;
   
   //values for the suits as finals
   public static final int SPADES = 1;
   public static final int HEARTS = 2;         
   public static final int DIAMONDS = 3;
   public static final int CLUBS = 4;  
   
   public String rankString;              //holds the rank as an string
   public String suitString;              //holds the rank as an string
   public String imageID;                 //the cards image ID
   
   
   
   /**
   This Card constructor accept the suit and rank as argument and
   sets the Card up with a rank string, suit string, and image ID
   as well as setting the rank and suit values
   @param s suit
   @param r rank
   */
   public Card(int rank, int suit)
   {
      this.rank = rank;
      this.suit = suit;
      
      String sID;       //for the suit imageID part
      
      switch(suit)
      {
         case SPADES:
         suitString = "Spades";
         sID = "s";
         
         break;
         
         case HEARTS:
         suitString = "Hearts";
         sID = "h";
         break;
         
         case DIAMONDS:
         suitString = "Diamonds";
         sID = "d";
         break;
         
         case CLUBS:
         suitString = "Clubs";
         sID = "c";
         break;
         
         default:
         suitString = "Spades";
         sID = "s";
         break;
      }
      
      switch(rank)
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
         rankString = "Five";
         break;
         
         case 6:
         rankString = "Six";
         break;
         
         case 7:
         rankString = "Seven";
         break;
         
         case 8:
         rankString = "Eight";
         break;
         
         case 9:
         rankString = "Nine";
         break;
         
         case 10:
         rankString = "Ten";
         break;
         
         case JACK:
         rankString = "Jack";
         break;
         
         case QUEEN:
         rankString = "Queen";
         break;
         
         case KING:
         rankString = "King";
         break;
         
         case ACE:
         rankString = "Ace";
         break;
         
         default:
         rankString = "Ace";
         break;
      }
      
      //creates the string to associate it with an image
      imageID = rankString.toLowerCase() + sID + ".jpg";
         
   }

   /**
   This getSuit mehtod return the Suit to the user as an int
   @return suit the suit of the card
   */
   public int getRank()
   {
      return rank;
   }
      
   /**
   This getRank method gives the user a rank based on an integer
   @return rank the rank of the card
   */
   public int getSuit()
   {
      return suit;
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