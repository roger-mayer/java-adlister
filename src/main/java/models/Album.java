package models;

import java.io.Serializable;

public class Album implements Serializable{
    private long id;
    private String artist;
    private String name;
    private int releaseDate;
    private double sales;

    public Album(long id, String artist, String name, int releaseDate, double sales) {
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.releaseDate = releaseDate;
        this.sales = sales;
    }

    public long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public double getSales() {
        return sales;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }


    @Override
    public String toString() {
        return "models.Album{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", sales=" + sales +
                '}';
    }
}
