package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
	
	public static Cars cars;
	public static int LOOP_COUNT=0;
	
    public static void main(String[] args) {
		input();
		play();
		result();
    }

    public static void input() {
    	boolean loopStat = true;
    	while(loopStat) {
    		loopStat = inputCars();
    	}
    	loopStat = true;
    	while(loopStat) {
    		loopStat = inputLoopCount();
    	}
    }
    
    public static void play() {
    	System.out.println("\n실행결과");
    	while(LOOP_COUNT > 0) {
    		carRacing();
    		LOOP_COUNT--;
    	}
    }
    
	public static boolean inputCars() {
		try {
	    	System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준 구분)");
			String inputVal = Console.readLine();
			System.out.println(inputVal);
			cars = new Cars(inputVal);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return true;
		}
		return false;
    }

	public static boolean inputLoopCount() {
    	System.out.println("시도할 횟수는 몇회 인가요?");
    	String inputVal = Console.readLine();
    	System.out.println(inputVal);
    	try {
    		LOOP_COUNT = Integer.parseInt(inputVal);
    	} catch (NumberFormatException e) {
    		System.out.println("[ERROR] 숫자를 입력 하세요.");
    		return true;
    	}
    	return false;
	}
    
    public static int carRacingRandomGoAndStopReturn() {
    	int randomVal = Randoms.pickNumberInRange(0, 9);
    	if(randomVal <= 3) {
    		return 0;	// 멈춤
    	}
    	return 1;	// 전진
    }
    
    public static void carRacing() {
    	for(Car car : cars.getCars()) {
    		car.setStack(car.getStack()+carRacingRandomGoAndStopReturn());
    		System.out.printf("%s : %s\n", car.getName(), car.getCarStackPrintBar());
    	}
    	System.out.println();
    }
    
    public static void result() {
    	Collections.sort(cars.getCars());
    	
    	int maxStack = cars.getCars().get(0).getStack();
    	List<String> winnerCars = new ArrayList<String>();
    	
    	for(Car car : cars.getCars()) {
    		winnerCar(winnerCars, maxStack, car);
    	}
    	System.out.println("최종 우승자는 " +  String.join(",", winnerCars) + " 입니다.");
    }
    
    public static void winnerCar(List<String> winnerCars, int maxStack, Car car) {
    	if(maxStack == car.getStack()) {
    		winnerCars.add(car.getName());
    	}
    }
    
}
