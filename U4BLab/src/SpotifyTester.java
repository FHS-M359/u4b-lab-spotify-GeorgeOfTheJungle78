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

    public static void callAl(Playlist songs){
        songs.sortAl();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    public static void callRevAl(Playlist songs){
        songs.sortRevAl();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    public static void callyearL(Playlist songs){
        songs.sortOldest();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    public static void callyearE(Playlist songs){
        songs.sortRecent();
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }
    public static void callGenre(Playlist songs, String genre){
        songs.sortGenre(genre);
        System.out.println(songs.toStringGenre());
        System.out.println();
        System.out.println();
    }
    public static void callList(Playlist songs){
        System.out.println(songs);
        System.out.println();
        System.out.println();
    }

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
    public static void choiceLoop(int choice, Playlist songs, Scanner scan){
        while(choice != 7){
            if(choice == 1){
                callAl(songs);
                choice = callMenu(scan);
            }
            if(choice == 2){
                callRevAl(songs);
                choice = callMenu(scan);
            }
            if(choice == 3){
                callyearL(songs);
                choice = callMenu(scan);
            }
            if(choice == 4){
                callyearE(songs);
                choice = callMenu(scan);
            }
            if(choice == 5){
                String genre = getValidGenre(scan);
                callGenre(songs, genre);
                choice = callMenu(scan);
            }
            if(choice == 6){
                callList(songs);
                choice = callMenu(scan);
            }
        }

        if(choice == 7){
            System.exit(0);
            scan.close();
        }
    }

}

