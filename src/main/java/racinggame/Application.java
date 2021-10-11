package racinggame;

import nextstep.utils.Console;

public class Application {
	
	public static Cars cars;
	
    public static void main(String[] args) {

    	while(true) {
    		try {
    			play();
    		} catch (IllegalArgumentException e) {
    			System.out.println(e.getMessage());
    			continue;
    		}
    	}
    	
    }
    
    public static void play() {
    	cars = inputCars();
    }
    
    public static Cars inputCars() {
    	System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준 구분)");
		String inputCars = Console.readLine();
		return new Cars(inputCars);
    }
    
}
