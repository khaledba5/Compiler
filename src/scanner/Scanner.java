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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Reading From File
        BufferedReader file = new BufferedReader(new FileReader("tiny_sample_code.txt"));
        String line = file.readLine();
        
        //Writing To File
        BufferedWriter output = new BufferedWriter(new FileWriter("scanner_output.txt"));
        
        while(line !=null){
            output.write(line);
            output.newLine();
            line = file.readLine();
        }
        output.close();
    }
    
}
