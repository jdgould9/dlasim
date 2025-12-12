package app.dlav3.model;

import java.util.Random;

public class Seeder {

    public static void drawCircle(int[][] field, int centerX, int centerY, int radius) {
        int x = radius;
        int y = 0;
        int decision = 1 - x;

        while (x >= y) {
            plotCirclePoints(field, centerX, centerY, x, y);
            y++;
            if (decision <= 0) {
                decision += 2 * y + 1;
            } else {
                x--;
                decision += 2 * (y - x) + 1;
            }
        }
    }

    private static void plotCirclePoints(int[][] field, int cx, int cy, int x, int y) {
        int width = field.length;
        int height = field[0].length;

        int[][] points = {
                {cx + x, cy + y}, {cx - x, cy + y},
                {cx + x, cy - y}, {cx - x, cy - y},
                {cx + y, cy + x}, {cx - y, cy + x},
                {cx + y, cy - x}, {cx - y, cy - x}
        };

        for (int[] p : points) {
            int px = p[0];
            int py = p[1];
            if (px >= 0 && px < width && py >= 0 && py < height) {
                field[px][py] = 1;
            }
        }
    }

    public static void placeSeed(SeedType seedType, int[][] particleField, int numSeeds, int simulationWidth, int simulationHeight, Random random){
        switch (seedType){
            case CENTERPOINT:
                particleField[simulationHeight/2][simulationWidth/2]=1;
                break;
            case RANDOMPOINT:
                int placedSeeds = 0;
                while (placedSeeds < numSeeds) {
                    int x = random.nextInt(simulationWidth);
                    int y = random.nextInt(simulationHeight);
                    if (particleField[x][y] == 0) {
                        particleField[x][y] = 1;
                        placedSeeds++;
                    }
                }
                break;
            case GRID:
                int halfWidth = simulationWidth / 4;
                int halfHeight = simulationHeight / 4;

                for (int x = halfWidth; x < simulationWidth; x += halfWidth) {
                    for (int y = 0; y < simulationHeight; y++) {
                        particleField[x][y] = 1;
                    }
                }
                for (int y = halfHeight; y < simulationHeight; y += halfHeight) {
                    for (int x = 0; x < simulationWidth; x++) {
                        particleField[x][y] = 1;
                    }
                }
                break;
            case CIRCLE:
                drawCircle(particleField, simulationWidth/2, simulationHeight/2, simulationWidth/4);
                break;
            case EDGE:
                for (int x = 0; x < simulationWidth; x ++) {
                    particleField[x][0]=1;
                    particleField[x][simulationHeight-1]=1;
                }
                for (int y = 0; y < simulationHeight; y ++) {
                    particleField[0][y]=1;
                    particleField[simulationWidth-1][y]=1;
                }

                break;
        }
    }
}
