        // data from args[0] split to two files: args[1], args[2]
        // for sake of simplicity comments may be only on one line, like comments at
        // this file
        // /* */ cannot be
        // code ...// comment .... cannot be
        // However // may be not only at beginning of line, like this
        // args[0] - path to file containing code and comments
        // args[1] - path to file for placing only code
        // args[2] - path to file for placing only comments

package telran.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodeCommentsSeparation {
    public static void main(String[] args) {
        try(
            BufferedReader bf = new BufferedReader(new FileReader("example.txt"));
            BufferedWriter code = new BufferedWriter(new FileWriter("code.txt"));
            BufferedWriter comments = new BufferedWriter(new FileWriter("comments.txt"))
        ) {
            String line;
            while((line = bf.readLine()) != null ) {
                if(line.contains("//")) {
                    String[] helper = line.split("//");
                    comments.write(helper[helper.length - 1]);
                    comments.newLine();
                    if(helper.length - 2 >= 0) {
                        code.write(helper[helper.length - 2]);
                        code.newLine();
                    }
                } else {
                    code.write(line);
                    code.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
