package racinggame;

public class Car implements Comparable<Car> {
	
	private static final int CAR_NAME_SIZE = 5;
	
	private String name;
	private int stack = 0;

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
	
	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	private void sizeValidation(String name) {
		if (name.length() > CAR_NAME_SIZE) {
			throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
		}
	}

	public String getCarStackPrintBar() {
		StringBuilder strReturn = new StringBuilder();
		for (int i=0; i< this.stack; i++) {
			strReturn.append("-");
		}
		return strReturn.toString();
	}

	@Override
	public int compareTo(Car o) {
		if (this.stack < o.getStack()) {
			return 1;
		} 
		if (this.stack > o.getStack()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", stack=" + stack + "]";
	}
	
}
