import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tetris {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private static final int[][] SHAPES = {
            {1, 1, 1, 1},       // I
            {1, 1, 1, 0, 1},    // T
            {1, 1, 1, 0, 0, 1}, // L
            {1, 1, 1, 0, 0, 0, 1},  // J
            {1, 1, 0, 0, 1, 1}, // Z
            {0, 1, 1, 0, 1, 1}, // S
            {1, 1, 0, 0, 1, 1}  // O
    };

    private int[][] grid;
    private Point currentPieceOrigin;
    private int currentShape;
    private ArrayList<Point> currentPiece;

    public Tetris() {
        grid = new int[HEIGHT][WIDTH];
        currentPieceOrigin = new Point(HEIGHT - 1, WIDTH / 2);
        currentShape = new Random().nextInt(SHAPES.length);
        currentPiece = new ArrayList<>();

        createNewPiece();
    }

    private void createNewPiece() {
        for (int i = 0; i < SHAPES[currentShape].length; i += 2) {
            currentPiece.add(new Point(
                    currentPieceOrigin.x + SHAPES[currentShape][i],
                    currentPieceOrigin.y + SHAPES[currentShape][i + 1]
            ));
        }
    }

    private boolean isValidMove(int x, int y) {
        for (Point point : currentPiece) {
            int newX = point.x + x;
            int newY = point.y + y;

            if (newX < 0 || newX >= HEIGHT || newY < 0 || newY >= WIDTH || grid[newX][newY] != 0) {
                return false;
            }
        }

        return true;
    }

    private void placePiece() {
        for (Point point : currentPiece) {
            grid[point.x][point.y] = 1;
        }
    }

    private void clearLines() {
        for (int i = 0; i < HEIGHT; i++) {
            boolean lineIsFull = true;

            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] == 0) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                for (int k = i; k < HEIGHT - 1; k++) {
                    System.arraycopy(grid[k + 1], 0, grid[k], 0, WIDTH);
                }
            }
        }
    }

    private void rotatePiece() {
        ArrayList<Point> rotatedPiece = new ArrayList<>();

        for (Point point : currentPiece) {
            int x = point.y - currentPieceOrigin.y;
            int y = point.x - currentPieceOrigin.x;
            Point newPoint = new Point(currentPieceOrigin.x - x, currentPieceOrigin.y + y);
            rotatedPiece.add(newPoint);
        }

        if (isValidMove(0, 0, rotatedPiece)) {
            currentPiece.clear();
            currentPiece.addAll(rotatedPiece);
        }
    }

    private void movePiece(int x, int y) {
        if (isValidMove(x, y)) {
            currentPieceOrigin.x += x;
            currentPieceOrigin.y += y;
        } else if (y > 0) {
            placePiece();
            clearLines();
            createNewPiece();
        }
    }

    private boolean isValidMove(int x, int y, ArrayList<Point> piece) {
        for (Point point : piece) {
            int newX = point.x + x;
            int newY = point.y + y;

            if (newX < 0 || newX >= HEIGHT || newY < 0 || newY >= WIDTH || grid[newX][newY] != 0) {
                return false;
            }
        }

        return true;
    }

    private void draw() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] == 0) {
                    stringBuilder.append(".");
                } else {
                    stringBuilder.append("X");
                }
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            draw();
            System.out.println("Use arrow keys to move, or 'q' to quit");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            } else if (input.equalsIgnoreCase("left")) {
                movePiece(0, -1);
            } else if (input.equalsIgnoreCase("right")) {
                movePiece(0, 1);
            } else if (input.equalsIgnoreCase("down")) {
                movePiece(1, 0);
            } else if (input.equalsIgnoreCase("up")) {
                rotatePiece();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.run();
    }
}