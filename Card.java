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
      String rID;       //for the rank imageID part
      
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
         rID = "2";
         break;
         
         case 3:
         rankString = "Three";
         rID = "3";
         break;
         
         case 4:
         rankString = "Four";
         rID = "4";
         break;
         
         case 5:
         rankString = "Five";
         rID = "5";
         break;
         
         case 6:
         rankString = "Six";
         rID = "6";
         break;
         
         case 7:
         rankString = "Seven";
         rID = "7";
         break;
         
         case 8:
         rankString = "Eight";
         rID = "8";
         break;
         
         case 9:
         rankString = "Nine";
         rID = "9";
         break;
         
         case 10:
         rankString = "Ten";
         rID = "10";
         break;
         
         case JACK:
         rankString = "Jack";
         rID = rankString.toLowerCase();;
         break;
         
         case QUEEN:
         rankString = "Queen";
         rID = rankString.toLowerCase();;
         break;
         
         case KING:
         rankString = "King";
         rID = rankString.toLowerCase();;
         break;
         
         case ACE:
         rankString = "Ace";
         rID = rankString.toLowerCase();
         break;
         
         default:
         rankString = "Ace";
         rID = rankString.toLowerCase();
         break;
      }
      
      //creates the string to associate it with an image
      imageID = "pictures\\" + rID + sID + ".jpg";
         
   }

   /**
   This getSuit method return the Suit to the user as an int
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
   This getImageID method returns the imageID to the user as an string
   @return imageID the imageID of the card
   */
   public String getImageID()
   {
      return imageID;
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