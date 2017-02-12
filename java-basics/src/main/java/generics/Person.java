package generics;

import java.util.ArrayList;
import java.util.List;

public class Person implements Animals{
	
	List<Pet> pets = new ArrayList<>();

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		Person p = new Person();
		p.pets.add(new Pet("Liya"));
		p.pets.add(new Pet("Miya"));
		p.pets.add(new Pet("Siya"));
		
		
	}

}

