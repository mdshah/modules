
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jeremy Spencer
 */
public class WikiWrapper 
{
    public WikiWrapper()
    {
        
    }
    /* returns true for only exact string matches (case insensitive) */
    public boolean hasWikiPage(String search)
    {
        String search_formatted = search.replace(' ', '+');
        HashMap<String,Integer> wikiHits =  new HashMap();
        try { 
            URL yahoo = new URL("http://en.wikipedia.org/w/api.php?action=opensearch&search=" + search_formatted); 
            BufferedReader in = new BufferedReader(new InputStreamReader(yahoo.openStream())); 
            String inputLine; 
            while ((inputLine = in.readLine()) != null) { 
                String delim1 = "[,]";
                String delim2 = "[\"]";
                String[] tokens = inputLine.split(delim1);
                for(int i = 1; i < tokens.length; i++)
                {
                    if(tokens[i].equals("[]]"))
                        return false;
                    
                    tokens[i] = tokens[i].replace('[', ' ');
                    tokens[i] = tokens[i].replace(']', ' '); 
                    //System.out.println(i + ": "+ tokens[i] + "");
                    String[] token2 = tokens[i].split(delim2);
                    //System.out.println("|"+token2[1].toLowerCase()+"|");
                    wikiHits.put(token2[1].toLowerCase(), 1);
                }
                // print line from URL
                //System.out.println(inputLine); 
            } 
            in.close(); 

        } catch (MalformedURLException me) { 
            System.out.println(me); 

        } catch (IOException ioe) { 
            System.out.println(ioe); 
        }
        //System.out.println("|"+search.toLowerCase()+"|");
        if(wikiHits.containsKey(search.toLowerCase()))
            return true;
        else
            return false;
    }
    
    /* pass in an array list of words to check in wiki page, if a specific page does
     * not exist it will return null. It will return a hashMap of words found in the page
     */
    public HashMap<String,Integer> containWordsGivenPage(ArrayList<String> words, String pageTitle)
    {
        if(words == null)
            return null;
        HashMap<String, Integer> contains = new HashMap();
        
        /* ensure that pageTitle exists */
        if(!hasWikiPage(pageTitle))
        {
            System.err.println("Page title does not exist");
            return null;
        }
        
        int wordsFound = 0;
        String pageTitle_Formatted = pageTitle.replace(' ', '_');
        try { 
            URL yahoo = new URL("http://en.wikipedia.org/wiki/" + pageTitle_Formatted); 
            BufferedReader in = new BufferedReader(new InputStreamReader(yahoo.openStream())); 
            String inputLine; 
            while ((inputLine = in.readLine()) != null) {       
                if(wordsFound == words.size())
                    break;
                for(int i = 0; i < words.size(); i++)
                {
                    if(contains.containsKey(words.get(i)))
                        continue;
                    
                    if(inputLine.contains(" " + words.get(i) + " "))
                    {
                        contains.put(words.get(i), 1);
                        //System.out.println("contains: " + words.get(i));
                        wordsFound++;
                    }
                }
                //System.out.println(inputLine); 
            } 
            in.close(); 

        } catch (MalformedURLException me) { 
            System.out.println(me); 

        } catch (IOException ioe) { 
            System.out.println(ioe); 
        }
        return contains;
    }
}
