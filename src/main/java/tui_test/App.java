package tui_test;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException {
        var drawer = new Drawer();
        drawer.setPoint(5, 8);
        drawer.print();
    }
}
