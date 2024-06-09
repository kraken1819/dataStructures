package leetcode.biweekly.biweekly132;

import java.util.LinkedList ;
import java.util.HashMap ;

public class FirstPlayerToWinkGames {

    public static int maxElement(int[] skills) {
        int max = Integer.MIN_VALUE ;
        int index = -1 ;
        for(int i =0 ; i<skills.length ; i++) {
            if(skills[i]>max){
                max = skills[i] ;
                index = i ;
            }
        }
        return index ;

    }



    public static int findWinningPlayer(int[] skills , int k ) {


        if(k>=skills.length) {
            return maxElement(skills) ;
        }

        int count = 0 ;
        int skill = -1 ;

        HashMap<Integer,Integer> mapu = new HashMap<>() ;
        for(int i =0 ; i<skills.length ; i++) {
            mapu.put(skills[i],i) ;
        }

        LinkedList<Integer> Llist = new LinkedList<>() ;
        for(int i =0 ; i<skills.length ; i++){
            Llist.add(skills[i]) ;
        }

        while(true) {
            //we compare head with next element .

            if(Llist.get(0) > Llist.get(1)){
                skill = Llist.get(0) ;

                Llist.add(Llist.get(1)) ;

                Llist.remove(1) ;
                count++ ;
            }else {
                Llist.add(Llist.get(0)) ;
                skill = Llist.get(1) ;
                Llist.remove(0) ;

                count = 1 ;
            }

            if(count== k ) {
                return mapu.get(skill);
            }
            //System.out.println(Llist.toString()) ;
        }


    }

    public static void main(String[] args) {
        int[] skills = {4,18,17,20,15,12,8,5} ;
        int k = 1 ;
        System.out.println(findWinningPlayer(skills,k)) ;
    }
}
