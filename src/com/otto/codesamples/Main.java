package com.otto.codesamples;

import java.io.*;
import java.util.*;

public class Main {

    Integer[]array;
    List<Integer> list;
    List<Integer> subList;

    public static void main(String[] args) {
        Main main = new Main();
        main.go();
    }

    public void go(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("C:\\Users\\Asguard\\IdeaProjects\\HomeWork\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int arrayLength = sc.nextInt();
        array = new Integer[arrayLength];

        for (int i = 0; i < arrayLength; i++) {     //Filling our array
            array[i] = sc.nextInt();
        }
        list = Arrays.asList(array);    // parsing our array to list

        if(list.indexOf(findMin(list))> list.indexOf(findMax(list))){        //Creating sublist to find out multiplication result
            subList = list.subList(list.indexOf(findMax(list))+1, list.indexOf(findMin(list)));
        }
        else {
            subList = list.subList(list.indexOf(findMin(list))+1, list.indexOf(findMax(list)));
        }

        try {
            PrintWriter pw = new PrintWriter(new File("C:\\Users\\Asguard\\IdeaProjects\\HomeWork\\output.txt"));
            pw.print(getSum(list)+ " ");
            pw.print(multiplication(subList));
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        }



    public int getSum(List<Integer> a){      // Method for sum calculating

        int sum = 0;

        for(int i = 0; i<a.size(); i++){
            if(a.get(i)<0){
                continue;
            } else{
                sum +=a.get(i);
            }
        }
        return sum;
    }

    public int findMin(List<Integer> a){        //Finding minimal elenent
        int min = a.get(0);

        for(int i=0; i<a.size(); i++){
            if (min > a.get(i)) {
                min = a.get(i);
            }
        }
        return min;
    }

    public int findMax(List<Integer> a){        //Finding maximal elenent
        int max = a.get(0);

        for(int i=0; i<a.size(); i++){
            if (max < a.get(i)) {
                max = a.get(i);
            }
        }
        return max;
    }

    public int multiplication(List<Integer> a){     //Result of multiplication
        int b = 1;
        for(int i = 0; i < a.size(); i++ ){
            b *= a.get(i);
        }
        return b;

    }


}
