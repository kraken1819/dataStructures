import java.util.Scanner ; 

public class CreatingWords {

    public static void main(String[] args) { 
        Scanner scx = new Scanner(System.in) ; 
        int t = scx.nextInt() ; 

        while(t-->0){
            String s1 = scx.next() ; 
            String s2 = scx.next() ; 

            if(s1.charAt(0)==s2.charAt(0)){
                System.out.println(s1+ " " + s2) ; 
            }else { 
                String sn1 = s2.charAt(0) + s1.substring(1,3) ;
                String sn2 = s1.charAt(0) + s2.substring(1,3) ; 
                System.out.println(sn1+ " " + sn2) ; 
                
            }
        }
    }

}
