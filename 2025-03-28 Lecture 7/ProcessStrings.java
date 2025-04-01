import java.util.LinkedList;
import java.util.List;
/** A class for processing lists of strings */
public class ProcessStrings {

    /** The strings to process */
    public List<String> strings;

    /**
     * Constructs a string processor for some strings
     * @param strings the strings to process
     */
    public ProcessStrings(List<String> strings){
        this.strings = strings;
    }


    /**
     * Calculates the total characters in all the strings
     * @return the number of characters total
     */
    public int totalCharacters(){
        int count = 0;
//        for(String word : strings){
//            count += word.length();
//        }

        for (int i = 0; i < strings.size(); i++){
            count += strings.get(i).length();
        }

        return count;
    }

    /**
     * finds the longest string in the list
     * @return the longest string in the list (or "" if the list is empty)
     */
    public String longestString(){
        String ans = "";
        for(String word : strings){
            if(word.length() > ans.length()){
                ans = word;
            }
        }
        return ans;
    }

    /**
     * filters out only the strings that have a particular length
     * @param length the length of strings to keep
     * @return a *new* list of strings with the given length
     */
    public List<String> stringsWithLength(int length){
        LinkedList<String> ans = new LinkedList<>();
        for(String word: strings){
            if(word.length() == length){
                ans.add(word);
            }
        }
        return ans;
    }

}
