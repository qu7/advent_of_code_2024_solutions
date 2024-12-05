import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dec_3_Challenge {

    File input;

    public List<String> ReadFiles() {
        List<String> rows = new ArrayList<String>();
        try {
            input = new File("src/files/day_3_input.txt");
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
        String result = ReadFiles().get(0).replace("\n", "").replace("\r", "");
        System.out.println(result);
        List<String> listOfEquations = new ArrayList<>();
        String setOne = "";
        String setTwo = "";
        int resultLength = result.length()-4;
        for (int i = 0; i < resultLength; i++){
            String currentChar = result.substring(i, i+4).toLowerCase();
            if (currentChar.contains("mul(")){
                try {
                    for (int j = 1; j < 20; j++) {
                        if (!result.substring(i + j).contentEquals(",")) {
                            setOne = setOne + result.substring(i + j);
                            System.out.println(setOne);
                        } else {
                            setOne = "";
                        }
                    }
                } catch (Exception outOfBounds){

                }
            }
            currentChar = "";
        }

    }

}
