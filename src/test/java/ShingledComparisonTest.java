import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import rrcf.general.Forest;
import rrcf.general.ShingledForest;

public class ShingledComparisonTest {
    @Test
    public void testShingled() {
        double[] dat = new double[] { 1, 2, 3, 4, 5 };
        ShingledForest sForest = new ShingledForest(new Random(1), 2, 1, 20, dat);
        double[][] noShingleDat = new double[][] {
            { 1, 2 },
            { 2, 3 },
            { 3, 4 },
            { 4, 5 }
        };
        Forest forest = new Forest(new Random(1), 1, 20, noShingleDat);
        System.out.println("Normal:");
        System.out.println(forest.toString());
        System.out.println("Shingled:");
        System.out.println(sForest.toString());
        assertEquals(forest.toString(), sForest.toString());
        forest.addPoint(new double[] { 5, 6 });
        sForest.addPoint(6);
        assertEquals(forest.toString(), sForest.toString());
        for (int i = 0; i < 3; i++) {
            assertEquals(forest.getDisplacement(i), sForest.getDisplacement(i), 0.00000000001);
        }
    }
}