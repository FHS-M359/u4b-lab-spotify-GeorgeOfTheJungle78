public class Song {
    private String name, creator, album, genre;
    private int spot, year;

    public Song(String name, String creator, String album, int spot, int year, String genre){
        this.name = name;
        this.creator = creator;
        this.album = album;
        this.spot = spot;
        this.year = year;
        this.genre = genre;
    }

    public String getName(){
        return name;
    }
    public String getCreator() {
        return creator;
    }
    public String getAlbum() {
        return album;
    }
    public int getSpot() {
        return spot;
    }
    public int getYear() {
        return year;
    }
    public String getGenre() {
        return genre;
    }

    public String toString(){
        return String.format("%-30s %-20s %-30s %-10d %-10s", name, creator, album, year, genre);
    }
}
