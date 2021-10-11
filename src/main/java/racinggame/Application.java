package racinggame;

import nextstep.utils.Console;

public class Application {
	
	public static Cars cars;
	public static int LOOP_COUNT=0;
	
    public static void main(String[] args) {

    	while(true) {
    		play();
    	}
    	
    }
    
    public static void play() {
    	boolean loopStat = true;
    	while(loopStat) {
    		loopStat = inputCars();
    	}
    	
    	loopStat = true;
    	while(loopStat) {
    		loopStat = inputLoopCount();
    	}
    	
    	System.out.println("Finish");
    }
    
	public static boolean inputCars() {
		try {
	    	System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준 구분)");
			String inputCars = Console.readLine();
			cars = new Cars(inputCars);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return true;
		}
		return false;
    }

    private static boolean inputLoopCount() {
    	System.out.println("시도할 횟수는 몇회 인가요?");
    	String inputVal = Console.readLine();
    	try {
    		LOOP_COUNT = Integer.parseInt(inputVal);
    	} catch (NumberFormatException e) {
    		System.out.println("[ERROR] 숫자를 입력 하세요.");
    		return true;
    	}
    	return false;
	}

}
