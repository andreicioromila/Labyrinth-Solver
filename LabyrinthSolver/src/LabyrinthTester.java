import observer.LabyrinthObserver;
import solver.AutomaticLabyrinthSolver;
import solver.InteractiveLabyrinthSolver;
import solver.LabyrinthSolver;
import viewer.LabyrinthView;
import viewer.LabyrinthViewSigns;
import model.FileLabyrinthModel;
import model.LabyrinthModel;


public class LabyrinthTester {

	public static void main(String[] args) {
		LabyrinthModel labyrinth = new FileLabyrinthModel("lab.txt");
		LabyrinthView labyrinthViewer = new LabyrinthViewSigns(labyrinth);
		LabyrinthObserver labyrinthObserver = null;
		LabyrinthSolver labyrinthSolver = new InteractiveLabyrinthSolver(labyrinth,labyrinthViewer , labyrinthObserver);
		
		labyrinthViewer.printLabyrinth();

        labyrinthSolver.solveLabyrinth();

        labyrinthViewer.printLabyrinth();
		
	}

}
