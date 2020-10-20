package challenge.shapes;

/**
 * 
 * Triangle class. 
 * 
 * extends the abstract Shape class with 
 * 
 * @author Ibrahim Louay Mohammad
 *         
 * @version 2020.10.19
 * 
 */
public class Triangle extends Shape implements Comparable<Triangle> {

	
	public static enum Type  {
        EQUILATERAL("Equilateral"),
        ISOSCELES("Isosceles"),
        SCALENE("Scalene");

        private final String name;

        private Type(String name) {
            this.name = name;
        }
    }

	
    // Length of three sides of triangle
    private final double a, b, c;

    /**
     * private Constructor, only accessible through static factory methods
     *
     * @param a length of side 1
     * @param b length of side 2
     * @param c length of side 3
     */
    private Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Returns a new {@code Triangle} based on the length of the sides of
     * triangle.
     *
     * @param a length of side 1
     * @param b length of side 2
     * @param c length of side 3
     * @return a new {@code Triangle} based on the length of the sides of
     * triangle
     * @throws IllegalArgumentException if any of the parameters has
     * non-positive value, or these parameters could not form a valid triangle
     */
    public static Triangle ofLengths(double a, double b, double c) {
        
        // Validate positiveness of the arguments
        if (Double.compare(a, 0.0) <= 0 || Double.compare(b, 0.0) <= 0 || Double.compare(c, 0.0) <= 0) {
            throw new IllegalArgumentException("Arguments can not have non-positive values");
        }

        // Validate finiteness of the arguments
        if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(c)) {
            throw new IllegalArgumentException("Arguments can not have infinite values");
        }

        // Convert to double for accurate calculation
        double tempA = double.valueOf(a);
        double tempB = double.valueOf(b);
        double tempC = double.valueOf(c);

        // Check whether the lengths form a triangle or not
        if (tempA.add(tempB).compareTo(tempC) <= 0 || tempA.add(tempC).compareTo(tempB) <= 0 || tempB.add(tempC).compareTo(tempA) <= 0) {
            throw new IllegalArgumentException("Arguments do not form a valid triangle");
        }
        return new Triangle(tempA, tempB, tempC);
    }

    /**
     * Returns type of triangle, based on length of its sides. Triangle can be
     * {@link Type#EQUILATERAL}, {@link Type#ISOSCELES} or {@link Type#SCALENE}.
     *
     * @return type of triangle
     */
    public Type getType() {
        if (Double.compare(a,b) == 0 && Double.compare(b,c) == 0) {
            return Type.EQUILATERAL;
        } else if (Double.compare(a,b) == 0 || Double.compare(a,c) == 0 || Double.compare(b,c) == 0) {
            return Type.ISOSCELES;
        } else {
            return Type.SCALENE;
        }
    }

    /**
     * Compares this {@code Triangle} with another {@code Triangle} based on
     * their areas.
     * 
     * @param other {@code Triangle} to which this {@code Triangle}
     *        is  to be compared
     * @return -1, 0, or 1 as this if perimeter of this {@Triangle} is
     *          less than, equal to, or greater than {@code otherTriangle}
     */
    @Override
    public int compareTo(Triangle other) {
        double currPerimeter = a.add(b).add(c);
        double otherPerimeter = other.a.add(other.b).add(other.c);
        return currPerimeter.compareTo(otherPerimeter);
    }

    @Override
    public String toString() {
        return getType().name + " triangle (" + a + ", " + b + ", " + c + ")";
    }
}
