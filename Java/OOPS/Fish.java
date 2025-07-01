package OOPS;

public class Fish extends Animal {
    String habitat ;
    String breathesWith ;

    public Fish(){
        habitat = "Water" ;
        breathesWith = "Gills";
    }
    public Fish(int height , int weight , String animalType, String bloodType, String habitat , String breathesWith) {
        super(height ,weight , animalType,bloodType);
        this.habitat = habitat ;
        this.breathesWith = breathesWith ;
    }
}
