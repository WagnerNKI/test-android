package codingwithmitch.com.recyclerview;

public class Pokemon {
    private String Name;
    private String ImageUrl;
    private String nationalPokedexNumber;
    private String Hp;

    public Pokemon(String name, String imageUrl, String nationalPokedexNumber, String hp) {
        this.Name = name;
        this.ImageUrl = imageUrl;
        this.nationalPokedexNumber = nationalPokedexNumber;
        this.Hp = hp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public void setNationalPokedexNumber(String nationalPokedexNumber) {
        this.nationalPokedexNumber = nationalPokedexNumber;
    }

    public String getHp() {
        return Hp;
    }

    public void setHp(String hp) {
        Hp = hp;
    }


}
