package tui_test;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Drawer {
    int terminalRows, terminalColumns;
    Terminal terminal;
    char sysmble = 'X';

    void setPoint(Coordinate2D pointNew, Coordinate2D pointOld) throws IOException, InterruptedException {
        if (pointNew.x >= 1 && pointNew.x <= terminalColumns && pointNew.y >= 1 && pointNew.y <= terminalRows) {
            int dx = pointNew.x - pointOld.x;
            int dy = pointNew.y - pointOld.y;

            if (dy == 0 || dx == 0) {
                return;
            }

            int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);

            double xinc = dx / steps;
            double yinc = dy / steps;

            double x = pointOld.x;
            double y = pointOld.y;

            for (int i = 0; i < steps; i++) {
                terminal.setCursorPosition((int) Math.round(x) * 2, terminalRows - (int) Math.round(y));
                terminal.putCharacter(sysmble);
                x += xinc;
                y += yinc;
            }

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
        terminalRows = size.getRows() - 4;
        for (int i = 0; i < size.getRows(); i++) {
            System.out.println();
        }
        terminalColumns = size.getColumns() - 30;

        for (int i = 0; i < terminalRows; i++) {
            terminal.setCursorPosition(0, i);
            terminal.putCharacter('|');
        }
        for (int i = 0; i < terminalColumns; i++) {
            terminal.setCursorPosition(i, terminalRows);
            terminal.putCharacter('_');
        }
    }
}
