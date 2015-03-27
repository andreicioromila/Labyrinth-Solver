package viewer;

import java.util.Scanner;

import model.LabyrinthModel;

public class LabyrinthViewSigns implements LabyrinthView {
	LabyrinthModel labyrinth;
	
	public LabyrinthViewSigns(LabyrinthModel labyrinth){
		this.labyrinth = labyrinth;
	}
	
	public String toString(){
		String result = new String();
		int n = labyrinth.getRowCount();
		int m = labyrinth.getRowCount();
		for (int i=0;i<n;i++)
			for (int j=0;j<m;j++)
				result+=labyrinth.getCellAt(i,j).getType().toStringSigns();
		return result;
	}

	public Direction getNextStep() {
		Scanner in = new Scanner(System.in);
		
		switch (in.nextLine().toLowerCase()){
		case "up":		in.close();
						return Direction.UP;
		case "down":	in.close();
						return Direction.DOWN;
		case "left":	in.close();
						return Direction.LEFT;
		case "right":	in.close();
						return Direction.RIGHT;
		default:		in.close();
						return null;
		}
	}
}
