package viewer;

import java.util.Scanner;

public interface LabyrinthView {
	
	public String toString();
	
	public Direction getNextStep(Scanner in);

    public void printMessage(String textToPrint);
    
    public void printLabyrinth();
}
