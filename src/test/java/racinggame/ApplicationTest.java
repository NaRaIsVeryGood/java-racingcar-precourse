package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 이름_입력_받기_자릿수() {
    	Car car = new Car("aaa");
    	assertThat(car.getName()).contains("aaa");
    	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
    		car.setName("bbbbbbbbbbbbbbbbbbb");
    	});
    }
    @Test
    void 이름_입력_받기_쉼표() {
    	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
    		run("pobi,,woni","pobi,woni, ");
    	});
    }
    
    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
