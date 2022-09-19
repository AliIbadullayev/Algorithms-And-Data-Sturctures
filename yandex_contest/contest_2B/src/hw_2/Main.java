package hw_2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String str = "";
        try{
            while ((str = br.readLine()) != null) {
                bw.write(str.substring(str.indexOf("=")+1)+"\n");
            }
        } catch (StringIndexOutOfBoundsException e ){
            e.printStackTrace();
            System.out.println(str+"\n");

        }finally {
            br.close();
            bw.close();
        }
    }

}
