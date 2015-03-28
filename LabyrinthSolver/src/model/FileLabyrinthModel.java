package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileLabyrinthModel implements LabyrinthModel {

    private List<Cell> labyrinth;
    private int noRows;
    private int noColumns = 0;

    @SuppressWarnings("null")
    public FileLabyrinthModel(String path) {
        //read from file, set noRows & noColumns

        File file = new File(path);

        //TODO de bordat pe linia 0, coloana 0 si pe n+1 cu perete

        int row = 0;
        int col = 0;
        labyrinth = new LinkedList<Cell>();
        CellType type = CellType.FREE;

        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                if (col != 0 && noColumns==0) {
                    noColumns = col;
                }
                String line = in.nextLine();
                col = 0;
                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case ' ':
                            type = CellType.FREE;
                            break;
                        case 'S':
                            type = CellType.START;
                            break;
                        case '|':
                            type = CellType.WALL;
                            break;
                        case 'F':
                            type = CellType.FINISH;
                            break;
                    }
                    Cell cell = new Cell(row, col, type);
                    labyrinth.add(cell);
                    col++;
                }
                row++;

            }
            noRows = row;
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FileLabyrinthModel(int rows, int columns) {
        this.noRows = rows;
        this.noColumns = columns;
        //generate random

    }

    public int getRowCount() {
        return noRows;
    }

    public int getColumnCount() {
        return noColumns;
    }

    public boolean isFreeAt(int x, int y) {
        if (labyrinth.get(x * noColumns + y).getType() == CellType.FREE) return true;
        return false;
    }

    public boolean isWallAt(int x, int y) {
        if (labyrinth.get(x * noColumns + y).getType() == CellType.WALL) return true;
        return false;
    }

    public Cell getStartCell() {
        for (Cell c : labyrinth) {
            if (c.getType() == CellType.START) return c;
        }
        return null;
    }

    public Cell getFinishCell() {
        for (Cell c : labyrinth) {
            if (c.getType() == CellType.FINISH) return c;
        }
        return null;
    }

    public Cell getCellAt(int x, int y) {
        if (x >= noRows || x < 0 || y < 0 || y>=noColumns) return null;
        return labyrinth.get(x * noColumns + y);
    }

}
