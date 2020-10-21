package challenge.shapes;

/**
 * 
 * Triangle class. 
 * 
 * Distinguishes between Equilateral, Isosceles and Scalene triangles. 
 * 
 * extends the abstract Shape class and creates implementation for getArea. 
 * Implements Comparable, comparing on area.  
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
    public static synchronized Triangle createWithLengths(double a, double b, double c) {
        
        // Validate positiveness of the arguments
        if (Double.compare(a, 0.0) <= 0 || Double.compare(b, 0.0) <= 0 || Double.compare(c, 0.0) <= 0) {
            throw new IllegalArgumentException("Arguments can not have non-positive values");
        }

		// Check whether the lengths form a triangle or not (Triangle Inequality Theorem)
		if ((a+b) <= c || (a+c) <= b || (b+c) <= a){
			throw new IllegalArgumentException("Arguments do not form a valid triangle");
		}
        return new Triangle(a, b, c);
	}
	
	@Override
	public double getArea() {
		//calculate semiperimeter 
		double semiPerimeter = (a+b+c)/2; 

		//Herons formula 
		double area = Math.sqrt(semiPerimeter*((semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c))); 

		return area; 
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
     * @return -1, 0, or 1 as this if area of this {@Triangle} is
     *          less than, equal to, or greater than {@code otherTriangle}
     */
    @Override
    public int compareTo(Triangle other) {
        double area = getArea(); 
		double otherArea = other.getArea();
		
        return Double.compare(area, otherArea);
    }

    @Override
    public String toString() {
        return getType().name + " triangle (" + a + ", " + b + ", " + c + ")";
    }

}
