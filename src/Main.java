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

        // Try block to check for exceptions
        try {
            // Creating a FileReader object and file to read data from
            FileReader file1 = new FileReader("file1.txt");

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

            while ((i = file1.read()) != -1) {
                storedData += (char) i;
            }
            // Converting string to arrays of character

            char[] storedArray = storedData.toCharArray();

            // Declaring a blank string in which the reversed content will be stored

            String reverse = "";

            // Using for loop to iterate over the storedArray

            for (int j = storedArray.length - 1; j >= 0; j--) {
                reverse = reverse + storedArray[j];
            }

            // Print and display the reverse of the file data
            System.out.println(reverse);

            // Writing above string data to the FileWriter Object

            file2.write(reverse);

            // Closing the file using close() method

            file1.close();
            file2.close();

        } catch (IOException e) {
            // If there is no file in specified path or
            // any other error occurred during runtime
            // then it will print IOException

            // Display message
            System.out.println(
                    "There are some IOException");
        }

    }
}