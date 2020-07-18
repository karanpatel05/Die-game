import javax.swing.*;
/**
 * Write a description of class GameViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameViewer
{

    public static void main(String args [])
    {

        final int width =  500;
        final int height = 400;

        JFrame frame = new DieFrame();
        frame.setTitle("Kristov's Revenge");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
