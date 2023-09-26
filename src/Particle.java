import java.util.Random;

enum Direction {
    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
}

class Particle {
    private int x;
    private int y;

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Direction direction, int boxWidth, int boxHeight) {
        Random random = new Random();
        int dx = 0;
        int dy = 0;

        // Calculate the movement based on the direction
        switch (direction) {
            case NORTH:
                dy = -1;
                break;
            case NORTHEAST:
                dx = 1;
                dy = -1;
                break;
            case EAST:
                dx = 1;
                break;
            case SOUTHEAST:
                dx = 1;
                dy = 1;
                break;
            case SOUTH:
                dy = 1;
                break;
            case SOUTHWEST:
                dx = -1;
                dy = 1;
                break;
            case WEST:
                dx = -1;
                break;
            case NORTHWEST:
                dx = -1;
                dy = -1;
                break;
        }

        // Update the particle's position while ensuring it stays within the box
        x = Math.max(0, Math.min(x + dx, boxWidth - 1));
        y = Math.max(0, Math.min(y + dy, boxHeight - 1));
    }
}