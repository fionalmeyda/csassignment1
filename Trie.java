


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Trie {
 
    private TrieNode root;

    
    public Trie() {

        root = new TrieNode();

    }
    
    

// Inserts a word into the trie.
    public void insert(String word) {

        Hashtable<Character, TrieNode> children = root.children;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){

                t = children.get(c);

            }
            else{

                t = new TrieNode(c);
                children.put(c, t);

            }

            children = t.children;
            //set leaf node

            if(i==word.length()-1)

                t.isLeaf = true;

       }
        
}
// Returns if the word is in the trie.
public boolean search(String word) {

    TrieNode t = searchNode(word);
    if(t != null && t.isLeaf)
         return true;

    else
         return false;

}

// Returns if there is any word in the trie
// that starts with the given prefix.
public boolean startsWith(String prefix) {

    if(searchNode(prefix) == null)
         return false;

    else
       return true;
}

public TrieNode searchNode(String str){
    
    Hashtable<Character, TrieNode> children = root.children;
    TrieNode t = null;

    for(int i=0; i<str.length(); i++){

        char c = str.charAt(i);
        if(children.containsKey(c)){

            t = children.get(c);
            children = t.children;

        }
        else{

            return null;

        }

    }

    return t;

}



public String [] getNode(String str){

     Hashtable<Character, TrieNode> children1 = root.children;
     Hashtable<Character, TrieNode> children2 = root.children;
     Hashtable<Character, TrieNode> children3 = root.children;
     
     TrieNode [] t = new TrieNode[3] ;
     t[0] = null;
     t[1] = null;
     t[2] = null;
             
     List<String> store_characters = new ArrayList<>();
     
     for(int i=0; i<str.length(); i++){

        char c = str.charAt(i);
        if(children1.containsKey(c)){

            t[0] = children1.get(c);
            children1 = t[0].children;

            t[1] = children2.get(c);
            children2 = t[1].children;

            
            t[2] = children3.get(c);
            children3 = t[2].children;

        }
    }
     
     
     
     
            if(t[0].isLeaf){
               
                return new String []{ str };
               
            }
            else{
               
                Object[] keys = children1.keySet().toArray();
        
                if(keys.length < 3 ){
         
                   while ( !t[0].isLeaf ){
               
                       
                        Object[] key = children1.keySet().toArray();
                        t[0] = children1.get((char)key[0]);
                        children1 = t[0].children;
                        str= str+(char)key[0];
                       
                   } 
                
                 return new String []{ str };
              
                }
           
                else{
        
                    String s1 = str,s2 = str ,s3 = str;
                    
                      Object[] key = children1.keySet().toArray();
                      t[0] = children1.get((char)key[0]);
                      children1 = t[0].children;
                      s1= s1+(char)key[0];
                        
                      key = children2.keySet().toArray();
                      t[1] = children2.get((char)key[1]);
                      children2 = t[1].children;
                      s2= s2+(char)key[1];
                     
                      key = children3.keySet().toArray();
                      t[2] = children3.get((char)key[2]);
                      children3 = t[2].children;
                      s3= s3+(char)key[2];
                       
                     
                    
                    while ( !t[0].isLeaf ){
               
                       
                        key = children1.keySet().toArray();
                        t[0] = children1.get((char)key[0]);
                        children1 = t[0].children;
                       
                        s1= s1+(char)key[0];
                       
                   }
                    
                   while ( !t[1].isLeaf ){
               
                       
                        key = children2.keySet().toArray();
                        t[1] = children2.get((char)key[0]);
                        children2 = t[1].children;
                       
                        s2= s2+(char)key[0];
                       
                   }
                   
                   while ( !t[2].isLeaf ){
               
                       
                        key = children3.keySet().toArray();
                        t[2] = children3.get((char)key[0]);
                        children3 = t[2].children;
                       
                        s3= s3+(char)key[0];
                       
                   }
                    
                  return new String []{ s1,s2,s3  };
              
                }
            }
            
     
    
     }

}
