package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileLabyrinth implements LabyrinthModel{

	private List<Cell> labyrinth;
	private int noRows;
	private int noColumns;
	
	public FileLabyrinth(String path){
		//read from file, set noRows & noColumns
		
		File file = new File(path);
		
		int row=0;
		int col=0;
		List<Cell> labyrinth = new LinkedList<Cell>();
		char[] lineChars = null;
		CellType type = CellType.FREE;
		
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
	            
				String line = in.nextLine();
	            line.getChars(0, line.length(), lineChars, 0);
	            for (int i=0; i<lineChars.length; i++){
	            	switch (lineChars[i]){
	            	case ' ':	type = CellType.FREE;
	            	case 'S':	type = CellType.START;
	            	case '|':	type = CellType.WALL;
	            	case 'F':	type = CellType.FINISH;
	            	}
	            	Cell cell = new Cell(row,col,type);
	            }
	            
	        }
	        in.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
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
