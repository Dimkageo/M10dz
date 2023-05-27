import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Words {
    public static void main(String[] args) {
        File file= new File("Words.txt");
        Map<String,Integer> wordFrequency =new HashMap<>();


        try (FileInputStream fileInputStream = new FileInputStream(file);
             Scanner scanner = new Scanner(fileInputStream)){
            while (scanner.hasNext()){
                String word = scanner.next();
                if(wordFrequency.containsKey(word)){
                    int frequency = wordFrequency.get(word);
                    wordFrequency.put(word,frequency+1);

                }else {
                    wordFrequency.put(word, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordFrequency.get(o1).compareTo(wordFrequency.get(o2));
            }
        };

        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
        result.putAll(wordFrequency);

        for (String key: result.keySet()){
            System.out.println(key+" "+result.get(key));
        }
    }

}
