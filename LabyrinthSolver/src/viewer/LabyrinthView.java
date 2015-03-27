package viewer;

public interface LabyrinthView {
	
	public String toString();
	
	public Direction getNextStep();

    public void printMessage(String textToPrint);
}
