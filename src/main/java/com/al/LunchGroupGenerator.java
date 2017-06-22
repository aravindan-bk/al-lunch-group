package com.al;

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

            /**
             * We make the best effort to distribute the groups into 5, to minimize table usage.
             * When the group size gets around 8 we start being cautious to not leave anybody out as well as get the minimum
             * number of groups possible.
             */
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
