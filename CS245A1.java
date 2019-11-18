
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CS245A1 {

    
    static Trie trie;
    static Scanner input = new Scanner(System.in);
    static List<String> write = new ArrayList<>();
    
    public static void main(String[] args) {
        
        trie= new Trie();
        readfile("input.txt");
        
        System.out.println("Enter your word : ");
        String word = input.nextLine();
        checkspelling(word);
        write_to_file("output.txt");
    }
    
    
    
    public static void write_to_file(String path){
    
                String content = "This is the content to write into file";

        try (FileWriter writer = new FileWriter(path);
             BufferedWriter bw = new BufferedWriter(writer)) {
             for(int i =0; i < write.size(); i++){
              
                 bw.write(write.get(i)+"\n");

             }
            
            
        } catch (IOException e) {
            System.err.format("IOException:", e);
        }

        
    }
    
    
      public static void checkspelling(String word){
      
          if(trie.search(word)){
            
              System.out.println("Your word spelling is correct : "+ word );
              write.add(word);
        
          }
          else{
          
              int character_count = word.length();
              
              for(int i =character_count ; i >= 0 ; i--){
              
                  if( trie.startsWith(word.substring(0, character_count ))  ){
                    break;
                  }
                  else{
                   character_count--;
                  }
              
              }
              
              
              String [] suggested_words = trie.getNode(word.substring(0, character_count ));
               System.out.println("suggested Words : ");
                     
              for(int j =0 ; j < suggested_words.length ; j++ ){
              
                     
                   System.out.println((j+1)+" "+ suggested_words[j] );
                   write.add(suggested_words[j]);
                     
              }
              
              
          }
          
          
          
      }
    
    
    // read file and store data
    public static void readfile(String path){
    
        System.out.println("please wait, data is fetching and storing");
                         
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(path);
            br = new BufferedReader(fr);

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()){
                         
                         trie.insert(line.trim());
                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }

    
    
    
    }

        
        
    
    
}
