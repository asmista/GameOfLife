package com.supinfo.gameoflife;

public class AliveCell implements Cell {

    private int version = 1;

    @Override
    public Cell newGeneration(int nbNeighbours) {
        if(nbNeighbours < 2 || nbNeighbours > 3) {
            return new DeadCell();
        }
        version ++;
        return this;
    }

    @Override
    public String getAsString() {
        if(version > 1) {
            return "+";
        }
        return "0";
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
