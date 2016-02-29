package xyz.jadonfowler.jlc;

import java.io.*;
import com.github.javaparser.*;
import com.github.javaparser.ast.*;

public class JLC {
    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("test.jlc");
        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        }
        finally {
            in.close();
        }
        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
        for (Node n : cu.getChildrenNodes()) {
            System.out.println(n.getClass().getName() + ": " + n.toString());
            for(Node n2 : n.getChildrenNodes()) {
                System.out.println(n2.getClass().getName() + ": " + n2.toString());
                for(Node n3 : n2.getChildrenNodes()) {
                    System.out.println(n3.getClass().getName() + ": " + n3.toString());
                }
            }
        }
    }
}