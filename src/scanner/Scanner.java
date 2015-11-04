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
    public static boolean isNumber(char x){
        try
        {
            double d = Double.parseDouble(Character.toString(x));
        }catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    public static boolean isLetter(char x){
        return Character.toString(x).matches("[a-zA-Z]+");
    }
 
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Reading From File
        BufferedReader file = new BufferedReader(new FileReader("tiny_sample_code.txt"));
        String line = file.readLine();
        
        //Writing To File
        BufferedWriter output = new BufferedWriter(new FileWriter("scanner_output.txt"));
        
        while(line !=null){
            char characters[] = line.toCharArray();
            for(int i=0;i<characters.length;i++)
            {
                char Num = 'n';
                char Letter = 'n';
                if(isNumber(characters[i]))
                {
                    Num = 'y';
                }else if(isLetter(characters[i]))
                {
                    Letter ='y';
                }
                switch(characters[i])
                {
                    case ' ':
                        continue;
                    case '{':
                        //State Of Comment
                        while(characters[i]!='}')i++;
                        break;
                        
                        
                    //INASSIGN State
                    case ':':
                        i++;
                        switch(characters[i])
                        {
                            case '=':
                                output.write(":= :Special Symbol");
                                break;
                        }
                    break;
                }
            }
        }
        output.close();
    }
    
}
