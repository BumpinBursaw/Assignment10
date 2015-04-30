import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class War extends JFrame
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
   
   private void buildImagePanelEast()
   {
      imagePanelEast = new JPanel();
      
      imageLabelEast = new JLabel("Player 1");
      
      imagePanelEast.add(imageLabelEast);
   }
   
   private void buildImagePanelWest()
   {
      imagePanelWest = new JPanel();
      
      imageLabelWest = new JLabel("Player 2");
      
      imagePanelWest.add(imageLabelWest);
   }
   
   private void buildButtonPanel()
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
      
      drawCard = new JButton("Draw Card");
      drawCard.addActionListener(new DrawCardButtonListener());
      
      collectCard = new JButton("Collect Card");
      collectCard.addActionListener(new CollectCardButtonListener());
      
      buttonPanel = new JPanel();
      buttonPanel.add(drawCard);
      buttonPanel.add(collectCard);
   }
   
   private class DrawCardButtonListener implements ActionListener
   {
   
      public void actionPerformed(ActionEvent e)
      {
         
         if (canDraw == false)
         {
            JOptionPane.showMessageDialog(null, "Please collect cards!");
         }
         
         else
         {
            Player1Field.push(Player1Deck.dequeue());
            Player2Field.push(Player2Deck.dequeue());
            cardsOnField++;
            
            Player1 = Player1Field.pop();
            Player2 = Player2Field.pop();
            
            ImageIcon Card1 = new ImageIcon(Player1.getImageID());
            ImageIcon Card2 = new ImageIcon(Player2.getImageID());
            
            imageLabelEast.setIcon(Card1);
            imageLabelWest.setIcon(Card2);
            
            Player1Field.push(Player1);
            Player2Field.push(Player2);
            
            if(Player1.getRank() > Player2.getRank())
            {
               winner = "Player 1";
               canDraw = false;
               roundOver = true;
               System.out.println(Player1);
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
               Player1Field.push(Player1Deck.dequeue());
               Player2Field.push(Player2Deck.dequeue());
               cardsOnField++;
            
               Player1 = Player1Field.pop();
               Player2 = Player2Field.pop();
                              
               imageLabelEast.setIcon(Card1);
               imageLabelWest.setIcon(Card2);
               
               Player1Field.push(Player1);
               Player2Field.push(Player2);
                 
            }  
         }         
         
      }
      
   }
   
   private class CollectCardButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent f)
      {  
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
            
            if(Player1Deck.isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Player 2 is the winner");
               System.exit(1);
            }
            
            else if(Player2Deck.isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Player 1 is the winner");
               System.exit(1);
            }
         }
                   
      }
   }
   public static void main(String [] args) 
   {  
      new War();
   }
}