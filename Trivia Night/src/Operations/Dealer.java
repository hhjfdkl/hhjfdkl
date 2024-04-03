package Operations;

import Flashcards.Card;
import Flashcards.Deck;
import Flashcards.Flashcard;
import Flashcards.HasDice;
import Questions.Question;
import Questions.Quiz;
import Questions.TrueFalse;
import Questions.TypeIn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dealer implements HasDice
{

    private final Map<DeckType,Deck> decks = new HashMap<>();      //map used to hold multiple decks, key is the enum of the deck
    private final FileReader printer = new FileReader();
    private final int SIX_SIDED_DIE = 6;    //constant used for the overridden dealer roll method

    public Deck getQuestionsDeck()
    {
        return decks.get(DeckType.QUESTION);
    }
    public Deck getFlashcardsDeck()
    {
        return decks.get(DeckType.FLASHCARD);
    }

    public Question dealQuestionCard()
    {
        try {
            return (Question)decks.get(DeckType.QUESTION).draw();
        } catch (NullPointerException e)
        {
            return null;
        }
    }
    public Flashcard dealFlashcard()
    {
        try{
            return (Flashcard)decks.get(DeckType.FLASHCARD).draw();
        } catch (NullPointerException e)
        {
            return null;
        }
    }
    public Dealer()
    {
        decks.put(DeckType.FLASHCARD,new Deck(printer.generateCards()));    //makes a new flashcard deck upon initialization

    }

    public void makeFlashcardDeck()     //this might actually not do anything. We'll see if we keep it.
    {                                   //at most, it just resets our deck after we're finished.
        decks.put(DeckType.FLASHCARD, new Deck(printer.generateCards()));
    }

    public void makeQuestionsDeck()
    {
        Deck fcDeck = decks.get(DeckType.FLASHCARD);        //pulling out the right deck to get data from (our flashcards)
        Deck qDeck = new Deck();                            //making a new deck
        while(fcDeck.count()>4)                            //flashcards should have at least 4 for quizzes
        {       //risk here - what if we somehow have a card that isn't a flashcard?
            Flashcard answerCard = (Flashcard)fcDeck.draw();      //draws a card, makes it a flashcard, from our flashcard deck
            Flashcard wrongAnswer1 = null;                               //placeholders for our wrong answers
            Flashcard wrongAnswer2 = null;
            Flashcard wrongAnswer3 = null;
            AnswerType answerType;
            switch(getCardType())          //using roll method to get a random question type enum
            {
                case TYPE_IN:       //puts a new type-in question which has the answer as the term and prompt as the definition
                    qDeck.put(new TypeIn(answerCard.revealTerm().toLowerCase(), answerCard.revealDefinition()));
                    break;
                case TRUE_OR_FALSE:
                    answerType = getAnswerType();    //get the answer type for our question
                    if (answerIsTrue())              //check to see if this will be a true or false answer
                        qDeck.put(new TrueFalse(getAnswer(answerType, answerCard), getPrompt(answerType, answerCard), true));
                    wrongAnswer1 = (Flashcard) peek(fcDeck); //if it's not true, put in a wrong prompt
                    qDeck.put(new TrueFalse(getAnswer(answerType, answerCard), getPrompt(answerType, wrongAnswer1), false));
                    break;
                default:
                    answerType = getAnswerType();
                    wrongAnswer1 = (Flashcard) peek(fcDeck);
                    while (wrongAnswer2 == null)
                    {
                        Flashcard temp = (Flashcard)peek(fcDeck);
                        if (temp != wrongAnswer1)
                            wrongAnswer2 = temp;
                    }
                    while (wrongAnswer3==null)
                    {
                        Flashcard temp = (Flashcard) peek(fcDeck);
                        if (temp != wrongAnswer1 && temp != wrongAnswer2)
                            wrongAnswer3 = temp;
                    }
                    Flashcard[] quiz = quizAnswersOrdered(answerCard,
                            wrongAnswer1, wrongAnswer2, wrongAnswer3);

                    qDeck.put(new Quiz(getAnswer(answerType, answerCard),
                            getPrompt(answerType, answerCard), getAnswer(answerType, quiz[0]),
                            getAnswer(answerType, quiz[1]), getAnswer(answerType, quiz[2]),
                            getAnswer(answerType, quiz[3])));
                    break;
            }


        }
        decks.put(DeckType.QUESTION, qDeck);
    }


    @Override
    public int roll(int max)
    {
        return new Random().nextInt(max);
    }

    private CardType getCardType()
    {
        int roll = roll(SIX_SIDED_DIE);
        if(roll==5)
            return CardType.TYPE_IN;
        if(roll==4)
            return CardType.TRUE_OR_FALSE;
        return CardType.QUIZ;
    }

//picks answer type
    private AnswerType getAnswerType()
    {
        int roll = roll(SIX_SIDED_DIE);
        if (roll==5)
            return AnswerType.EXAMPLE;
        if(roll>=3)
            return AnswerType.DEFINITION;
        return AnswerType.TERM;
    }
//makes appropriate answers based on answer type
    private String getAnswer(AnswerType answerType, Flashcard flashcard)
    {
        return switch (answerType)
        {
            case EXAMPLE -> flashcard.revealExample();
            case DEFINITION -> flashcard.revealDefinition();
            case TERM -> flashcard.revealTerm();
        };
    }

//true or false specific
    private boolean answerIsTrue()
    {
        return roll(SIX_SIDED_DIE) > 2;
    }
    private String getPrompt(AnswerType answerType, Flashcard cardForPrompt)
    {
        return switch(answerType)
        {
            case EXAMPLE, DEFINITION -> cardForPrompt.revealTerm();
            case TERM -> getTermAnswer(cardForPrompt);
        };

    }
    private String getTermAnswer(Flashcard cardForPrompt)
    {
        if(roll(7)>3)
            return cardForPrompt.revealExample();
        return cardForPrompt.revealDefinition();
    }
//end true false specific

//Quiz
    private Flashcard[] quizAnswersOrdered(Flashcard a, Flashcard b, Flashcard c, Flashcard d)
    {
        Random rng = new Random();
        Flashcard[] result = {a,b,c,d};
        for(int i = result.length - 1; i > 0; i--)
        {
            int n = rng.nextInt(i+1);
            Flashcard temp = result[n];
            result[n]=result[i];
            result[i]=temp;
        }

        return result;
    }

    private Card peek(Deck deck)
    {
        return deck.peek(deck.roll(deck.count()));
    }
}
