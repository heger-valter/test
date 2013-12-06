/*
This program takes as input the name of a dir hierarchy
and displays its name and all subdirectories.
@author Walter Heger
@date 03/21/12

*/
package peterstest;

import java.io.File;

public class traverseDirHierchy {

    static int iMaxProcessed = 10;// breath traversal limit
    static int iMaxDepth = 4;// depth traversal limit

// cheat, this was given to me by Eclipse
    @SuppressWarnings("unused")

    static public int readThem(String stDir, int iDepth)
    // recursive method to drill down dir hierarchy
    {
        int num = 0;// num processed
        File myFile = new File(stDir);
//cheat, I had to check the syntax on this statement
        File[] theFiles = myFile.listFiles();

        for (int i = 0; i < theFiles.length; i++) {
            // test breath traversal
            if ((iDepth<iMaxDepth)
                    && (num<iMaxProcessed)){
                if (theFiles[i].isDirectory()){
                    System.out.println(theFiles[i].toString());
                    if (
                            (!theFiles[i].isHidden())
                            && theFiles[i].canRead()
                        ){
                        num++;
                        try {
                            readThem(theFiles[i].toString(), iDepth+1);
                        } catch (Exception e) {
                            //ignore problematic dirs
                            // TODO Auto-generated catch block
                            //e.printStackTrace();
                           
                        }
                    }
                }
            } else {
                if (false){
                    System.out.print("\tlimit reached ");
                    System.out.print(" \tiDepth=");
                    System.out.print(iDepth);
                    System.out.print(" \tnum=");
                    System.out.println(num);
                }
            }
        }
       
        return num;
    }
   
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            try {
                System.out.println(args);
                if (args.length>0) {
                    System.out.println("input dir is ");
                    System.out.println(args[0]);
                    readThem(args[0], 0);
                } else {
                    System.out.println("Please give me a directory hierachy to start traversing and print ");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
               
            }
    }

}
