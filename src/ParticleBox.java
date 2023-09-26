import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ParticleBox {
    private int boxWidth;
    private int boxHeight;
    private List<Particle> particles;

    public ParticleBox(int boxWidth, int boxHeight, int initialParticleCount) {
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
        particles = new ArrayList<>();

        // Initialize particles with random positions
        Random random = new Random();
        for (int i = 0; i < initialParticleCount; i++) {
            int x = random.nextInt(boxWidth);
            int y = random.nextInt(boxHeight);
            particles.add(new Particle(x, y));
        }
    }

    public void simulateStep() {
        List<Particle> newParticles = new ArrayList<>();

        for (Particle particle : particles) {
            Direction direction = Direction.values()[new Random().nextInt(Direction.values().length)];
            particle.move(direction, boxWidth, boxHeight);

            boolean collision = false;
            for (Particle otherParticle : newParticles) {
                if (particle.getX() == otherParticle.getX() && particle.getY() == otherParticle.getY()) {
                    collision = true;
                    break;
                }
            }

            if (!collision) {
                newParticles.add(particle);
            }
        }

        while (newParticles.size() < particles.size()) {
            int x = new Random().nextInt(boxWidth);
            int y = new Random().nextInt(boxHeight);
            newParticles.add(new Particle(x, y));
        }

        particles = newParticles;
    }

    public int getParticleCount() {
        return particles.size();
    }
}
