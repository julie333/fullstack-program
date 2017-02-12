package generics;

public class Cat extends AbstractAnimals implements Animals {

	private final String name;

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "meow";
	}

	public String getName() {
		return this.name;
	}

	public String generateMessage() {
		return String.format(getAnimalTemplate(), new Dog("Bun"), getName(), speak());
	}

}
