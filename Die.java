import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class has representation of single die. 
 *
 * @author (KaranKumar Patel)
 * @version (6 -10-2020)
 */
public class Die
{
    private int FaceValue;
    private int numRolls;
    //loading all the imageicon
    private final ImageIcon FaceValue1 = new ImageIcon ("dice-1.png");
    private final ImageIcon FaceValue2 = new ImageIcon ("dice-2.png");
    private final ImageIcon FaceValue3 = new ImageIcon ("dice-3.png");
    private final ImageIcon FaceValue4 = new ImageIcon ("dice-4.png");
    private final ImageIcon FaceValue5 = new ImageIcon ("dice-5.png");
    private final ImageIcon FaceValue6 = new ImageIcon ("dice-6.png");
    
    /**
     * Constructor of die Class
     */
    public Die()
    {
      FaceValue = 1;
    }
    
     
    /**
     *This is a method to get a facevalue of the Die.
     *@param This method has no parameter to take in.
     *@return This method return a Integer Value.
     */
    public int getFaceValue()
    {
      return FaceValue;
    }
    
    /**
     *This is a method to get a random value as in form of die
     *@param This method has no parameter to take in.
     *@return This method return a Integer Value.
     */
    public int Roll()
    {
      FaceValue = (int)(Math.random()*6)+1;
      numRolls++;
      return FaceValue;
    }
    
    /**
     *This is a method to get a Imageicon of FaceValue.
     *@param This method take Integer has a parameter
     *@return This method return an Image of the faceValue..
     */
    public ImageIcon getPic(int facevalue)
    {
        switch(facevalue)
        {
           case 1 : return FaceValue1;
           case 2 : return FaceValue2;
           case 3 : return FaceValue3;
           case 4 : return FaceValue4;
           case 5 : return FaceValue5;
           case 6 : return FaceValue6;
        }
        return null;
    }
    
    /**
     *This is a method to display the Textual Description of the Die.
     *@param This method no parameter to take in.
     *@return This method return String.
     */
    public String toString()
    {
       return " Die is rolled with face value of " +FaceValue +"\n This die had rolled for " 
       + numRolls + " times till now";
    }
}
