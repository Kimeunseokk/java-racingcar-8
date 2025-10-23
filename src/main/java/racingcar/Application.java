package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LinkedHashMap<String,Integer> carNameMap = getCarNames();
        // for(String value : carNameMap.keySet()){
        //     System.out.print(value);
        // } // --> List에 잘 들어갔는지 디버깅확인용 코드입니다.5
        int attemp = getValue();

        gamestart(carNameMap, attemp);
        
    }
    public static LinkedHashMap<String,Integer> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String car = Console.readLine();
        if(car == null || car.trim().isEmpty()) throw new IllegalArgumentException("입력값이 없습니다.");
        return Arrays.stream(car.split(",")).map(String::trim).collect(Collectors.toMap(name -> name, name -> 0, (v1,v2) -> v1, LinkedHashMap::new));
        // stream의 과정 1. stream 생성 2. 가공 3. 결과
    }

    public static int getValue(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String value = Console.readLine();
        if(value == null || value.trim().isEmpty()) throw new IllegalArgumentException("시행횟수가 입력되지않았습니다.");
        int number = Integer.parseInt(value);
        return number;
    }

    public static int getRandomNumber(){
        int RandNum = Randoms.pickNumberInRange(0,9);
        if(RandNum >= 4) return 1;
        else return -1;
    }

    public static void gamestart(LinkedHashMap<String, Integer> carPoint, int getAttempt){
        for(int i=0; i<getAttempt; i++){
            for(String name : carPoint.keySet()){
                 if(getRandomNumber()==1){ carPoint.put(name,carPoint.getOrDefault(name, 0)+1); }
                 System.out.println(name+" : "+"-".repeat(carPoint.get(name)));
            }
            System.out.println();
        }
        
    }
    
    
}
