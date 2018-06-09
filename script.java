/*
Author:Mohini Arora
Licence:GPL
Date:09-06-2018
*/
//All Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Script {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {
        String splitBy = ",";
        String myDirectoryPath="input/";
        File dir = new File(myDirectoryPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
    		for (File child : directoryListing) {
                System.out.println("[Processing File]:"+child);
                BufferedReader br = new BufferedReader(new FileReader(child));
                String line ="";
                PrintWriter pw = new PrintWriter(new File("output/"+child.getName()));
                StringBuilder sb = new StringBuilder();
                while((line = br.readLine()) !=null){
                    String b[] = line.split(splitBy);
                    sb.append(b[1]);
                    sb.append(',');
                    sb.append(b[3]);
                    sb.append('\n');
                }
                br.close();
                System.out.println("[Procesd File Succesfully]:"+child);
                pw.write(sb.toString());
                pw.close();
            }
            System.out.println("done! Please check output folder for all Processed file");
        } else {
        }
  }
}
