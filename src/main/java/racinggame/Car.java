package racinggame;

public class Car {
	
	private static final int CAR_NAME_SIZE = 5;
	
	private String name;

	public Car(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		sizeValidation(name);
		this.name = name;
	}
	
	private void sizeValidation(String name) {
		if(name.length() > CAR_NAME_SIZE) {
			throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
		}
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}
	
	
}
