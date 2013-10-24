package com.supinfo.gameoflife;

import java.util.Random;

public class World {

    private Cell[][] world;
    private int generationNumber;

    public World(int nbRows, int nbColumns) {
    	if(nbRows < 0 || nbColumns < 0) {
    		throw new IllegalArgumentException("Bad value");
    	}
        this.world = new Cell[nbRows][nbColumns];
        Random random = new Random();
        for(int i = 0; i < this.world.length; i++) {
            for(int j= 0; j < this.world[0].length; j++) {
                if(random.nextInt(2) == 0) {
                    this.world[i][j] = new AliveCell();
                } else {
                    this.world[i][j] = new DeadCell();
                }
            }
        }
    }

    public World(Cell[][] world) {
        this.world = world;
    }

    public void newGeneration() {
        generationNumber ++;
        for(int i = 0; i < world.length; i++) {
            for(int j = 0; j < world[0].length; j++) {
                world[i][j] = world[i][j].newGeneration(getAvailableNeighbours(i, j));
            }
        }
    }

    private int getAvailableNeighbours(int i, int j) {
        int count = 0;

        if(i > 0 && j > 0 &&  world[i-1][j-1].isAlive()) { // HAUT GAUCHE
            count ++;
        }
        if(j > 0 && world[i][j-1].isAlive()) { // HAUT CENTRE
            count ++;
        }
        if(i + 1 < world.length && j > 0 && world[i+1][j-1].isAlive()) { // HAUT DROITE
            count ++;
        }
        if(i > 0 && world[i-1][j].isAlive()) { // GAUCHE
            count ++;
        }
        if(i + 1 < world.length  && world[i+1][j].isAlive()) { // DROITE
            count ++;
        }
        if(i > 0 && j + 1 < world[0].length && world[i-1][j+1].isAlive()) { // BAS GAUCHE
            count ++;
        }
        if(j + 1 < world[0].length && world[i][j+1].isAlive()) { // BAS CENTRE
            count ++;
        }
        if(i + 1 < world.length && j + 1 < world[0].length && world[i+1][j+1].isAlive()) { // BAS DROITE
            count ++;
        }
        return count;
    }

    /*
        Cell du tableau world par rapport à notre Cell centrale (i, j)

         (i-1, j-1) | (i, j-1) | (i+1, j-1)
         (i-1, j)   | (i, j)   | (i+1, j)
         (i-1, j+1) | (i, j+1) | (i+1, j+1)
    */

    @Override
    public String toString() {
        String printedWorld = new String();
        for(int i = 0; i < world.length; i++) {
            for(int j = 0; j < world[0].length; j++) {
                printedWorld += world[i][j].getAsString()+" ";
            }
            printedWorld += System.getProperty("line.separator");
        }
        return "Generation "+generationNumber +": "+System.getProperty("line.separator") + printedWorld;
    }
}
