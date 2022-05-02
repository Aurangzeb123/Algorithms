
import java.util.*;
public class Main{
    
    public static void main (String[] args) {
        /* code */
        HashTable ht=new HashTable();
        ht.add("dilshad",4);
        ht.add("this",1);
        ht.add("hello",3);
        
        
        System.out.print(ht.get("dilshad"));
    }
}

class HashTable
{
    ArrayList<HashNode> bucket;
    int bucketSize;
    
    class HashNode
    {
        int value;
        String key;
        HashNode next;
        
        public HashNode(int value, String key)
        {
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    
    
    public HashTable()
    {
        this.bucket = new ArrayList<HashNode>();
        this.bucketSize=10;
        
        for(int i=0;i<10;i++)
            this.bucket.add(null);
    }
    
    private int getIndex(String key)
    {
        return Objects.hashCode(key)%bucketSize;
    }
    
    public void add(String key, int value)
    {
        int index=getIndex(key);
        HashNode newNode=new HashNode(value, key);
        
        HashNode head=bucket.get(index);
        if(head==null){
            this.bucket.set(index,newNode);
            System.out.println("added at head of index "+index);
        }
        else
        {
            while(head.next!=null)
            {
                head=head.next;
            }
            
            head.next=newNode;
            System.out.println("added at tail of index "+ index);
        }    
    }
    
    public int get(String key)
    {
        int index=getIndex(key);
        System.out.println("index calculated in get() "+ index);
        HashNode head=bucket.get(index);
        if(head==null) 
        {
            System.out.print("head is null. ");
            return -1;
        }
        
        while(head!=null)
        {
            if(head.key.equals(key))
                return head.value;
            head=head.next;
        }
        
        System.out.print("not found ");
        return -1;
    }
    
}
