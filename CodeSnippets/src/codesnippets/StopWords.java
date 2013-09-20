/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codesnippets;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lazarevsky
 */
public class StopWords {

    public static HashMap<String, Integer> removeStopWords(String input, String[] stopWords) {

        String[] aux = new String[stopWords.length];

        for (int i = 0; i < aux.length; i++) {
            aux[i] = "";
        }

        HashMap<String, Integer> hm = new HashMap<>();

        input = StringUtils.replaceEach(input, stopWords, aux);

        input = input.replaceAll("[^A-Za-z0-9 ]", "");

        String[] arr = input.split(" ");

        for (String s : arr) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }

        if (hm.containsKey("")) {
            hm.remove("");
        }

        return hm;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashMap<String, Integer> filteredContent = removeStopWords("stop dob'ro'?,                ut''''????###ro''' dobar like den dobar vecher stop", new String[]{"stop", "like"});
        for (Map.Entry pair : filteredContent.entrySet()) {
            System.out.println("Key: " + pair.getKey() + " - Value : " + pair.getValue());
        }

    }
}
