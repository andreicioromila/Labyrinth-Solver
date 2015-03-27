package model;


public interface LabyrinthModel {
	
	public int getRowCount();
	
	public int getColumnCount();
	
	public boolean isFreeAt(int x,int y);
	
	public boolean isWallAt(int x,int y);
	
	public Cell getStartCell();
	
	public Cell getFinishCell();

	public Cell getCellAt(int x, int y);
}
