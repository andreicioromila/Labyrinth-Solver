package model;

import java.util.List;

public class FileLabyrinth implements LabyrinthModel{

	private List<Cell> labyrinth;
	private int noRows;
	private int noColumns;
	
	public FileLabyrinth(String path){
		//read from file, set noRows & noColumns
	}
	
	public FileLabyrinth(int rows, int columns){
		this.noRows=rows;
		this.noColumns=columns;
		//generate random
	}
	
	public int getRowCount(){
		return noRows;
	}
	
	public int getColumnCount(){
		return noColumns;
	}
	
	public boolean isFreeAt(int x, int y){
		if (labyrinth.get(x*noColumns + y).getType() == CellType.FREE) return true;
		return false;
	}
	
	public boolean isWallAt(int x, int y){
		if (labyrinth.get(x*noColumns + y).getType() == CellType.WALL) return true;
		return false;
	}
	
	public Cell getStartCell(){
		for (Cell c : labyrinth){
			if (c.getType() == CellType.START) return c;
		}
		return null;
	}
	
	public Cell getFinishCell(){
		for (Cell c : labyrinth){
			if (c.getType() == CellType.FINISH) return c;
		}
		return null;
	}

	public Cell getCellAt(int x, int y) {
		return labyrinth.get(x*noColumns + y);
	}

}
