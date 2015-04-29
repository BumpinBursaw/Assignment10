import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class War extends JFrame
{
   
   private JPanel panel;                    //pannel
   private JButton drawCard;                 //draw card button
   private JButton collectCard;              //take card button
   private final int WINDOW_WIDTH   = 400;   //window width
   private final int WINDOW_HEIGHT  = 300;   //window height
   
   Card Player1 = new Card(1,1);
   Card Player2 = new Card(1,1);
   
   //two queues for holding the two players cards
   QueueReferenceBased Player1Deck = new QueueReferenceBased();
   QueueReferenceBased Player2Deck = new QueueReferenceBased();
       
   //two queues for holding the two players cards
   StackReferenceBased Player1Field = new StackReferenceBased();
   StackReferenceBased Player2Field = new StackReferenceBased();
   
   int cardsOnField = 0;
   String winner = "None";
   boolean canDraw = true;
   
   public War()
   {
      //set window title
      setTitle("War Game!");
      
      //set the window size
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //for closing the program
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      buildPanel();
      add(panel);
      setVisible(true);
   }
   
   private void buildPanel()
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
      
      panel = new JPanel();
      panel.add(drawCard);
      panel.add(collectCard);
   }
   
   private class DrawCardButtonListener implements ActionListener
   {
   
      public void actionPerformed(ActionEvent e)
      {  
         
         Player1Field.push(Player1Deck.dequeue());
         Player2Field.push(Player2Deck.dequeue());
         cardsOnField++;
         
         Player1 = Player1Field.pop();
         Player2 = Player2Field.pop();
         
         Player1Field.push(Player1);
         Player2Field.push(Player2);
         
         cardsOnField++;
         
         if (canDraw == false)
         {
            JOptionPane.showMessageDialog(null, "Please collect cards!");
         }
         
         else if(Player1.getRank() > Player2.getRank())
         {
            winner = "Player 1";
            canDraw = false;
         }
         
         else if(Player1.getRank() < Player2.getRank())
         {
            winner = "Player 2";
            canDraw = false;
         }
         
         else
         {
            JOptionPane.showMessageDialog(null, "We have a tie!");
            Player1Field.push(Player1);
            Player2Field.push(Player2);
            cardsOnField++;
            
            
            
         }         
         
      }
      
   }
   
   private class CollectCardButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent f)
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
            }
            break;
            
            case "None":
            JOptionPane.showMessageDialog(null, "There is currently no winner");
            break;
            
            default:
            JOptionPane.showMessageDialog(null, "There is currently no winner");
            break;
         }
                   
      }
   }
   public static void main(String [] args) 
   {
      new War();
   }
}