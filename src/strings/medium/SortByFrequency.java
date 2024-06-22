package strings.medium;

import java.util.HashMap ; 
import java.util.Map ; 
import java.util.PriorityQueue; 
import java.util.Comparator; 

public class SortByFrequency {

    public static String frequencySort(String s ) { 

        HashMap<Character , Integer> hm = new HashMap<>() ; 

        for(int i =0 ; i<s.length() ; i++){
            char ele = s.charAt(i) ; 

            if(hm.containsKey(ele)){
                hm.put(ele,hm.get(ele)+1) ; 
            }else { 
                hm.put(ele,1) ; 
            }
        }  

        PriorityQueue < Map.Entry<Character,Integer> > pq = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character,Integer> a, Map.Entry<Character,Integer> b){
                return b.getValue()-a.getValue() ; 
            }
        }); 

        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            pq.add(entry) ; 
        }

        int size = pq.size() ; 
        StringBuilder ans = new StringBuilder() ; 

        for(int i =0 ; i<size ; i++){
            Map.Entry<Character,Integer> entry = pq.poll() ; 
            char ch = entry.getKey() ; 
            int value = entry.getValue() ; 
            while(value-->0){
                ans.append(ch) ; 
            }
        }

        return ans.toString() ; 
    }

    public static void main(String[] args){
        String s = "tree" ; 
        System.out.println(frequencySort(s)) ; 
    }

}
