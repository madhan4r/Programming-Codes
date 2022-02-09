// Importing File class  
import java.io.File;
// Importing the FileWriter class  
import java.io.FileWriter;
// Importing the IOException class for handling errors  
import java.io.IOException;
// Importing the Scanner class
import java.io.BufferedReader;
import java.io.FileReader;

class CreateFile {
    static void fileCreation(String file_location) {
        try {
            // Creating a file in the specified location
            File file = new File(file_location);
            if (file.createNewFile()) {
                System.out.println("File " + file.getName() + " is created successfully.");
            } else {
                System.out.println("File is already exist in the directory.");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    static void fileWriting(String file_location, String content) {
        try {
            // Creating an object of a file
            File f1 = new File(file_location);
            // Creating a FileWriter object
            FileWriter fw = new FileWriter(f1, true);
            // Writing the content to the file
            fw.write(content);
            // Closing the file
            fw.close();
            System.out.println("File written successfully\n");
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    static void fileReading(String file_location) {
        try {
            // Creating an object of a file
            File f1 = new File(file_location);
            // Creating a FileReader object
            FileReader fr = new FileReader(f1);
            // Creating a BufferedReader object
            BufferedReader br = new BufferedReader(fr);
            // Reading the content of the file
            String line = br.readLine();
            System.out.println("The content of the file is:");
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            // Closing the file
            br.close();
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    static void fileCopy(String old_location, String new_location) {
        try {
            // Creating an object of a file
            File f1 = new File(old_location);
            // Creating an object of a file
            File f2 = new File(new_location);
            // Creating a FileReader object
            FileReader fr = new FileReader(f1);
            // Creating a BufferedReader object
            BufferedReader br = new BufferedReader(fr);
            // Creating a FileWriter object
            FileWriter fw = new FileWriter(f2);
            // Reading the content of the file
            String line = br.readLine();
            while (line != null) {
                fw.write(line);
                line = br.readLine();
            }
            System.out.println("\nThe file copied to new path: " + new_location);
            // Closing the file
            br.close();
            fw.close();
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    static void fileSeek(String file_location, String content) {
        try {
            // Creating an object of a file
            File f1 = new File(file_location);
            // Creating a FileReader object
            FileReader fr = new FileReader(f1);
            // Creating a BufferedReader object
            BufferedReader br = new BufferedReader(fr);
            // Reading the content of the file
            String line = br.readLine();
            Boolean match = false;
            while (line != null) {
                if (line.contains(content)) {
                    System.out.println("\nword match found!! Printing the line below\n" + line);
                    match = true;
                }
                line = br.readLine();
            }
            if (!match) {
                System.out.println("\nword not found!!!\n");
            }
            // Closing the file
            br.close();
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    static void fileDelete(String file_location) {
        try {
            // Creating an object of a file
            File f1 = new File(file_location);
            // Deleting the file
            f1.delete();
            System.out.println("\nFile deleted successfully");
        } catch (Exception exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    public static void main(String args[]) {
        String file_location = "C:/Users/User/Local_Files/FileOperationExample.txt";
        // Creating a file
        fileCreation(file_location);
        // Pass the content and location to write
        String content = "Sample Text line 1 \nSample Text line 2\nSample Text line 3";
        fileWriting(file_location, content);
        // Reading the file
        fileReading(file_location);
        // Copy the content and write into another file
        String new_file_location = "C:/Users/User/Local_Files/FileOperationExample1.txt";
        fileCopy(file_location, new_file_location);
        // Seek a word inside file
        fileSeek(file_location, "line 2");
        // delete a file if wanted for now i have commented it
        // fileDelete(file_location);
    }
}