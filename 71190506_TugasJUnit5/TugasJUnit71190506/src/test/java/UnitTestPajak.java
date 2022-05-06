import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnitTestPajak {
    static Pajak pajak;

    @BeforeAll
    static void init(){
        pajak = new Pajak();
    }

    @AfterAll
    static void destroy(){
        pajak = null;
    }


    private static Stream<Arguments> providePajak(){
        return Stream.of(
                Arguments.of(0,1500000),
                Arguments.of(10,5000000),
                Arguments.of(22,20000000),
                Arguments.of(40f,55000000),
                Arguments.of(-1, -1500000),
                Arguments.of(-1, 1500000000000f),
                Arguments.of(0,4000000)
        );
    }

    @ParameterizedTest
    @MethodSource("providePajak")
    void parameterizedTestPajak(float expected, double salary){
        assertEquals(expected, pajak.getPajak(salary));
    }


    private static Stream<Arguments> BVA1Pajak(){
        return Stream.of(
                //BVA vEC1 & vEC2
//                Arguments.of(true,3999999),
//                Arguments.of(true,4000000),
//                Arguments.of(false,4000001)

                //BVA vEC2 & vEC3
                Arguments.of(true, 14999999),
                Arguments.of(true, 15000000),
                Arguments.of(false, 15000001)
//
//                //BVA vEC3 & vEC4
//                Arguments.of(true,39999999),
//                Arguments.of(false,40000000),
//                Arguments.of(false,40000001)

                //BVA vEC4
//                Arguments.of(true,999999999998f),
//                Arguments.of(false,999999999999f),
//                Arguments.of(false,1000000000000d)
        );
    }

    @ParameterizedTest
    @MethodSource("BVA1Pajak")
    void testBVA1Pajak(boolean expected, double salary){
        assertNotNull(pajak);
//        assertEquals(expected, pajak.getPajak(salary)==0);
        assertEquals(expected, pajak.getPajak(salary)==10);
//        assertEquals(expected, pajak.getPajak(salary)==22);
//        assertEquals(expected, pajak.getPajak(salary)==40f);
    }
}
