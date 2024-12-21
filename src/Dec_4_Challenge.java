import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dec_4_Challenge {

    File input;

    public List<String> ReadFiles() {
        List<String> rows = new ArrayList<String>();
        try {
            input = new File("src/files/day_4_input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                rows.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> row = new ArrayList<String>();

        return rows;
    }

    public void InputParse(){
        List<String> wordJumble = ReadFiles();
        int counter = 0;

        // check forward and backwards
        String xmas = "XMAS";
        String samx = "SAMX";
        for (int i = 0; i < wordJumble.size(); i++) {
            for (int j = 0; j < wordJumble.get(i).length(); j++){
                try {
                    if (wordJumble.get(i).substring(j, j + 4).contains(xmas) || wordJumble.get(i).substring(j, j + 4).contains(samx)) {
                        counter++;
                    }
                } catch (Exception outOfBounds){

                }
            }
        }
        System.out.println("counter: " + counter);


        // refactor input columns to rows
        List<String> wordJumbleRefactored = ReadFiles();
        String currentRow = "";

//        for (int i = 0; i < wordJumble.size(); i++){
//            for (int j = 0; j < wordJumble.get(i).length(); j++) {
//                currentRow = currentRow + "" + wordJumble.get(j).substring(i, i+1);
//            }
//            wordJumbleRefactored.add(currentRow);
//            currentRow = "";
//        }
//
//        for (int i = 0; i < wordJumbleRefactored.size(); i++) {
//            for (int j = 0; j < wordJumbleRefactored.get(i).length(); j++){
//                try {
//                    if (wordJumbleRefactored.get(i).substring(j, j+4).contains(xmas) || wordJumbleRefactored.get(i).substring(j,j+4).contains(samx)){
//                        counter ++;
//                    }
//                } catch (Exception outOfBounds){
//
//                }
//            }
//        }
//        System.out.println("counter: " + counter);


        for (int i = 0; i < wordJumble.size(); i++) {
            for (int j = 0; j < wordJumble.get(i).length(); j++){
                // check diagonals
                if (wordJumble.get(i).substring(j, j+1).equalsIgnoreCase("X")) {
                    try {
                        // northwest
                            if (wordJumble.get(i - 1).substring(j - 1, j).equalsIgnoreCase("M")
                            && wordJumble.get(i - 2).substring(j - 2, j-1).equalsIgnoreCase("A")
                            && wordJumble.get(i - 3).substring(j - 3, j - 2).equalsIgnoreCase("S")){
                                counter++;
                            }
                    } catch (Exception outOfBoundsException){

                    }
                    try {
                        if (wordJumble.get(i - 1).substring(j + 1, j+2).equalsIgnoreCase("M")
                                && wordJumble.get(i - 2).substring(j + 2, j+3).equalsIgnoreCase("A")
                                && wordJumble.get(i - 3).substring(j +3, j+4).equalsIgnoreCase("S")){
                            counter++;
                        }
                    } catch (Exception outOfBoundsException){

                    }
                    try {
                        if (wordJumble.get(i + 1).substring(j - 1, j).equalsIgnoreCase("M")
                                && wordJumble.get(i + 2).substring(j - 2, j - 1).equalsIgnoreCase("A")
                                && wordJumble.get(i + 3).substring(j - 3, j - 2).equalsIgnoreCase("S")){
                            counter++;
                        }
                    } catch (Exception outOfBoundsException){

                    }
                    try {
                        if (wordJumble.get(i + 1).substring(j+ 1, j + 2).equalsIgnoreCase( "M")
                                && wordJumble.get(i + 2).substring(j + 2, j + 3).equalsIgnoreCase("A")
                                && wordJumble.get(i + 3).substring(j + 3, j + 4).equalsIgnoreCase("S")){
                            counter++;
                        }
                    } catch (Exception outOfBoundsException){

                    }
                    try {
                        if (wordJumble.get(i + 1).substring(j, j + 1).equalsIgnoreCase( "M")
                                && wordJumble.get(i + 2).substring(j, j + 1).equalsIgnoreCase("A")
                                && wordJumble.get(i + 3).substring(j, j + 1).equalsIgnoreCase("S")){
                            counter++;
                        }
                    } catch (Exception outOfBoundsException){

                    }
                    try {
                        if (wordJumble.get(i - 1).substring(j, j + 1).equalsIgnoreCase( "M")
                                && wordJumble.get(i - 2).substring(j, j + 1).equalsIgnoreCase("A")
                                && wordJumble.get(i - 3).substring(j, j + 1).equalsIgnoreCase("S")){
                            counter++;
                        }
                    } catch (Exception outOfBoundsException){

                    }

                }
            }
        }

        System.out.println("counter: " + counter);
    }

}
