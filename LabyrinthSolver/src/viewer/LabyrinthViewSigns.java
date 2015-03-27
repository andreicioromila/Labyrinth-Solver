package viewer;

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
}
