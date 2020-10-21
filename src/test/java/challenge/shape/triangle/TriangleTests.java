package challenge.shape.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import challenge.shapes.Triangle;

class TriangleTests {



	@Test
	public void successfulCreation() {
        Triangle.createWithLengths(5, 5, 5);
        Triangle.createWithLengths(100.00001, 900, 1000);
        Triangle.createWithLengths(5, 6.000001, 11);
        Triangle.createWithLengths(5, 6.000001, 11);
        Triangle.createWithLengths(5.1, 6.81, 11.9);
	}

	@Test 
	public void unsuccessfulCreation1(){
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(-5, 5, 5));
		assertEquals("Arguments can not have non-positive values", exception.getMessage());
	}

	public void unsuccessfulCreation2(){
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Triangle.createWithLengths(2, 4, 10));
		assertEquals("Arguments do not form a valid triangle", exception.getMessage());
	}


	@Test 
	public void testAreaCalculation(){

		assertEquals(Triangle.createWithLengths(5, 5, 5).getArea(), 10.825317547305483); 
		assertEquals(Triangle.createWithLengths(4, 4, 4).getArea(), 6.928203230275509); 
	}


	
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

}
