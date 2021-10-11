package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	
	private List<Car> cars = new ArrayList<Car>();
	
	public Cars(String strCars) {
		String[] arrayCars = strCars.split(",");
		for (int i = 0; i < arrayCars.length; i++) {
			cars.add(new Car(isEmpty(arrayCars[i])));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	private String isEmpty(String name) {
		if (name == null || "".equals(name.trim())) {
			throw new IllegalArgumentException("[ERROR] 빈값이 들어가선 안됩니다.");
		}
		return name.trim();
	}

	@Override
	public String toString() {
		return "Cars [cars=" + cars + "]";
	}
	
}
