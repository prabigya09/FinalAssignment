



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class studentAssignmentResult
{
  private String unitName;
  private List<Student> students = new ArrayList<>();
  
 
  //F1//
  
public void readDataFromFile( String fileName) {
    try(BufferedReader reader = new BufferedReader(new FileReader(Data.txt))) {
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
            
        //Menu//
         
        
           
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while(running) {
                System.out.println("\nMenu:");
                System.out.println("A. Total Marks:");
                System.out.println("B. Total marks less than a certain threshold:  ");
                System.out.println("C. Print top and bottom students: ");
                System.out.println("D. Exist");
                System.out.println("E. Your Choice:");
                
                int choice = scanner.nextInt();
                
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        {
                            System.out.println("Name of Students in the list, studentID, assignment marks and total marks: ");
                            for (Student student : students) {
                            double totalMark = student.calculateTotalMarks();
                            System.out.println(student + "\tTotal Mark: " + totalMark);
                            }
                          break;
                        }
                  case 2:{
                    System.out.println("Enter the threshold.");
                    double threshold = scanner.nextInt();
                    System.out.println(" Students  total Marks" + threshold + ":");
                    for (Student student : students) {
                    double totalMark = student.calculateTotalMarks();
                    if(totalMark < threshold) {
                    System.out.println(student + "\tTotal Mark: " + totalMark);
                    }
                    }
                    break;
                  }
                  case 3:
                    {
                    System.out.println("Enter the number of top and bottom student:");
                                int count = scanner.nextInt();
                                students.sort((s1, s2) -> Double.compare(s2.calculateTotalMarks(), s1.calculateTotalMarks()));
            System.out.println("Top" + count + " students:");
             for (int i = 0; i < count && i < students.size(); i++) {
                 System.out.println(students.get(i));
             }
             System.out.println("\nButtom" + count + " students: ");
             for (int i = students.size() - 1; i >= students.size() -count && i >= 0; i--) {
                 System.out.println(students.get(i));
                 
             }
                                break;
                    }
                  case 4:{
                                
                                    running = false;}
                                    break;
                default:
                                        System.out.println("Invalid:");
                                
                            }
        }
                       
                                        
                                
                                
                    
                        
                }
            }
    
                
            
        
        
    
    
    class Student {
        private String lastName;
        private String firstName;
        private String studentID;
        private double assignment1;
        private double assignment2;
        private double assignment3;
        
        public Student(String lastName, String firstName, String studentID, double assignment1, double assignment2, double assignment3) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.studentID = studentID;
            this.assignment1 = assignment1;
            this.assignment2 = assignment2;
            this.assignment3 = assignment3;
        }
        
        public double calculateTotalMarks() {
            return assignment1 + assignment2 + assignment3;
        }
        
        public String toString() {
            return lastName + "\t" + firstName + "\t" + studentID + "\t" + assignment1 + "\t" + assignment2 + "\t" +assignment3;
            
        }
        
    }
        
        
    

  
  
  

