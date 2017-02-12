package generics;

public class Dog extends AbstractAnimals implements Animals {

	private final String name;

	public Dog(String name) {
		this.name = name;
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "woof";
	}

	public String getName() {
		return this.name;
	}

	public String generateMessage() {
		return String.format(getAnimalTemplate(), new Dog("Bob"), getName(), speak());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	
	
	
}
