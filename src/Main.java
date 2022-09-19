import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
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

            boolean created = file1.createNewFile();

            // Creating a Scanner object to take input from user from the console
            Scanner input = new Scanner(System.in);

            System.out.print("> ");
            String writer = input.nextLine();

            // Creating a FileWriter object to write content into the file

            FileWriter writtenFile = new FileWriter("file1.txt");
            writtenFile.write(writer);
            writtenFile.close();

            // Creating a FileReader object and file to read data from
            FileReader readerFile = new FileReader("file1.txt");

            // Creating a FileWriter object and file where the reverse of the file read will
            // be inserted
            // It will create a new file called file2.txt

            FileWriter file2 = new FileWriter("file2.txt");

            // Declaring a blank string in which the whole content will be stored

            String storedData = "";

            // initializse variable for while loop to read through the file using the read()
            // method
            int i;

            // Reading the file using read() method which returns -1 at EOF(end of file)
            // while reading

            while ((i = readerFile.read()) != -1) {
                storedData += (char) i;
            }
            // Converting string to arrays of character
            char[] storedArray = storedData.toCharArray();

            String reverse = "";

            // Using for loop to iterate over the storedArray

            for (int j = storedArray.length - 1; j >= 0; j--) {
                reverse = reverse + storedArray[j];
            }

            // Writing above string data to the FileWriter Object

            file2.write(reverse);
            file2.close();
            readerFile.close();

            /*
             * A FileInputStream obtains input bytes from a file in a file system
             */
            // Using FileInputStream using to compare byte by byte
            FileInputStream comparedFile1 = new FileInputStream("file1.txt");
            FileInputStream comparedFile2 = new FileInputStream("file2.txt");

            // initializing two integer to represent each character

            int readFile1 = 0;
            int readFile2 = 0;
            // while loop to loop through the file
            // Condition both files have not reach the last character
            while (readFile1 != -1 && readFile2 != -1) {
                // the both files are allowed to scan through the document
                readFile1 = comparedFile1.read();
                readFile2 = comparedFile2.read();

                if (readFile1 != readFile2) {
                    break;
                }

            }

            // Displaying the content of the first file on the console
            System.out.println(storedData);

            // Creating a FileWriter object and file where the reverse of the file read will
            // be inserted
            // It will create a new file called file2.txt

            // Scanner class to collect input for the file editing
            Scanner word_replace = new Scanner(System.in);

            // Asking the user the starting point
            System.out.print("Starting positiion: ");
            // collecting the input as a string then converting it to an integer value for
            // the starting point
            int start = Integer.parseInt(word_replace.nextLine());

            // Asking the user the ending point
            System.out.print("Ending positiion: ");
            // collecting the input as a string then converting it to an integer value for
            // the ending position
            int end = Integer.parseInt(word_replace.nextLine());

            // Asking the user to input the new word
            System.out.print("Word to replace: ");
            // using the scanner class to collect the new word
            String word_to_replace = word_replace.nextLine();

            // Using StringBuffer to create a mutable string or a clone of the data in first
            // file so that it can be edited
            StringBuffer replace = new StringBuffer(storedData);

            // Using the replace function to replace the data in the given position
            // collected by the user
            replace.replace(start, end, word_to_replace);
            // Storing the content of the new file in a Strng using the toString()
            String newFileContent = replace.toString();

            // Using the FileWriter Object write the new word
            FileWriter edited_file1 = new FileWriter("file1.txt");
            // writing the word in file1.txt
            edited_file1.write(newFileContent);
            // closing the file
            edited_file1.close();
            // covert java.txt to bytes
            File bytesFile = new File("ByteConversion.txt");
            PrintWriter pwriter = new PrintWriter(bytesFile);
            byte[] substrings = newFileContent.getBytes();
            byte[] rs = substrings;
            pwriter.println(Arrays.toString(rs));
            pwriter.close();

        } catch (Exception e) {
            // If there is no file in specified path or
            // any other error occurred during runtime

            // Display message
            e.getStackTrace();
        }

    }
}