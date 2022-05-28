package sample;

import java.util.Vector;

public class KeyWordAtStation {
    static public Vector<String>[] keyWord = (Vector<String>[]) new Vector[Main.stationNum];

    //initialize keyword at every station
    static {
        for(int i=0; i<Main.stationNum; i++) {
            keyWord[i] = new Vector<>();
        }


        //ref
        keyWord[6].add("interface");
        keyWord[6].add("final");
        keyWord[6].add("abstract");
        keyWord[6].add("public");
        keyWord[6].add("implements");
        keyWord[6].add("implementation");

        //reference https://kent010341.github.io/java-tutorial/exception.html
        keyWord[7].add("try");
        keyWord[7].add("catch");
        keyWord[7].add("finally");
        keyWord[7].add("getMessage()");
        keyWord[7].add("printStackTrace()");
        keyWord[7].add("ArithmeticException");
        keyWord[7].add("ArrayIndexOutOfBoundsException");
        keyWord[7].add("ArrayStoreException");
        keyWord[7].add("IllegalArgumentException");
        keyWord[7].add("NullPointerException");

        //ref
        keyWord[8].add("Thread");
        keyWord[8].add("thread");
        keyWord[8].add("Runnable");
        keyWord[8].add("void run()");
        keyWord[8].add(".start()");
        keyWord[8].add("synchronization");
        keyWord[8].add("synchronized");
    }
}
