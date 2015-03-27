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
	
	@SuppressWarnings("null")
	public FileLabyrinth(String path){
		//read from file, set noRows & noColumns
		
		File file = new File(path);
		
		int row=0;
		int col=0;
		labyrinth = new LinkedList<Cell>();
		CellType type = CellType.FREE;
		
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				if ( col!=0 ) {
					noColumns=col;
				}
				String line = in.nextLine();
				col=0;
				row++;
	            for (int i=0; i<line.length(); i++){
	            	switch (line.charAt(i)){
	            	case ' ':	type = CellType.FREE;
	            	case 'S':	type = CellType.START;
	            	case '|':	type = CellType.WALL;
	            	case 'F':	type = CellType.FINISH;
	            	}
	            	Cell cell = new Cell(row,col,type);
	            	labyrinth.add(cell);
	            	col++;
	            }
	            
	        }
			noRows = row;
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
