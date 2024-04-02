package Operations;

import Flashcards.Card;
import Flashcards.Flashcard;
import Questions.Question;
import Questions.Quiz;
import Questions.TrueFalse;
import Questions.TypeIn;

public class Internal
{

    private int points = 0;

    public int getPoints()
    {
        return points;
    }

    private int totalQuestions = 0;
    public int getTotalQuestions()
    {
        return totalQuestions;
    }

    /*

    private int questionsAsked = 0;

    public int getQuestionsAsked()
    {
        return questionsAsked;
    }
    */

    public int checkInput(String input)
    {
        try
        {
            return Integer.parseInt(input);
        } catch (NumberFormatException e)
        {
            return 0;
        }

    }

    public CardType checkCard(Card card){
        if(card instanceof Question)
            return checkQuestion((Question)card);
        if(card instanceof Flashcard)
            return CardType.FLASHCARD;

        return null;
    }

    public void addPoint()
    {
        this.points++;
    }

    public void setTotalQuestions(int questions)
    {
        this.totalQuestions = questions;
    }

    private CardType checkQuestion(Question question){
        if(question instanceof Quiz)
            return CardType.QUIZ;

        if(question instanceof TrueFalse)
            return CardType.TRUE_OR_FALSE;

        if(question instanceof TypeIn)
            return CardType.TYPE_IN;

        return null;
    }


}
