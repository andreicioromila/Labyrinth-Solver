import observer.LabyrinthObserver;
import solver.AutomaticLabyrinthSolver;
import solver.LabyrinthSolver;
import viewer.LabyrinthView;
import viewer.LabyrinthViewSigns;
import model.FileLabyrinth;
import model.LabyrinthModel;


public class LabyrinthTester {

	public static void main(String[] args) {
		LabyrinthModel labyrinth = new FileLabyrinth("lab.txt");
		LabyrinthView labyrinthViewer = new LabyrinthViewSigns(labyrinth);
		LabyrinthObserver labyrinthObserver = null;
		LabyrinthSolver labyrinthSolver = new AutomaticLabyrinthSolver(labyrinth,labyrinthViewer , labyrinthObserver);
		
		labyrinthViewer.printLabyrinth();

        labyrinthSolver.solveLabyrinth();

        labyrinthViewer.printLabyrinth();
		
	}

}
