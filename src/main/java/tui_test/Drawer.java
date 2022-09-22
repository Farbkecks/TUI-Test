package tui_test;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Drawer {
    int terminalRows, terminalColumns;
    Terminal terminal;

    void setPoint(int x, int y) throws IOException {
        terminal.setCursorPosition(x, y);
        terminal.putCharacter('X');
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

        // terminal.setCursorPosition(5, 0);
        // terminal.putCharacter('X');

    }
}
