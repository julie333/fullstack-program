package generics;

public class Bird extends AbstractAnimals implements Animals {

	private final String name;

	public Bird(String name) {
		this.name = name;
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "tweet";
	}

	public String getName() {
		return this.name;
	}

	public String generateMessage() {
		return String.format(getAnimalTemplate(), new Bird("Biba"), getName(), speak());
	}

}
