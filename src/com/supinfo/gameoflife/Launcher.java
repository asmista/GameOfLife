package com.supinfo.gameoflife;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);
    	int rows, cols;
    	System.out.println("Nombre de lignes :");
    	rows = sc.nextInt();
    	System.out.println("Nombre de colonnes :");
    	cols = sc.nextInt();
    	World world = null;
    	try {
    		world = new World(rows, cols);
    	} catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    	}
        System.out.println(world.toString());
        for(int i = 0; i < 10; i++) {
            world.newGeneration();
            System.out.println(world.toString());
        }
    }
}
