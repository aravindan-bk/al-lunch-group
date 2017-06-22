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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthulas on 6/22/17.
 */
public class FileUtil {

    private final String outputFolderUri;


    public FileUtil(String outputFolderUri) {
        this.outputFolderUri = outputFolderUri;
    }

    public List<String> loadFile(String fileUri){

        List<String> linesInFile = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(fileUri)))) {
            for(String line; (line = br.readLine()) != null; ) {
                linesInFile.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A Valid file Not found in: " + fileUri);
            System.out.println("Please check the file location and restart");
        } catch (IOException e) {
            System.out.println("Problem encountered while reading: " + fileUri);
            System.out.println("Please check if the file has correct content and restart");
        }

        return linesInFile;
    }


    public void printFileContent(String fileUri){
        List<String> linesInFile = loadFile(fileUri);

        for(String line : linesInFile){
            System.out.println(line);
        }
    }


    public void writeGroupDistributionToFile(List<List<String>> groupList, String fileName){



        try {
            FileWriter fw = new FileWriter(outputFolderUri+"/"+fileName+"_"+System.currentTimeMillis());
            int groupCounter = 0;
            for(List<String> eachGroup : groupList){
                groupCounter++;
                fw.write("======================"+System.lineSeparator());

                fw.write("GROUP: " + groupCounter+System.lineSeparator());
                fw.write("======================"+System.lineSeparator());
                for(String member : eachGroup){
                    fw.write(member);
                    fw.write(System.lineSeparator());
                }
            }

            fw.close();
        } catch (IOException e) {
            System.out.println("Issue writing file to Location: " + outputFolderUri);
            System.out.println("Please check if the location is valid and try again");
        }


    }
}
