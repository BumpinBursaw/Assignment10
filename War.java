/*	Allan	Bursaw
 CS 110
 Assignment	10 - War Program
 This	program simulates the kids card game war
*/

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class War extends JFrame implements WarInterface
{
   
   private JPanel buttonPanel;         //panel for buttons
   private JPanel imagePanelEast;      //panel for Player 1
   private JPanel imagePanelWest;      //panel for Player 2
   
   private JButton drawCard;           //draw card button
   private JButton collectCard;        //take card button
   private JLabel imageLabelEast;      //holds Player 1's Card
   private JLabel imageLabelWest;      //holds Player 2's Card
   
   Card Player1 = new Card(1,1);       //card for holding Player 1's cards
   Card Player2 = new Card(1,1);       //card for holding Player 2's cards
   
   //game monitoring vairables
   int cardsOnField = 0;               //counts how many times cards have been drawn
   String winner = "None";             //holds the winner of a round
   boolean canDraw = true;             //tells if the user may draw
   boolean roundOver = false;          //tells if the round is over
   boolean tie = false;                        //if there is a tie starts the war
   
   //place holder on the playing field icon
   ImageIcon nullCard = new ImageIcon("face.jpg");                      
   
   //two queues for holding the two players cards
   QueueReferenceBased Player1Deck = new QueueReferenceBased();
   QueueReferenceBased Player2Deck = new QueueReferenceBased();
       
   //two stacks for holding the two players cards on field
   StackReferenceBased Player1Field = new StackReferenceBased();
   StackReferenceBased Player2Field = new StackReferenceBased();
   
   public War()
   {
      //set window title
      setTitle("War Game!");
      
      //set the window size
      setLayout(new BorderLayout());
      
      //for closing the program
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //builds the pannels
      buildImagePanelEast();
      buildImagePanelWest();
      buildButtonPanel();
      
      //sets up the layout
      add(imagePanelEast, BorderLayout.EAST);
      add(imagePanelWest, BorderLayout.WEST);
      add(buttonPanel, BorderLayout.CENTER);
      
      //sets up the emty field icons
      imageLabelEast.setIcon(nullCard);
      imageLabelWest.setIcon(nullCard);
      
      //packs and displays the game
      pack();
      setVisible(true);
      
   }
   //player 1 right side panel setup
   public void buildImagePanelEast()
   {
      imagePanelEast = new JPanel();
      
      imageLabelEast = new JLabel("Player 1");
      
      imagePanelEast.add(imageLabelEast);
   }
   
   //player 2 left side panel setup
   public void buildImagePanelWest()
   {
      imagePanelWest = new JPanel();
      
      imageLabelWest = new JLabel("Player 2");
      
      imagePanelWest.add(imageLabelWest);
   }
   
   public void buildButtonPanel()
   {
   
      //sets up a deck and shuffles the cards in it
      Deck warDeck = new Deck();
      warDeck.shuffle();
       
         
      //deals players the shuffled cards
      for(int l = 0;l <26;l++)
      {
         Player1Deck.enqueue(warDeck.dealCard());
         Player2Deck.enqueue(warDeck.dealCard());
      }
      
      //draw card button
      drawCard = new JButton("Draw Card");
      drawCard.addActionListener(new DrawCardButtonListener());
      
      //collect card button
      collectCard = new JButton("Collect Card");
      collectCard.addActionListener(new CollectCardButtonListener());
      
      //puts together the button panel
      buttonPanel = new JPanel();
      buttonPanel.add(drawCard);
      buttonPanel.add(collectCard);
   }
   
   //draw card button action
   private class DrawCardButtonListener implements ActionListener
   {
   
      public void actionPerformed(ActionEvent e)
      {
         //prevents drawing when cards still need to be collected
         if (canDraw == false)
         {
            JOptionPane.showMessageDialog(null, "Please collect cards!");
         }
         
         else if(tie == true)
         {
            //takes cards from the players decks and puts them on field(stack)
            Player1Field.push(Player1Deck.dequeue());
            Player2Field.push(Player2Deck.dequeue());
            cardsOnField++;
            
            //pops values to be compared in game
            Player1 = Player1Field.pop();
            Player2 = Player2Field.pop();
            
            //creates icons to display the cards
            ImageIcon Card1 = new ImageIcon(Player1.getImageID());
            ImageIcon Card2 = new ImageIcon(Player2.getImageID());
            
            //puts the image of the cards up
            imageLabelEast.setIcon(Card1);
            imageLabelWest.setIcon(Card2);
            
            //puts the cards back on the stack to be given to winner
            Player1Field.push(Player1);
            Player2Field.push(Player2);
            
            tie = false;
            
         }
         
         else
         {
            //takes cards from the players decks and puts them on field(stack)
            Player1Field.push(Player1Deck.dequeue());
            Player2Field.push(Player2Deck.dequeue());
            cardsOnField++;
            
            //pops values to be compared in game
            Player1 = Player1Field.pop();
            Player2 = Player2Field.pop();
            
            //creates icons to display the cards
            ImageIcon Card1 = new ImageIcon(Player1.getImageID());
            ImageIcon Card2 = new ImageIcon(Player2.getImageID());
            
            //puts the image of the cards up
            imageLabelEast.setIcon(Card1);
            imageLabelWest.setIcon(Card2);
            
            //puts the cards back on the stack to be given to winner
            Player1Field.push(Player1);
            Player2Field.push(Player2);
            
            if(Player1.getRank() > Player2.getRank())
            {
               winner = "Player 1";
               canDraw = false;
               roundOver = true;
            }
            
            else if(Player1.getRank() < Player2.getRank())
            {
               winner = "Player 2";
               canDraw = false;
               roundOver = true;
            }
            
            else
            {
               JOptionPane.showMessageDialog(null, "We have a tie!");
               tie = true;   
            }  
         }         
         
      }
      
   }
   
   //collect card button action
   private class CollectCardButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent f)
      {  
         //prevents collecting cards when there is no winner
         if(roundOver == false)
         {
            JOptionPane.showMessageDialog(null, "There is currently no winner");
         }      
         
         else
         {
            switch(winner)
            {
               case "Player 1":
               for(int p = 0; p < cardsOnField; p++)
               {
                  //gives cards to winner and sets up next round
                  Player1Deck.enqueue(Player1Field.pop());
                  Player1Deck.enqueue(Player2Field.pop());
                  canDraw = true;
                  cardsOnField = 0;
                  String winner = "None";
                  imageLabelEast.setIcon(nullCard);
                  imageLabelWest.setIcon(nullCard);
                  roundOver = false;
               }
               break;
               
               case "Player 2":
               for(int q = 0; q < cardsOnField; q++)
               {  
                  //gives cards to winner and sets up next round
                  Player2Deck.enqueue(Player1Field.pop());
                  Player2Deck.enqueue(Player2Field.pop());
                  canDraw = true;
                  cardsOnField = 0;
                  String winner = "None";
                  imageLabelEast.setIcon(nullCard);
                  imageLabelWest.setIcon(nullCard);
                  roundOver = false;
               }
               break;
                           
               default:
               JOptionPane.showMessageDialog(null, "There is currently no winner");
               break;
            }
            //winning detectors
            if(Player1Deck.isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Player 2 is the winner");
               System.exit(0);
            }
            
            else if(Player2Deck.isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Player 1 is the winner");
               System.exit(0);
            }
         }
                   
      }
   }
   //main method
   public static void main(String [] args) 
   {  
      new War();
   }
}