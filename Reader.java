package com.siemens.scr.cigarmonitoringrl.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// create a buffered reader
public class Reader {

    public Reader() {

        file = new File("C:/temp/test.txt");
    }
    private int bufferSize = 1024;
    private char[] buffer = new char[bufferSize];
    private int capacity = 0;
    private int byteRead = 0;
    ptivate int index = 0;
    private boolean canReadMore = true;
    File file;

    public  int read(char[] usrBfr, int reqSize) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file) , bufferSize);

        while(canReadMore ){
            if (capacity  == 0 || byteRead == capacity){
                int readSize = br.read(buffer);

                if (readSize == -1 || readSize < bufferSize){
                    canReadMore = false;
                }
                capacity =  readSize>=0 ? readSize : 0;
                byteRead = 0;
            }

            while (index < reqSize && (byteRead) < capacity){
                usrBfr[index] = buffer[byteRead];
                index++;
                byteRead++;
            }
        }
        return index;
    }


}
