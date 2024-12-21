import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dec_2_Challenge {

    File input;

    public List<String> ReadFiles() {
        List<String> rows = new ArrayList<String>();
        try {
            input = new File("src/files/day_2_input.txt");
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
        int rowCount = 0;
        List<String> rows = ReadFiles();
//        ArrayList<Integer> rowsInt = new ArrayList<>();

        for (int q = 0; q < rows.size(); q++) {
            Scanner scanner = new Scanner(rows.get(q));
            List<Integer> list = new ArrayList<Integer>();
            while (scanner.hasNextInt()) {
                list.add( scanner.nextInt());
            }


            boolean ascending = true;
            boolean addThisRow = true;

            // check each row for ascending or descending values
            for (int i = 0; i < list.size(); i++){
                for (int j = 0; j < list.size() - 1; j++) {
                    if (j != 0 && ascending == true && list.get(j) < list.get(j+1) &&
                            list.get(j) != list.get(j+1) &&
                            (list.get(j+1) - list.get(j) <= 3))
                    {

                    }
                    else if (j == 0){
                        if (list.get(j) < list.get(j+1) &&
                                list.get(j) != list.get(j+1) &&
                                (list.get(j+1) - list.get(j) <= 3)){
                        } else {
                            ascending = false;
                        }
                    }
                    else {
                        ascending = false;

                    }
                }

                if (ascending == false){
                    for (int k = 0; k < list.size() - 1; k++) {
                        if (k != 0 && ascending == false && list.get(k) > list.get(k+1) &&
                                list.get(k) != list.get(k+1) &&
                                (list.get(k) - list.get(k+1) <= 3))
                        {

                        } else if (k == 0) {
                            if (list.get(k) > list.get(k+1) &&
                                    list.get(k) != list.get(k+1) &&
                                    (list.get(k) - list.get(k+1) <= 3))
                            {

                            } else {
                                addThisRow = false;

                            }

                        } else {

                            addThisRow = false;
                        }
                    }

                }



            }
            if (addThisRow == true) {
                rowCount++;
                System.out.println(ascending + " add this row: " + list);
                ascending = true;
                addThisRow = true;
            }
        }

        System.out.println(rowCount);
    }
}
