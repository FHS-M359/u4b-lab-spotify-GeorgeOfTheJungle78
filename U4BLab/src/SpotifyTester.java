import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.security.PublicKey;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class SpotifyTester {
    public static void main(String[] args) throws IOException {
        Playlist songs = new Playlist("spotify_unique_years_artists.txt");

        Scanner scan = new Scanner(System.in);
        int choice = callMenu(scan);

        choiceLoop(choice, songs, scan);
    }
    //calls in the menu and makes sure the user inputs correctly
    public static int callMenu(Scanner scan){
        boolean wrong = true;
        int choice = 0;
        while(wrong){
            try {
                System.out.println("=======Playlist=======");
                System.out.println("1. Sort Alphabetically");
                System.out.println("2. Sort Reverse Alphabetically");
                System.out.println("3. Sort by Year (Oldest first)");
                System.out.println("4. Sort by Year (Latest first)");
                System.out.println("5. Sort by Genre");
                System.out.println("6. Print");
                System.out.println("7. Quit");
                System.out.println("\nPlease Pick a number from (1-7)");

                choice = scan.nextInt();

                if(choice > 7 || choice < 1){
                    System.out.println("READ THE INSTRUCTIONS AND PICK A NUMBER BETWEEN 1- 7 >:(");
                    scan.nextLine();
                }
                else{
                    wrong = false;
                }
            } catch (InputMismatchException e){
                System.out.println("READ THE INSTRUCTIONS AND PICK A NUMBER BETWEEN 1 - 7 >:(");
                scan.nextLine();
            }
        }
        return choice;
    }
    //calls in the alphabet sorting method for the Playlist and prints it
    public static void callAl(Playlist songs){
        songs.sortAl();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    //calls in the reverse alphabet sorting method for the Playlist and prints it
    public static void callRevAl(Playlist songs){
        songs.sortRevAl();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    //calls in the oldest year sorting method for the Playlist and prints it
    public static void callyearL(Playlist songs){
        songs.sortOldest();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    //calls in the recent year sorting method for the Playlist and prints it
    public static void callyearE(Playlist songs){
        songs.sortRecent();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    //calls in the genre sorting method for the Playlist and prints it
    public static void callGenre(Playlist songs, String genre){
        songs.sortGenre(genre);
        System.out.println(songs.toStringGenre());
        System.out.println();
        System.out.println();
    }
    //prints the list from the Playlist made in the main method
    public static void callList(Playlist songs){
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    //checks if the genre the user put is correct and prompts them to type a genre in
    //sorts the genre inputted and returns it
    public static String getValidGenre(Scanner scan){
        boolean wrong = true;
        String genre = "";
        while(wrong){
            try {
                System.out.println("Type a Genre in");
                scan.nextLine();
                genre = scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("READ THE INSTRUCTIONS AND TYPE A GENRE >:(");
                scan.nextLine();
                scan.nextLine();
            }
            if(genre.length() > 0) {
                wrong = false;
            }
            else{
                System.out.println(" TYPE A GENRE, NOT SPACES >:(");
            }
        }
        return genre;
    }
    //loops the menu prompts until the user quits
    public static void choiceLoop(int choice, Playlist songs, Scanner scan){
        final int end = 7;
        final int al = 1;
        final int revAl = 2;
        final int old = 3;
        final int recent = 4;
        final int genreInt = 5;
        final int print = 6;
        while(choice != end){
            if(choice == al){
                callAl(songs);
                choice = callMenu(scan);
            }
            if(choice == revAl){
                callRevAl(songs);
                choice = callMenu(scan);
            }
            if(choice == old){
                callyearL(songs);
                choice = callMenu(scan);
            }
            if(choice == recent){
                callyearE(songs);
                choice = callMenu(scan);
            }
            if(choice == genreInt){
                String genre = getValidGenre(scan);
                callGenre(songs, genre);
                choice = callMenu(scan);
            }
            if(choice == print){
                callList(songs);
                choice = callMenu(scan);
            }
        }

        if(choice == end){
            System.exit(0);
            scan.close();
        }
    }

}

