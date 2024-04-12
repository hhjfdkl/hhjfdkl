package Questions;

import Flashcards.Card;
import Operations.CardType;
import org.jetbrains.annotations.NotNull;




public abstract class Question extends Card
{
    private final String correctAnswer;
    private final String prompt;
    public String getCorrectAnswer()
    {
        return correctAnswer;
    }
    public String getPrompt(){
        return prompt;
    }


    public Question(String correctAnswer, String prompt)
    {
        this.correctAnswer = correctAnswer.toLowerCase();
        this.prompt = prompt;
    }

    @Override
    public CardType getCardType()
    {
        return CardType.QUESTION;
    }

    //when user selects an answer, the object's getter will be used to pass the answer into this method.
    //the boolean is passed to the Operations.UI which will display if correct or not.
    public boolean check(@NotNull String answer)
    {
        return this.correctAnswer.equals(answer.toLowerCase());
    }
}
