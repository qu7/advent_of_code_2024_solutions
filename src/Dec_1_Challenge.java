import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dec_1_Challenge {

    File input;

    public List<String> ReadFiles() {
        List<String> rows = new ArrayList<String>();
        try {
            input = new File("src/files/day_1_input.txt");
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

    public void organizeColumns(){
        // sort the columns from smallest to largest
        List<String> rows = ReadFiles();
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();
        for (int i = 0; i < rows.size(); i++){
            if (rows.get(i).substring(5, 7).contains("  ")){
                int intValueOfLeft = Integer.parseInt(rows.get(i).substring(0, 5));
                leftList.add(intValueOfLeft);
                int intValueOfRight = Integer.parseInt(rows.get(i).substring(8, 13));
                rightList.add(intValueOfRight);
            }
        }

        //organize rows
        Collections.sort(leftList);
        Collections.sort(rightList);
//        System.out.println("L: " + leftList);
//        System.out.println("R: " + rightList);

        int distanceCalc = 0;

        for (int i = 0; i < leftList.size(); i++){
            if (leftList.get(i) > rightList.get(i)) {
                distanceCalc = distanceCalc + (leftList.get(i) - rightList.get(i));
            } else {
                distanceCalc = distanceCalc + (rightList.get(i) - leftList.get(i));
            }
        }

        List<Integer> currentIntegerInRightList = new ArrayList<Integer>();
        int currentAddition = 0;
        int similarityScore = 0;

        // compare the left column with how many times the number appears in the right column
        for (int i = 0; i < leftList.size(); i++) {
            for (int j = 0; j < rightList.size(); j++) {
                if (leftList.get(i).equals(rightList.get(j)) ) {
                    currentIntegerInRightList.add(leftList.get(i));
                }
            }
            if (currentIntegerInRightList.size() == 0) {
                currentAddition = 0;
                currentIntegerInRightList = new ArrayList<Integer>();
            } else {
                currentAddition = currentAddition + currentIntegerInRightList.get(0) * currentIntegerInRightList.size();
                similarityScore = similarityScore + currentAddition;
//                System.out.println(currentIntegerInRightList.get(0) + " time " + currentIntegerInRightList.size() + " = " + currentAddition);
                currentAddition = 0;
                currentIntegerInRightList = new ArrayList<Integer>();

            }
        }
        System.out.println("Distance Calc: " + distanceCalc);
        System.out.println("Similarity score: " + similarityScore);
    }

}
