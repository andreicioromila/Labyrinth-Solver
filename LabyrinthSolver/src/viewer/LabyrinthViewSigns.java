package viewer;

import java.util.Scanner;

import model.LabyrinthModel;

public class LabyrinthViewSigns implements LabyrinthView {
    LabyrinthModel labyrinth;

    public LabyrinthViewSigns(LabyrinthModel labyrinth) {
        this.labyrinth = labyrinth;
    }

    public String toString() {
        String result = new String("");
        int n = labyrinth.getRowCount();
        int m = labyrinth.getRowCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                result += labyrinth.getCellAt(i, j).getType().toStringSigns();
            result+='\n';
        }
        return result;
    }

    public Direction getNextStep() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toUpperCase();

        return Direction.valueOf(input);
    }

    public void printMessage(String textToPrint) {
        System.out.println(textToPrint);
    }

    public void printLabyrinth() {
        System.out.println(toString());
    }
}
