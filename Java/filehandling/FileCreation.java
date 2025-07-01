package filehandling;

import java.io.File ;
import java.io.IOException;

public class FileCreation {
    public static void main(String[] args) throws IOException {

        File file = new File("codu\\filehandling\\file.txt") ;
        file.createNewFile() ;
        System.out.println("file created") ;

    }
}
