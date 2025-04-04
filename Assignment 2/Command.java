/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is null.
 *
 * If the command had only one word, then the second word is null.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * 
 * @author Lynn Marshall
 * @version October 21, 2012
 * 
 * @author Amina Hajiyeva
 * @version March 7, 2025
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * 
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised
     * @param secondWord The second word of the command
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * 
     * @return The command word, or null if not understood
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Returns the second word of the command.  Returns null if there was no
     * second word.
     * 
     * @return The second word of this command, or null if only one word
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Returns true if the command is unknown.
     * 
     * @return true if this command was not understood, false otherwise
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * Returns true if the command has a second word.
     * 
     * @return true if the command has a second word, false otherwise
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

