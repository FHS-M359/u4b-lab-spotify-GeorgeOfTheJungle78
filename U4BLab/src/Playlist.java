import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> list;

    public Playlist(ArrayList<Song> list){
        this.list = list;
    }

    public String toString(){
        String result = String.format("%-30s %-20s %-29s %-11s %-10s", "Song Name", "Artist" , "Album", "Year made", "Genre");
        result += "\n ----------------------------------------------------------------------------------------------------------";
        for(Song i: list){
            result+= "\n" + i.toString();
        }
        return result;
    }

//    public String toString(ArrayList<Song> list){
//        String result = String.format("-20s -15s -10s -10s -10s", "Song Name", "Artist" , "Album", "Year made", "Genre");
//        result += "\n ----------------------------------------------------------------------------------------");
//        for(Song i: list){
//            result+= "\n" + i.toString();
//        }
//        return result;
//    }
//
//    public ArrayList<Song> sortYear(){
//        ArrayList<Song> sorted = new ArrayList<>();
//        ArrayList<Song> copy = list;
//        for(int i = copy.size() - 1; i >= 0; i--){
//            for(int j = copy.size() - 1; j >= 0; i--){
//                if(copy.get(i).getYear() < copy.get(j).getYear()){
//                    break;
//                }
//                else if(j == 0){
//                    sorted.add(copy.get(i));
//                }
//            }
//        }
//    }
}
