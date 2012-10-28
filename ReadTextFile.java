
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay
 */
public class ReadTextFile 
{
    public static void main(String args[])
    {
        try 
        {
            FileInputStream fstream = new FileInputStream("g4_Biology_Updated.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String website;
            while((website = br.readLine()) != null)
            {
                if(website.length() == 0)
                {
                    System.out.println("Done");
                    break;
                }
                /* process this link */
                System.out.println("Parsing this site: " + website);
                HTMLHandler hl = new HTMLHandler(website);
		hl.setElementsBy("courseInfo");
		hl.printText();
            }
            in.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
