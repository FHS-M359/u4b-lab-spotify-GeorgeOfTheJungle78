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

    public String toString(ArrayList<Song> list){
        String result = String.format("%-30s %-20s %-29s %-11s %-10s", "Song Name", "Artist" , "Album", "Year made", "Genre");
        result += "\n ----------------------------------------------------------------------------------------------------------";
        for(Song i: list){
            result+= "\n" + i.toString();
        }
        if(list.size() == 0){
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

    public ArrayList<Song> sortGenre(String givenGenre) {
        ArrayList<Song> sorted = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getGenre().equalsIgnoreCase(givenGenre)){
                sorted.add(list.get(i));
            }
        }
        return sorted;
    }

    public ArrayList<Song> sortAl(){
        ArrayList<Song> copy = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            copy.add(list.get(i));
        }

        for(int i = 0; i < copy.size() - 1; i++){
            int index = i;

            for(int j = i + 1; j < copy.size(); j++){
                if((copy.get(j).getCreator().compareToIgnoreCase(copy.get(index).getCreator())) < 0){
                    index = j;
                }
            }

            if(!(copy.get(i).getCreator().substring(0,1).equals(copy.get(index).getCreator().substring(0,1)))){
                Song temp = copy.get(i);
                copy.set(i, copy.get(index));
                copy.set(index, temp);
            }
        }
        return copy;
    }

    public ArrayList<Song> sortRevAl(){
        ArrayList<Song> copy = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            copy.add(list.get(i));
        }

        for(int i = 0; i < copy.size() - 1; i++){
            int index = i;

            for(int j = i + 1; j < copy.size(); j++){
                if((copy.get(j).getCreator().compareToIgnoreCase(copy.get(index).getCreator())) > 0){
                    index = j;
                }
            }

            if(!(copy.get(i).getCreator().substring(0,1).equals(copy.get(index).getCreator().substring(0,1)))){
                Song temp = copy.get(i);
                copy.set(i, copy.get(index));
                copy.set(index, temp);
            }
        }
        return copy;
    }
}
