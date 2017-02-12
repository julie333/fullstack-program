package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnimalsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Animals> animals = new ArrayList<>();
		Set<Animals> animalSet = new HashSet<>();
		
		animals.add(new Dog("Sparky"));
		animals.add(new Dog("Sparky"));
		animals.add(new Dog("Snarky"));
		animalSet.add(new Dog("Sparky"));
		animalSet.add(new Dog("Snarky"));
		
		System.out.println("Animals: " + animals);
		System.out.println("AnimalsSet: " + animalSet);
		

	}

}
