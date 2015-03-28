package solver;

import model.Cell;
import model.CellType;
import model.LabyrinthModel;
import observer.LabyrinthObserver;
import viewer.Direction;
import viewer.LabyrinthView;

public class AutomaticLabyrinthSolver implements LabyrinthSolver {
    LabyrinthModel labyrinth;
    LabyrinthView labyrinthView;
    LabyrinthObserver labyrinthObserver;

    public AutomaticLabyrinthSolver(LabyrinthModel labyrinth, LabyrinthView labyrinthView, LabyrinthObserver labyrinthObserver) {
        this.labyrinth = labyrinth;
        this.labyrinthView = labyrinthView;
        this.labyrinthObserver = labyrinthObserver;
    }

    public void solveLabyrinth() {

        diveLabyrinth(labyrinth.getStartCell());

        //labyrinthObserver.notify(Event.FINISH);
    }

    private void diveLabyrinth(Cell currentCell) {
        if (currentCell.getType() == CellType.FINISH) {
            labyrinthView.printLabyrinth();
            return;
        }
        for (Direction dir : Direction.values()) {
            Cell nextCell = nextCellToExplore(currentCell, dir);
            if (nextCell != null && (nextCell.getType() == CellType.FREE || nextCell.getType() == CellType.FINISH || currentCell.getType() == CellType.START) ) {
                if (currentCell.getType() != CellType.START)
                    currentCell.setType(CellType.PASSED);
                diveLabyrinth(nextCell);
                currentCell.setType(CellType.FREE);
            }
        }
    }

    public Cell nextCellToExplore(Cell currentCell, Direction direction) {
        Cell nextCell = null;

        switch (direction) {
            case UP:
                nextCell = labyrinth.getCellAt(currentCell.getX(), currentCell.getY() + 1);
                break;
            case DOWN:
                nextCell = labyrinth.getCellAt(currentCell.getX(), currentCell.getY() - 1);
                break;
            case LEFT:
                nextCell = labyrinth.getCellAt(currentCell.getX() - 1, currentCell.getY());
                break;
            case RIGHT:
                    nextCell = labyrinth.getCellAt(currentCell.getX() + 1, currentCell.getY());
                break;
        }

        return nextCell;
    }
}
