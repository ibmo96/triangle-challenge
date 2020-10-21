package challenge.shape.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import challenge.shapes.Triangle;

class TriangleTests {



	//successful triangle creations
	@Test
	public void successfulCreation() {
        Triangle.createWithLengths(5, 5, 5);
        Triangle.createWithLengths(100.00001, 900, 1000);
        Triangle.createWithLengths(5, 6.000001, 11);
        Triangle.createWithLengths(5, 6.000001, 11);
        Triangle.createWithLengths(5.1, 6.81, 11.9);
	}


	//Testing for unsuccessful triangle creations. One case for a negative side and another for when the sum of two sides is less that than a third. 
	@Test 
	public void unsuccessfulCreation1(){
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(-5, 5, 5));
		assertEquals("Arguments can not have non-positive values", exception.getMessage());

		Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(5, -5, 5));
		assertEquals("Arguments can not have non-positive values", exception2.getMessage());

		Throwable exception3 = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(5, 5, -5));
		assertEquals("Arguments can not have non-positive values", exception3.getMessage());
	}

	@Test
	public void unsuccessfulCreation2(){
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(2, 4, 10));
		assertEquals("Arguments do not form a valid triangle", exception.getMessage());

		Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(20, 5, 4));
		assertEquals("Arguments do not form a valid triangle", exception2.getMessage());

		Throwable exception3 = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(5, 32.2, 10));
		assertEquals("Arguments do not form a valid triangle", exception3.getMessage());
	}


	//Testing to see if the area function works
	@Test 
	public void testAreaCalculation(){

		assertEquals(Triangle.createWithLengths(5, 5, 5).getArea(), 10.825317547305483); 
		assertEquals(Triangle.createWithLengths(4, 4, 4).getArea(), 6.928203230275509); 
		assertEquals(Triangle.createWithLengths(2, 2, 2).getArea(), 1.7320508075688772); 
	}
	

	
	//Testing the type assertion. 
	@Test
    public void testGetType(){

        assertEquals(Triangle.Type.EQUILATERAL, Triangle.createWithLengths(1, 1, 1).getType());
        assertEquals(Triangle.Type.SCALENE, Triangle.createWithLengths(100.00001, 900, 1000).getType());
        assertEquals(Triangle.Type.EQUILATERAL, Triangle.createWithLengths(0.00001, 0.00001, 0.00001).getType());
        assertEquals(Triangle.Type.ISOSCELES, Triangle.createWithLengths(1.00001, 0.5, 1.00001).getType());
        assertEquals(Triangle.Type.SCALENE, Triangle.createWithLengths(5, 6.000001, 11).getType());
        assertEquals(Triangle.Type.SCALENE, Triangle.createWithLengths(5.1, 6.81, 11.9).getType());
        assertEquals(Triangle.Type.ISOSCELES, Triangle.createWithLengths(1000, 7, 1000).getType());
        assertEquals(Triangle.Type.ISOSCELES, Triangle.createWithLengths(1, 0.9999999, 0.9999999).getType());
        assertEquals(Triangle.Type.EQUILATERAL, Triangle.createWithLengths(1000.00001, 1000.00001, 1000.00001).getType());
        assertEquals(Triangle.Type.SCALENE, Triangle.createWithLengths(0.99, 0.9900000001, 1).getType());
	}
	

	//Testing compareTo method by creating a list of Triangle (internally sorted on areas) and another list of where the same triangles are inserted in sorted order. 
	@Test 
	public void testTriangleComparing(){

		List<Triangle> trianglesUnsorted = new ArrayList<>(); 
		List<Triangle> trianglesSorted = new ArrayList<>(); 

		trianglesUnsorted.add(Triangle.createWithLengths(5, 5, 5)); 
		trianglesUnsorted.add(Triangle.createWithLengths(2, 2, 2)); 
		trianglesUnsorted.add(Triangle.createWithLengths(4, 4, 4)); 
		
		trianglesSorted.add(Triangle.createWithLengths(2, 2, 2));
		trianglesSorted.add(Triangle.createWithLengths(4, 4, 4));  
		trianglesSorted.add(Triangle.createWithLengths(5, 5, 5)); 

		Collections.sort(trianglesUnsorted); 

		assertEquals(trianglesUnsorted.get(0).getArea(), trianglesSorted.get(0).getArea()); 
		assertEquals(trianglesUnsorted.get(1).getArea(), trianglesSorted.get(1).getArea()); 
		assertEquals(trianglesUnsorted.get(2).getArea(), trianglesSorted.get(2).getArea()); 
		
	}


	@Test
	public void testToString(){

		Triangle tester = Triangle.createWithLengths(5, 5, 5); 

		assertEquals(tester.toString(), "Equilateral triangle (5.0, 5.0, 5.0)"); 
	}

}
