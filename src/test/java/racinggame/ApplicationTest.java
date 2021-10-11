package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Disabled
    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    @Order(3)
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    @Order(1)
    void 이름_입력_받기_자릿수() {
    	Car car = new Car("aaa");
    	assertThat(car.getName()).contains("aaa");
    	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
    		car.setName("bbbbbbbbbbbbbbbbbbb");
    	});
    }
    @Test
    @Order(2)
    void 이름_입력_받기_쉼표() {
    	assertSimpleTest(() -> {
    		runNoLineFound("pobi,,woni","pobi,woni, ");
    		verify(ERROR_MESSAGE);
    	});
    }
    
    @Test
    @Order(4)
    void 시도횟수() {
    	assertSimpleTest(() -> {
    		runNoLineFound("pobi,woni","fff");
    		verify(ERROR_MESSAGE);
    	});
    	assertSimpleTest(() -> {
    		run("pobi,woni","2");
    		verify("Finish");
    	});
    }
    
    @Test
    @Order(5)
    void 전진_정지2() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3, 4, 4, 3);
            run("pobi,woni","2");
            verify("Finish");
        }
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
