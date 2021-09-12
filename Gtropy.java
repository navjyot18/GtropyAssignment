//java code to design  a dictionary Data structure , where any word when entered, it searches the entered word in
//the dictionary and returns the relevant searched word if any!
import java.util.*;  
import java.io.*;  
class Dictionary 
{
    DictionaryNode root;
    class DictionaryNode 
    {
        DictionaryNode[] childs;
        boolean isEnd;
        //Constructor of DictionaryNode class
        public DictionaryNode() 
        {
            childs = new DictionaryNode[26];
        }
    }

    //Constructor of Dictionary class
    public Dictionary() 
    {
        root = new DictionaryNode();
    }
  
    /** Inserts a word into the trie. */
    //Time Complexity analysis: O(length(word));
    //Space Complexity analysis: O(length(word));
    public void insertInto(String word) 
    {
        DictionaryNode currNode = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(currNode.childs[ch-'a']==null)
            {
                currNode.childs[ch-'a'] = new DictionaryNode();
            }
            currNode = currNode.childs[ch-'a']; 
        }
        currNode.isEnd = true;
    }
    
    /** Returns if the word is in the data Structure. */
    //Time Complexity analysis: O(length(word));
    //Space Complexity analysis: O(1);
    public boolean searchInDictionary(String word) 
    {
        DictionaryNode currNode = root;
        for (char c : word.toCharArray())
        {
            if (currNode.childs[c - 'a'] == null) 
            {
                return false;
            }
            currNode = currNode.childs[c - 'a'];
        }
        return currNode.isEnd;
    }
    
}

class Gtropy 
{
	public static void main(String[] args) throws Exception 
	{
        String line;  
        //Opens a file in read mode  
        FileReader file = new FileReader("list.txt");  
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(file);  
        //object creation
        Dictionary obj = new Dictionary();

        //Gets each line till end of file is reached  
        while((line = br.readLine()) != null) 
        {  
            //Splits each line into words  
            line = line.replaceAll("[^a-zA-Z0-9]", "");
			//inserts the word in dictionary
			obj.insertInto(line.toLowerCase());
        }
        
        //Input a word to search and call search method over the data structure
        String inputWord = sc.next();
        boolean flag = obj.searchInDictionary(inputWord.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
        String res = (flag==true)?"present":"absent";
        System.out.print("Entered word "+inputWord+" is "+res);
        br.close();  
	}


}
