import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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


        //  Try block to check for exceptions
        try{
            // Creating a FileReader object and file to read data from
            FileReader file1 =  new FileReader("file1.txt");

            // Creating a FileWriter object and file where the reverse of FileReader will be put 

        }catch(IOException e){
            
        }
         
    }
}