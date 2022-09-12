import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        // PROBLEM STATEMENT
        /*
         * Write a program in Java which should create a file and data in it. Once the
         * data added in the file, other file
         * must be created which should display the reverse of the data present in it.
         * Next it must compare the data of
         * the both the file and must check whether the content are same or not. The
         * data of the first file must be
         * display on the console screen and then it must extract the word and replace
         * it with other. The position and
         * data to be altered must be asked by the user. Once the data is replaced the
         * content of the file must be
         * changed and last the data of the first file must be converted in to byte
         * codes.
         */

        // Try block to check for exceptions
        try {
            // Creating a File object to create a file 
            File file1 = new File("file1.txt");
            // Boolean variable to check if the file has been created 

            boolean created  = file1.createNewFile();

            // Creating a Scanner object to take input from user from the console
            Scanner input = new Scanner(System.in);

            String writer = input.nextLine();

            // Creating a FileWriter object 




            // Creating a FileWriter object and file where the reverse of the file read will
            // be inserted
            // It will create a new file called file2.txt

           

        } catch (Exception e) {
            // If there is no file in specified path or
            // any other error occurred during runtime

            // Display message
            e.getStackTrace();
        }

    }
}