import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Playlist {

    private ArrayList<Song> list;
    private ArrayList <Song> genreList;

    public Playlist(String file) throws IOException, FileNotFoundException {
        list = new ArrayList<>();
        Scanner inF = new Scanner(new File(file));
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
        inF.close();
    }

    public String toString(){
        String result = String.format("%-30s %-20s %-29s %-11s %-10s", "Song Name", "Artist" , "Album", "Year made", "Genre");
        result += "\n ----------------------------------------------------------------------------------------------------------";
        for(Song i: list){
            result+= "\n" + i.toString();
        }
        return result;
    }

    public String toStringGenre(){
        String result = String.format("%-30s %-20s %-29s %-11s %-10s", "Song Name", "Artist" , "Album", "Year made", "Genre");
        result += "\n ----------------------------------------------------------------------------------------------------------";
        for(Song i: genreList){
            result+= "\n" + i.toString();
        }
        if(genreList.size() == 0){
            return "No Songs found with Genre Given";
        }
        return result;
    }

    public void sortRecent(){
        for(int i = 1; i < list.size(); i++){
            Song tempVal = list.get(i);
            int position = i;
            while(position > 0 && list.get(position - 1).getYear() < tempVal.getYear()){
                list.set(position, list.get(position - 1));
                position--;
            }
            list.set(position, tempVal);
        }
    }

    public void sortOldest(){
        for(int i = 1; i < list.size(); i++){
            Song tempVal = list.get(i);
            int position = i;
            while(position > 0 && list.get(position - 1).getYear() > tempVal.getYear()){
                list.set(position, list.get(position - 1));
                position--;
            }
            list.set(position, tempVal);
        }
    }

    public void sortGenre(String givenGenre) {
        genreList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getGenre().equalsIgnoreCase(givenGenre)){
                genreList.add(list.get(i));
            }
        }
    }

    public void sortAl(){
        for(int i = 0; i < list.size() - 1; i++){
            int index = i;

            for(int j = i + 1; j < list.size(); j++){
                if((list.get(j).getCreator().compareToIgnoreCase(list.get(index).getCreator())) < 0){
                    index = j;
                }
            }

            if(!(list.get(i).getCreator().substring(0,1).equals(list.get(index).getCreator().substring(0,1)))){
                Song temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
            }
        }
    }

    public void sortRevAl(){
        for(int i = 0; i < list.size() - 1; i++){
            int index = i;

            for(int j = i + 1; j < list.size(); j++){
                if((list.get(j).getCreator().compareToIgnoreCase(list.get(index).getCreator())) > 0){
                    index = j;
                }
            }

            if(!(list.get(i).getCreator().substring(0,1).equals(list.get(index).getCreator().substring(0,1)))){
                Song temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
            }
        }
    }
}
