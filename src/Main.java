// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int boxWidth = 10;
        int boxHeight = 10;
        int initialParticleCount = 3;
        int simulationSteps = 100;

        ParticleBox particleBox = new ParticleBox(boxWidth, boxHeight, initialParticleCount);

        for (int step = 1; step <= simulationSteps; step++) {
            System.out.println("Step " + step + ": " + particleBox.getParticleCount() + " particles");
            particleBox.simulateStep();
        }
        
    }
}