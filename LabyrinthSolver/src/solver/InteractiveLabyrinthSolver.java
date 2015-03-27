package solver;

import model.Cell;
import model.CellType;
import model.LabyrinthModel;
import observer.LabyrinthObserver;
import viewer.Direction;
import viewer.LabyrinthView;

public class InteractiveLabyrinthSolver implements LabyrinthSolver{
    LabyrinthModel labyrinth;
    LabyrinthView labyrinthView;
    LabyrinthObserver labyrinthObserver;

    public InteractiveLabyrinthSolver(LabyrinthModel labyrinth, LabyrinthView labyrinthView, LabyrinthObserver labyrinthObserver){
        this.labyrinth = labyrinth;
        this.labyrinthView = labyrinthView;
        this.labyrinthObserver = labyrinthObserver;
    }

    public void solveLabyrinth(){
        Cell nextCell, currentCell;
        Direction nextDirection;

        currentCell = labyrinth.getStartCell();
        nextDirection = labyrinthView.getNextStep();
        nextCell = nextCellToExplore(currentCell, nextDirection);

        while (nextCell == labyrinth.getFinishCell()) {
            if (currentCell.getType() == CellType.FREE) {
                currentCell.setType(CellType.PASSED);
            }
            else if (currentCell.getType() == CellType.PASSED){
                currentCell.setType(CellType.FREE);
            }

            if (currentCell.getType() == CellType.WALL){
                labyrinthView.sendMessage("Invalid move!");
                nextDirection = labyrinthView.getNextStep();
                nextCell = nextCellToExplore(currentCell, nextDirection);
            }
            else {
                currentCell = nextCell;
                nextDirection = labyrinthView.getNextStep();
                nextCell = nextCellToExplore(currentCell, nextDirection);
            }
        }

        labyrinthObserver.notify(Event.FINISH);
    }

    public Cell nextCellToExplore( Cell currentCell, Direction direction ){
        Cell nextCell = null;

        switch(direction){
            case UP:    nextCell=labyrinth.getCellAt(currentCell.getX(),currentCell.getY()+1);
            case DOWN:  nextCell=labyrinth.getCellAt(currentCell.getX(),currentCell.getY()-1);
            case LEFT:  nextCell=labyrinth.getCellAt(currentCell.getX()-1,currentCell.getY());
            case RIGHT: nextCell=labyrinth.getCellAt(currentCell.getX()+1,currentCell.getY());
        }

        return nextCell;
    }
}
