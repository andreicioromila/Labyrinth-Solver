package model;

public interface LabyrinthModel {
	
	public int getRowCount();
	
	public int getColumnCount();
	
	public boolean isFreeAt();
	
	public boolean isWallAt();
	
	public void getStartCell();
	
	public void getFinishCell();
}
