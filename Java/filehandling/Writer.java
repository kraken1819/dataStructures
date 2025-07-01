package filehandling;

import java.io.* ;

public class Writer {

    public static void main(String[] args) throws IOException{

        File file = new File("codu\\filehandling\\file.txt") ;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
            bw.write("whats");
            bw.newLine() ;
            bw.write("up");
            bw.newLine() ;
            bw.write("my nigga");
            bw.newLine() ;

            System.out.println("Operation success ") ;

        }catch(IOException e){
            System.out.println("something went wrong") ;
            e.printStackTrace() ;
        }

    }
}
