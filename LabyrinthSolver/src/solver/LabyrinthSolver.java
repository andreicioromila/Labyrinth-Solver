package solver;

import model.Cell;
import viewer.Direction;

public interface LabyrinthSolver {
    public Cell nextCellToExplore( Cell currentCell, Direction direction );
    public void solveLabyrinth();
}
