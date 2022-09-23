package tui_test;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Drawer {
    int terminalRows, terminalColumns;
    Terminal terminal;
    char sysmble = 'X';
    char sysmbleMain = 'O';

    void drawBetweenTwoPoints(Coordinate2D pointNew, Coordinate2D pointOld) throws IOException, InterruptedException {
        if (pointNew.x >= 1 && pointNew.x <= terminalColumns / 3 - 1 && pointNew.y >= 1 && pointNew.y <= terminalRows) {
            int dx = pointNew.x - pointOld.x;
            int dy = pointNew.y - pointOld.y;

            int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
            double xinc = (double) dx / steps;
            double yinc = (double) dy / steps;

            double x = pointOld.x;
            double y = pointOld.y;

            for (int i = 0; i <= steps; i++) {
                terminal.setCursorPosition((int) Math.round(x) * 3 + 1, terminalRows - (int) Math.round(y));
                terminal.putCharacter(sysmble);
                x += xinc;
                y += yinc;
            }
            terminal.setCursorPosition(pointNew.x * 3 + 1, terminalRows - pointNew.y);
            terminal.putCharacter(sysmbleMain);
            terminal.flush();
        }
    }

    void print() throws IOException {
        terminal.setCursorPosition(terminalColumns, terminalRows);
        terminal.flush();
        System.out.println();
    }

    Drawer() throws IOException {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        terminal = defaultTerminalFactory.createTerminal();
        var size = terminal.getTerminalSize();
        for (int i = 0; i < size.getRows(); i++) {
            System.out.println();
        }
        terminalRows = size.getRows() - 4;
        terminalColumns = size.getColumns() - 30;

        for (int i = 0; i < terminalRows; i++) {
            terminal.setCursorPosition(0, i);
            if (terminalRows - i >= 1 && terminalRows - i <= 9) {
                terminal.putCharacter(' ');
            }
            terminal.putString(String.valueOf(terminalRows - i) + " |");
        }
        int count = 1;
        for (int i = 4; i < terminalColumns; i += 3) {
            terminal.setCursorPosition(i, terminalRows);
            terminal.putString(String.valueOf(count) + " ");
            count++;
        }
    }
}
