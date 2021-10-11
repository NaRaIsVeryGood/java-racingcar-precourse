package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

@TestMethodOrder(OrderAnnotation.class)
public class ApplicationTest extends NSTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private static final String ERROR_MESSAGE = "[ERROR]";

	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	@Order(7)
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
		int tryCount = 2; 
		assertSimpleTest(() -> {
			run("pobi,woni", String.valueOf(tryCount));
			String output = output().substring( output().indexOf("실행결과"), output().length() ); // 실행결과 만 가지고 오기
			assertThat( output.split("pobi :").length-1 ).isEqualTo(2);
		});
	}

	@Test
	@Order(5)
	void 우승자_메시지리턴_한명우승() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(3, 4, 3,   2, 6, 5);
			run("pobi,woni,bbb","2");
			verify("최종 우승자는 woni 입니다.");
		}
	}

	@Test
	@Order(6)
	void 우승자_메시지리턴_여러명우승() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(1, 4, 3,   1, 3, 4,   1, 4, 4);
			run("pobi,woni,bbb","3");
			verify("최종 우승자는 woni,bbb 입니다.");
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
