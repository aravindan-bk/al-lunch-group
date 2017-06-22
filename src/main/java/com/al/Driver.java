package com.al;

import java.util.*;

/**
 * Created by arthulas on 6/22/17.
 */
public class Driver {


    public static void main(String[] args){


        String fileUri = "/Users/arthulas/Desktop/employees.txt";
        String outputLocation = "/Users/arthulas/Desktop";


        FileUtil fileUtil = new FileUtil(outputLocation);

        while(true){
            System.out.println("What do you want to do?");
            System.out.println("1. View Employee List");
            System.out.println("2. Generate Lunch Group");
            System.out.println("3. Exit Program");
            Scanner reader = new Scanner(System.in);  // Reading from System.in

            int option = reader.nextInt();

            switch(option){
                case 1:
                    fileUtil.printFileContent(fileUri);
                    break;
                case 2:
                    List<String> employeeList = fileUtil.loadFile(fileUri);
                    new LunchGroupGenerator(employeeList,fileUtil).generateLunchGroup();
                    break;
                case 3:
                    System.out.println("Thank You for using the system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;

            }
        }





    }
    

}
