package Seminar6th.homeWork;

import Seminar6th.homeWork.Notebook;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
    Notebook notebook= new Notebook(8, 128, "Windows", "White");
    Notebook notebook1= new Notebook(8, 512, "Linux", "Black");
    Notebook notebook2= new Notebook(4, 256, "MacOS", "Red");
    Notebook notebook3= new Notebook(8, 128, "Windows", "Blue");
    Notebook notebook4= new Notebook(4, 512, "Windows", "Orange");
    Notebook notebook5= new Notebook(32, 256, "Windows", "Purple");
    Notebook notebook6= new Notebook(4, 1024, "Linux", "Silver");
    Notebook notebook7= new Notebook(32, 1024, "MacOS", "Grey");
    Notebook notebook8= new Notebook(4, 128, "Windows", "White");
    Notebook notebook9= new Notebook(4, 256, "MacOS", "White");
    Notebook notebook10= new Notebook(32, 512, "Windows", "White");
    Notebook notebook11= new Notebook(16, 128, "Windows", "White");
    Notebook notebook12= new Notebook(32, 256, "MacOS", "White");
    Notebook notebook123= new Notebook(8, 1024, "Windows", "Purple");
    Notebook notebook124= new Notebook(4, 256, "Linux", "Red");
    Notebook notebook125= new Notebook(4, 256, "Linux", "Red");
//    System.out.println("notebook = " + notebook);
//    System.out.println("notebook1 = " + notebook1);
//    System.out.println("notebook2 = " + notebook2);
//    System.out.println("notebook3 = " + notebook3);
//    System.out.println("notebook4 = " + notebook4);
//    System.out.println("notebook5 = " + notebook5);
//    System.out.println("notebook6 = " + notebook6);
//    System.out.println("notebook7 = " + notebook7);
//    System.out.println("notebook8 = " + notebook8);
//
//    System.out.println(notebook5.equals(notebook124));
//    System.out.println(notebook124.equals(notebook125));


    Set<Notebook> noutebooks = new HashSet<>();
    noutebooks.add(notebook);
    noutebooks.add(notebook1);
    noutebooks.add(notebook2);
    noutebooks.add(notebook3);
    noutebooks.add(notebook4);
    noutebooks.add(notebook5);
    noutebooks.add(notebook6);
    noutebooks.add(notebook7);
    noutebooks.add(notebook8);
    noutebooks.add(notebook9);
    noutebooks.add(notebook10);
    noutebooks.add(notebook11);
    noutebooks.add(notebook12);
    noutebooks.add(notebook123);
    noutebooks.add(notebook124);
    noutebooks.add(notebook125);

//    System.out.println("noutebooks = " + noutebooks);

//    Notebook.sort(Notebook.menu(), noutebooks);
        Notebook.filterNout(noutebooks);
    }
}

