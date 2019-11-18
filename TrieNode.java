
import java.util.Hashtable;

public class TrieNode {
 
char c;
Hashtable<Character, TrieNode> children = new Hashtable<Character, TrieNode>();
boolean isLeaf;
    
public TrieNode() {
    
}

public TrieNode(char c){
   this.c = c;
}
    
}
