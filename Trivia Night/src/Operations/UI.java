package Operations;

import Flashcards.Card;
import Flashcards.Flashcard;
import Questions.Quiz;
import Questions.TrueFalse;
import Questions.TypeIn;

import java.util.Scanner;

public class UI
{
    private final Scanner input = new Scanner(System.in);
    private final Internal secretary = new Internal();
    private String userInput;

    public Internal getSecretary() {
        return secretary;
    }


    public UI()
    {
        System.out.println("Successfully initialized. \n");
        System.out.print("Hello! ");
    }

    public CardType modeSelect()
    {
        int failCount = 0;
        while(true)
        {
            System.out.println("Please select a mode: \n");
            System.out.println("1.) Review \n2.) Quiz \n3.) Exit\n");
            userInput = input.next();
                switch (secretary.checkInput(userInput))
                {
                    case 1:
                        return CardType.FLASHCARD;


                    case 2:
                        return CardType.QUESTION;


                    case 3:
                        System.out.println("\nExcellent! Have a wonderful day.\n\nShutting down...");
                        return null;


                    default:
                        failCount++;
                        if(failCount>=5)
                        {
                            System.out.println("\n" + failCount + " times? You're wasting my time. Get out of my office! \n");
                            return null;
                        }
                        if(failCount>=3)
                            System.out.print("\nYou're struggling with the keys, aren't you? We really can't do anything with "+ userInput +".\n");
                        else
                            System.out.println("\n" + userInput + "? No, we can't do anything with that.\n");

                }
        }
    }

    private void quizDisplay(Quiz question)
    {
        boolean stop = false;
        while (!stop)
        {
            System.out.println(question.getPrompt());
            System.out.println("1.) " + question.getA());
            System.out.println("2.) " + question.getB());
            System.out.println("3.) " + question.getC());
            System.out.println("4.) " + question.getD()+"\n");
            userInput = input.next();
            switch(secretary.checkInput(userInput))
            {
                case 1:
                    if(question.check(question.getA()))
                    {
                        System.out.println("Correct!");
                        secretary.addPoint();
                    } else
                        System.out.println("No, that is not correct! The correct answer is "
                        + question.getCorrectAnswer() + ".");
                    stop = true;
                    break;
                case 2:
                    if(question.check(question.getB()))
                    {
                        System.out.println("Correct!");
                        secretary.addPoint();
                    } else
                        System.out.println("No, that is not correct! The correct answer is "
                                + question.getCorrectAnswer() + ".");
                    stop = true;
                    break;
                case 3:
                    if(question.check(question.getC()))
                    {
                        System.out.println("Correct!");
                        secretary.addPoint();
                    } else
                        System.out.println("No, that is not correct! The correct answer is "
                                + question.getCorrectAnswer() + ".");
                    stop = true;
                    break;
                case 4:
                    if(question.check(question.getD()))
                    {
                        System.out.println("Correct!");
                        secretary.addPoint();
                    } else
                        System.out.println("No, that is not correct! The correct answer is "
                                + question.getCorrectAnswer() + ".");
                    stop = true;
                    break;
                default:
                    System.out.println("\n" + userInput + "? We can't do anything with that. Try again.\n");
            }
        }


    }
    private void trueFalseDisplay(TrueFalse question)
    {
        boolean stop = false;
        while (!stop)
        {
        System.out.println(question.getPrompt() +
                "\n\n1.) True 2.) False\n");
        userInput = input.next();
            switch (secretary.checkInput(userInput))
            {
                case 1:
                    if(question.check())
                    {
                        System.out.println("Correct!\n");
                        secretary.addPoint();
                    } else
                        System.out.println("No, that is not correct!");
                    stop = true;
                    break;
                case 2:
                    if(!question.check())
                    {
                        System.out.println("Correct!\n");
                        secretary.addPoint();
                    } else
                        System.out.println("No, that is not correct!");
                    stop = true;
                    break;
                default:
                    System.out.println("\n" + userInput + "? We can't do anything with that. Try again.\n");
            }
        }
    }

    private void typeInDisplay(TypeIn question)
    {
        System.out.println(question.getPrompt());
        if(question.check(input.next()))
        {
            System.out.println("Correct!");
            secretary.addPoint();
        } else
            System.out.println("No, that is not correct!");
    }



    private void flashcardDisplay(Flashcard review)
    {
        System.out.println("Yet to be implemented. Come back later.");
    }


    public void getQuestion(Card card)
    {
        switch(card.getCardType())
        {
            case FLASHCARD:
                flashcardDisplay((Flashcard)card);
                break;

            case QUIZ:
                quizDisplay((Quiz)card);
                break;

            case TRUE_OR_FALSE:
                trueFalseDisplay((TrueFalse)card);
                break;

            case TYPE_IN:
                typeInDisplay((TypeIn)card);
                break;


            default:
                System.out.println("\nSomething went wrong. We can't process this. \n");
                break;
        }
    }


    public void displayScore(int count)
    {
        System.out.println("Total Answered: "+ count +", Score: " +
                secretary.getPoints() + "/" + secretary.getTotalQuestions()
                +"\n");
    }

    public void finalVerdict()
    {
        System.out.println("Your final score is: " + secretary.getPoints() +
                "/" + secretary.getTotalQuestions() + "\n");
    }
}
