/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author khaledba5
 */
public class Scanner {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static boolean IfComment(String line){
        if(line.startsWith("{")&&line.endsWith("}"))
        {
            return true;
        }
        return false;
    }
    public static int StartComment(String line){
        if(line.contains("{"))
        {
            return line.indexOf("{");
        }
        return -1;
    }
    public static int EndComment(String line){
        if(line.contains("}"))return line.indexOf("}");
        return -1;
    }
    public static boolean IfReserved(String line){
        String reserved[] = {"if","then","else","end","repeat","until","read","write"};
        for(int i=0;i<reserved.length;i++)
        {
            if(line.contains(reserved[i]))return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Reading From File
        BufferedReader file = new BufferedReader(new FileReader("tiny_sample_code.txt"));
        String line = file.readLine();
        
        //Writing To File
        BufferedWriter output = new BufferedWriter(new FileWriter("scanner_output.txt"));
        
        while(line !=null){
            int start =0;   //Index Indicate Start Of Comment
            int end =0;     //Index Indicate End Of Comment
            if(IfComment(line))
            {
                line = file.readLine(); 
                continue;
            }
            if(line.contains("{")&&line.contains("}"))
            {
                start = StartComment(line);
                end = EndComment(line);
            }
            output.write(line);
            output.newLine();
            line = file.readLine();
        }
        output.close();
    }
    
}
