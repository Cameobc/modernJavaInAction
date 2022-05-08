package stream.practice;

import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("mario", "Milan");
        Trader alan = new Trader("alan", "Cambridge");
        Trader brian = new Trader("brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.2011 년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리

        //2. 거래자가 근무하는 모든 도시를 중복 없이 나열

        //3. 케임브릿지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬

        //4. 모든 거래자의 이름을 알파벳순으로 정렬하여 반환

        //5. 밀라노에 거래자가 있는지?

        //6. 케임브릿지에 거주하는 거래자의 모든 트랜잭션을 출력

        //7. 전체 트랜잭션 중 최댓값은 얼마?

        //8. 전체 트랜잭션 중 최솟값은 얼마?
    }
}
