package OOPS;

public class Crocodile extends Reptile{

    private String eggs  ;

    public Crocodile(){
        this.eggs = "Hard-shelled eggs";
    }
    public Crocodile(int height , int weight , String animalType , String bloodType, String eggs){
        super(height,weight,animalType,bloodType,eggs) ;
    }
    @Override
    public void showInfo(){
        super.showInfo() ;
        System.out.println("Crocodile{ eggs: " + eggs + "}") ;

    }
}
