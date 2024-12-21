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

        return rows;
    }

    public void InputParse(){
        List<String> rows = ReadFiles();
        List<String> allEquations = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            String multiplicationString = "";
            String result = ReadFiles().get(i).replace("\n", "").replace("\r", "") + " ";
            for (int j = 0; j < result.length(); j++){
                try {
                    if (result.substring(j, j + 4).equalsIgnoreCase("mul(")) {
                        // check all chars until comma ")"
                        for (int k = j + 4; k < result.length(); k++){
                            if (!result.substring(k, k+1).equalsIgnoreCase(")")){
                                multiplicationString = multiplicationString + "" + result.charAt(k);
                            } else {
                                break;
                            }
                        }
                        allEquations.add(multiplicationString);
//                        System.out.println(multiplicationString);
                        multiplicationString = "";

                    }
                } catch (Exception OutOfBoundsException){

                }
            }

        }
        System.out.println(allEquations);

        int total = 0;
        int firstNumberInt = 0;
        int secondNumberInt = 0;
        for (int i = 0; i < allEquations.size(); i++) {
            String firstNumber = "";
            String secondNumber = "";
            for (int j = 0; j < allEquations.get(i).length(); j++) {
                if (!allEquations.get(i).substring(j, j + 1).equalsIgnoreCase(",")) {
                    firstNumber = firstNumber + allEquations.get(i).substring(j, j + 1);
                } else {
                    // firstNumber is completed, now construct secondNumber

                    for (int k = j+1; k < allEquations.get(i).length(); k++) {
                        if (!allEquations.get(i).substring(k, k + 1).equalsIgnoreCase(")") &&
                        (!allEquations.get(i).substring(k, k + 1).equalsIgnoreCase("(")) &&
                        (!allEquations.get(i).substring(k, k + 1).equalsIgnoreCase("m"))) {
                            secondNumber = secondNumber + allEquations.get(i).substring(k, k + 1);
//                            System.out.println("strings: " + firstNumber + " x " + secondNumber + " = " + (firstNumberInt*secondNumberInt));

                        } else {
                            if (!allEquations.get(i).substring(k, k + 1).contains(" ")){
                                break;
                            } else {
                                System.out.println("Clearing " + firstNumber + " and " + secondNumber);
                                firstNumber = "";
                                secondNumber = "";
                                break;
                            }

                        }
                    }
                }

            }
            // multiply and add to total
            try {

                firstNumber = firstNumber.replace(secondNumber, "");
                firstNumberInt = Integer.parseInt(firstNumber);
                secondNumberInt = Integer.parseInt(secondNumber);
                total = total + (firstNumberInt * secondNumberInt);
                System.out.println("int: " + firstNumber + " x " + secondNumber + " = " + (firstNumberInt*secondNumberInt));
            } catch (Exception NotANumber){
                System.out.println(firstNumber + " and " + secondNumber + "  cannot be multiplied");
            }



        }
        System.out.println("Total: " + total);

//        427 * 266 = 113582
//        287 * 390 = 111930
//        398 * 319 = 126962
//        613 * 600 = 367800
//        5 * 441   = 2205
//        122 * 41  = 5002
//                    727481
    }

}
