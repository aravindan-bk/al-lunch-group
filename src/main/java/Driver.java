/*************************************************************************
 * ORACLE CONFIDENTIAL
 * __________________
 * <p/>
 * [2014] - [2016] Oracle Incorporated
 * All Rights Reserved.
 * <p/>
 * NOTICE:  All information contained herein is, and remains
 * the property of Oracle Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Oracle Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Oracle Incorporated.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

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
