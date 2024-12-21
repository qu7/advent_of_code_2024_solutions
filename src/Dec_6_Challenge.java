import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dec_6_Challenge {

    File input;

    public List<String> ReadFiles() {
        List<String> rows = new ArrayList<String>();
        try {
            input = new File("src/files/day_6_inputfake.txt");
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

    public void InputParse() {
        List<String> rows = ReadFiles();
        for (int i = 0; i < rows.size(); i++){
            String row = rows.get(i).replace("\n", "").replace("\r", "");
            String leftChar = "<";
            String rightChar = ">";
            String upChar = "^";
            String downChar = "V";
            for (int j = 0; j < row.length(); j ++){
                if (row.substring(j, j+1).equalsIgnoreCase(leftChar)){

                }
            }
        }

    }
}
