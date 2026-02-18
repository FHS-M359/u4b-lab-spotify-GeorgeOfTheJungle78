import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner inF = new Scanner(new File("spotify_unique_years_artists.txt"));
        ArrayList<Song> list = new ArrayList<>();
        while(inF.hasNextLine()){
            String[] line = inF.nextLine().split(",");
            String name = line[0];
            String creator = line[1];
            String album = line[2];
            int spot = Integer.parseInt(line[3]);
            int year = Integer.parseInt(line[4]);
            String genre = line[5];
            list.add(new Song(name, creator, album, spot, year, genre));
        }
        Playlist songs = new Playlist(list);

        System.out.println(songs);
        System.out.println();
        System.out.println(songs.toString(songs.sortAl()));

        //System.out.println(songs.toString(songs.sortGenre("pop")));
    }
}
