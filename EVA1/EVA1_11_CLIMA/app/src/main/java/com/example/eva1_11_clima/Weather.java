package com.example.eva1_11_clima;

public class Weather {
    /* Nombre de la ciudad - String
    *Temperatura - int
    * Descripción del clima - String
    * Imagen - int
     */

    private String city;
    private int temp;
    private String desc;
    private int image;

    public Weather(){
        this.city = "";
        this.temp = 0;
        this.desc = "";
        this.image = -1;
    }
    public Weather(String city, int temp, String desc, int image) {
        this.city = city;
        this.temp = temp;
        this.desc = desc;
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
