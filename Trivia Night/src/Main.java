import Operations.CardType;
import Operations.Dealer;
import Operations.UI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UI counsel = new UI();

        CardType selection = counsel.modeSelect();  //starts the main menu

        if(selection==CardType.FLASHCARD)
        {
            Dealer tf = new Dealer();
            int count = tf.getFlashcardsDeck().count();
        }
        if(selection==CardType.QUESTION)
        {
            Dealer tf = new Dealer();
            tf.makeQuestionsDeck();
            int count = tf.getQuestionsDeck().count();
            counsel.getSecretary().setTotalQuestions(count);
            for(int i = 0; i < count; i++)
            {
                counsel.displayScore(i);
                counsel.getQuestion(tf.dealQuestionCard());

            }
            counsel.finalVerdict();

        }



    }


}