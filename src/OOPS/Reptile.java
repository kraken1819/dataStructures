package OOPS;

public class Reptile extends Animal{

    private String skin = "DrySkin" ;
    private String bone= "backbone";
    private String eggs;

    public Reptile(){
        eggs = "Soft-shelled Eggs" ;
    }
    public Reptile(int height,int weight,String animalType,String bloodType,String eggs){

        super(height,weight,animalType,bloodType);


        this.eggs = eggs ;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getBone() {
        return bone;
    }

    public void setBone(String bone) {
        this.bone = bone;
    }

    public String getEggs() {
        return eggs;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }
}
