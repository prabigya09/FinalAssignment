

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//F1://

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
            if (readUnitName) {
                unitName = line;
                readUnitName = false;
                
            } else {
                
                // this line confirms that data line includes all expected fields (lastName,firstname, studentID, and 3 assignments score)//
                String[] parts = line.split("\t");
                if (parts.length == 6) {
                    String lastName = parts[0].trim();
                    String firstName = parts[0].trim();
                    String studentID = parts[0].trim();
                    double assignment1 = Double.parseDouble(parts[3].trim());
                    double assignment2 = Double.parseDouble(parts[4].trim());
                    double assignment3 = Double.parseDouble(parts[5].trim());
                    
                    
                    Student student = new Student(lastName, firstName, studentID, assignment1, assignment2, assignment3);
                    students.add(student);
                }
                }

                }
                } catch (IOException e) {
                    System.err.println("Error reading from the file: " + e.getMessage());
                    
                }
            
                
        }
        
        //F2//
    }

  
  
  

