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

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by arthulas on 6/22/17.
 */
public class LunchGroupGenerator {

    private List<String> employeeList;
    private FileUtil fileUtil;


    public LunchGroupGenerator(List<String> employeeList, FileUtil fileUtil) {
        this.employeeList = employeeList;
        this.fileUtil = fileUtil;
    }

    public void generateLunchGroup() {
        int size = employeeList.size();
        String[] randomizedList = new String[size];

        Random random = new Random();
        int counter = 0;
        for(int i = size ; i > 0 ; i--){
            int number = random.nextInt(i);
            randomizedList[counter++] = employeeList.remove(number);
        }


        int sizeCounter=size;
        int progressCounter = 0;
        int modCounter=0;
        int groupSize = 5;
        List<List<String>> groupList = new LinkedList<>();
        List<String> currentGroup = new LinkedList<>();
        while(sizeCounter > 0){

            if(sizeCounter==8 || sizeCounter == 7 || sizeCounter == 6 || sizeCounter == 3){
                groupSize = 3;
            }

            if(sizeCounter == 4 || sizeCounter ==5){
                break;
            }

            currentGroup.add(randomizedList[progressCounter++]);
            sizeCounter--;
            modCounter++;

            if(modCounter%groupSize == 0){
                groupList.add(currentGroup);
                currentGroup = new LinkedList<>();
                modCounter=0;


            }

        }

        while(progressCounter < size){
            currentGroup.add(randomizedList[progressCounter++]);
        }
        groupList.add(currentGroup);


        fileUtil.writeGroupDistributionToFile(groupList,"group_List");


    }
}
