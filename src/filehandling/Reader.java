package filehandling;
import java.io.* ;
public class Reader {

    public static void main(String[] args) {
        File file = new File("codu\\filehandling\\file.txt") ;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String temp ;
            while( (temp = br.readLine()) !=null) {
                System.out.println(temp+":") ;
            }
            System.out.println("Operation Successfull") ;
        }catch(IOException e ) {
            e.printStackTrace();
        }
    }
}
