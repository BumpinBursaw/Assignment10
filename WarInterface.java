public interface WarInterface 
{
   /*Plan is to make 3 part GUI with the buttons
   in the middle and an emphasis on preventing the
   player from drawing and collecting cards when not allowed
   in addition to using stacks and queues
   */
   
   //two queues for holding the two players cards
   QueueReferenceBased Player1Deck = new QueueReferenceBased();
   QueueReferenceBased Player2Deck = new QueueReferenceBased();
       
   //two stacks for holding the two players cards on field
   StackReferenceBased Player1Field = new StackReferenceBased();
   StackReferenceBased Player2Field = new StackReferenceBased();
   
   public void buildImagePanelEast();
   
   public void buildImagePanelWest();
   
   public void buildButtonPanel();
  
}  // end WarInterface