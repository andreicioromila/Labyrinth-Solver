package solver;

import model.Cell;
import model.CellType;
import model.LabyrinthModel;
import observer.LabyrinthObserver;
import viewer.Direction;
import viewer.LabyrinthView;

import java.util.Scanner;

public class InteractiveLabyrinthSolver implements LabyrinthSolver {
    LabyrinthModel labyrinth;
    LabyrinthView labyrinthView;
    LabyrinthObserver labyrinthObserver;

    public InteractiveLabyrinthSolver(LabyrinthModel labyrinth, LabyrinthView labyrinthView, LabyrinthObserver labyrinthObserver) {
        this.labyrinth = labyrinth;
        this.labyrinthView = labyrinthView;
        this.labyrinthObserver = labyrinthObserver;
    }

    public void solveLabyrinth() {
        Scanner in = new Scanner(System.in);
        Cell nextCell, currentCell;
        Direction nextDirection;

        currentCell = labyrinth.getStartCell();


        do {
            nextDirection = labyrinthView.getNextStep(in);
            nextCell = nextCellToExplore(currentCell, nextDirection);
            if (nextCell == null) {
                labyrinthView.printMessage("Invalid move!");
                labyrinthView.printLabyrinth();
                continue;
            }
            if (nextCell.getType() == CellType.FREE) {
                nextCell.setType(CellType.PASSED);
            } else if (nextCell.getType() == CellType.PASSED) {
                nextCell.setType(CellType.FREE);
            }

            if (nextCell.getType() == CellType.WALL) {
                labyrinthView.printMessage("Invalid move!");
            } else
                currentCell = nextCell;
            labyrinthView.printLabyrinth();
        } while (nextCell != labyrinth.getFinishCell());
        labyrinthView.printMessage("Succes");
        //labyrinthObserver.notify(Event.FINISH);
        in.close();
    }

    public Cell nextCellToExplore(Cell currentCell, Direction direction) {
        Cell nextCell = null;

        switch (direction) {
            case UP:
                nextCell = labyrinth.getCellAt(currentCell.getX() - 1, currentCell.getY());
                break;
            case DOWN:
                nextCell = labyrinth.getCellAt(currentCell.getX() + 1, currentCell.getY());
                break;
            case LEFT:
                nextCell = labyrinth.getCellAt(currentCell.getX(), currentCell.getY() - 1);
                break;
            case RIGHT:
                nextCell = labyrinth.getCellAt(currentCell.getX(), currentCell.getY() + 1);
                break;
        }

        return nextCell;
    }
}
