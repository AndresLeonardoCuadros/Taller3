package co.edu.unbosque.tallerciudadanosde4patas3.Info;

public class Pet {
    private String petName;
    private String imageName;

    public Pet(String petName, String imageName) {
        this.petName = petName;
        this.imageName = imageName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
