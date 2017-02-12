package Shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ShapeTest {
	
	Circle c = new Circle(2.0);
	Rectangle s = new Square(2.0,2.0);
	Rectangle r = new Rectangle(2.0,5.0);
	Triangle t = new Triangle(3.0,4.0);
	
	@Test
	public void testSquare(){
		
		assertEquals("area of square", 4.0, s.getArea(), 0.0);
	}
	
	
	@Test
	public void shapeDuplicates() {
		
		List<Shape> shapeList = new ArrayList<>();
		shapeList.add(new Circle(4));
		shapeList.add(new Circle(4));
		
		Set<Shape> shapes = new HashSet<>();
			shapes.add(new Circle(4));
			shapes.add(new Circle(5));
		    shapes.add(new Rectangle(2.0,2.0));
			shapes.add(new Rectangle(3.0,3.0));
			shapes.add(new Rectangle(2.0,3.0));
			shapes.add(new Rectangle(2.0, 3.0));
			shapes.add(new Triangle(3.0, 2.0));
			shapes.add(new Triangle(3.0, 2.0));

		assertEquals(6, shapes.size());
		assertEquals(2, shapeList.size());
		}
		
	}


