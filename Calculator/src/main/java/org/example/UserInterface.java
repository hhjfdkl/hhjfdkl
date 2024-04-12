package org.example;

public class UserInterface {

    private static final UserInterface ui = new UserInterface();
    private UserInterface(){}
    public static UserInterface getInstance()
    {
        return ui;
    }
}
