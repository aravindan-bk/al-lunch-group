package com.al;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by arthulas on 6/22/17.
 */
public class Driver {


    public static void main(String[] args){


        if(args.length < 1){
            System.out.println("Please call the jar as: java -jar <LOCATION_OF_JAR_FILE>/lunch-group-selector-1.0-SNAPSHOT.jar  <URI OF PROPERTY FILE>");
        }
        String propertyFileUri = args[0];
        Properties prop = loadProperties(propertyFileUri);
        String fileUri = prop.getProperty("employee.list.file");
        String outputLocation = prop.getProperty("group.file.output.folder");

        System.out.println(fileUri);

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

    private static Properties loadProperties(String propertyFileUri) {
        InputStream input = null;
        Properties prop = new Properties();
        try {

            input = new FileInputStream(new File(propertyFileUri));
            prop.load(input);

        } catch (IOException ex) {
            System.out.println("Couldn't load properties file. Exiting....");
            System.exit(0);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close properties file. Exiting....");
                    System.exit(0);
                }
            }
        }

        return prop;
    }


}

