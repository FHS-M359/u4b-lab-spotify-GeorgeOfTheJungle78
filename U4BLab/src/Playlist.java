import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> list;
    private ArrayList <Song> genreList;

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

    public void sortEarly(){
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

    public void sortLater(){
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
