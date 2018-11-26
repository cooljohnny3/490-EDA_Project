/**Global methods and variables that all pieces of the program would need access to**/
package com.COMP490.EDA;

import java.util.ArrayList;

public final class Global {

    private static String usernameText;
    private static ArrayList<File> files= new ArrayList<File>(20);

    private Global(){}  // Private constructor to prevent instantiation
    public static void addToArrayList(File f){
        files.add(f);
    }

}