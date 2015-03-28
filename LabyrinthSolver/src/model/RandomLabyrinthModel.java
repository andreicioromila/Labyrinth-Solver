//package model;
//
//import java.util.List;
//import java.util.LinkedList;
//
///**
// * Created by Andrei on 28/03/15.
// */
//public class RandomLabyrinthModel implements LabyrinthModel {
//
//    private List<Cell> labyrinth;
//    private int noRows;
//    private int noColumns;
//
//
//    public RandomLabyrinthModel(int rows, int columns) {
//        this.noRows = rows;
//        this.noColumns = columns;
//        //generate random
//        int random = (int)Math.random()*2;
//        for (int i=0;i<noRows;i++)
//            for(int j=0;j<noColumns;j++)
//                Cell cell = new Cell(i,j,CellType.);
//
//            }
//    }
//
//    public int getRowCount() {
//        return noRows;
//    }
//
//    public int getColumnCount() {
//        return noColumns;
//    }
//
//    public boolean isFreeAt(int x, int y) {
//        if (labyrinth.get(x * noColumns + y).getType() == CellType.FREE) return true;
//        return false;
//    }
//
//    public boolean isWallAt(int x, int y) {
//        if (labyrinth.get(x * noColumns + y).getType() == CellType.WALL) return true;
//        return false;
//    }
//
//    public Cell getStartCell() {
//        for (Cell c : labyrinth) {
//            if (c.getType() == CellType.START) return c;
//        }
//        return null;
//    }
//
//    public Cell getFinishCell() {
//        for (Cell c : labyrinth) {
//            if (c.getType() == CellType.FINISH) return c;
//        }
//        return null;
//    }
//
//    public Cell getCellAt(int x, int y) {
//        return labyrinth.get(x * noColumns + y);
//    }
//
//}
