
/**
 * Write a description of class studentAssignmentResult here.
 *
 * @author (Prabigya)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//F1:
3...........
public class studentAssignmentResult
{
  private String unitName;
  private String firstName;
  private String lastName;
  private int studentID;
  private double[] marks;
  private double totalMark;
  private List<Student> students = new ArrayList<>();
  
public void readDataFromFile( String fileName) {
    try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        boolean readUnitName = true;
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("last name")) {
                continue;
            }
        }
    }
}
  
  
  
}
