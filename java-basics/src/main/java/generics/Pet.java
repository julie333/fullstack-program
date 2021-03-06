package generics;

public class Pet implements Animals {


	private final String name;

	public Pet(String name) {
		this.name = name;
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "helloIamyourpet";
	}

	public String getName() {
		return this.name;
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
		Pet other = (Pet) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	
	
	
}