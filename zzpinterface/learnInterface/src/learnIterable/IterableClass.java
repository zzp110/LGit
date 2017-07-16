package learnIterable;
import java.util.*;

public class IterableClass implements Iterable<String>{

    protected String [] words = "I am zzp.".split(" ");

    @Override
    public Iterator<String> iterator(){
        return new Iterator<String>(){
            private int index = 0;
                public boolean hasNext(){
                    return index < words.length;
                }
                public String next(){
                    return words[index++];
                }
                public void remove(){
                }
        };
    }
    public static void main(String[] args) {
        IterableClass b = new IterableClass();
        for(String s : b){
            System.out.print(s+" ");
        }

    }

}
