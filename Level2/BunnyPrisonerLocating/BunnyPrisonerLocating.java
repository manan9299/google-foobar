import java.math.BigInteger;

public class BunnyPrisonerLocating {

    public static void main(String[] args) {

        System.out.println(solution(2, 6));
    }

    /**
     * Calculates the prisoner ID for given coordinates x and y
     *
     * @param x X Coordinate of the prisoner
     * @param y Y Coordinate of the prisoner
     * @return Returns the caclulated prisoner ID
     */
    public static String solution(long x, long y) {

        BigInteger xCoord = BigInteger.valueOf(x);
        BigInteger yCoord = BigInteger.valueOf(y);

        BigInteger maxCoord = xCoord.max(yCoord);
        BigInteger minCoord = xCoord.min(yCoord);

        // Performs (maxCoordinate + minCoordinate - 1) to get the dimension of triangle
        BigInteger dimension = maxCoord.add(minCoord.subtract(BigInteger.ONE));

        // Calculates the starting number of edge on which our prisoner belongs
        // Uses formula : (1 + y * (y + 1) / 2)
        yCoord = (dimension.multiply(dimension.subtract(BigInteger.ONE))).divide(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));

        // Adds the Column value to the calculated start point of an edge and returns the prisoner ID
        // Formula : yCoordinate + (xCoordinate - 1)
        return yCoord.add(xCoord.subtract(BigInteger.ONE)).toString();
    }
}
