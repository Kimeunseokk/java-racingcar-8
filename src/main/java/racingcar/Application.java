package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNamelist = getCarName();
        int num = getValue();

    }
    public static List<String> getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String car = Console.readLine();
        if(car == null) throw new IllegalArgumentException("입력값이 없습니다.");
        return Arrays.asList(car.split(","));
    }
    public static int getValue(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String value = Console.readLine();
        if(value == null) throw new IllegalArgumentException("시행횟수가 입력되지않았습니다.");
        int number = Integer.parseInt(value);
        return number;
    }
}
