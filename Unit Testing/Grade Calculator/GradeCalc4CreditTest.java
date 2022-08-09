import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalc4CreditTest {
    public static GradeCalc4Credit gradeCalc4Credit;

    @BeforeAll
    static void initialize(){
        gradeCalc4Credit = new GradeCalc4Credit();
    }

    @Test
    void invalidMarkTesting1(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("asdd.dc4dsc540"));
    }

    @Test
    void invalidMarkTesting2(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("5.04.02"));
    }

    @Test
    void invalidMarkTesting3(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("@3E3#2.+4"));
    }

    @Test
    void negativeMarkTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("-5.26"));
    }

    @Test
    void negativeMarkSmallValueTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("-0.09"));
    }

    @Test
    void negativeMarkBigValueTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("-45603.8"));
    }

    @Test
    void greaterThanFullMarkTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("465"));
    }

    @Test
    void greaterThanFullMarkSmallValueTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("400.69"));
    }

    @Test
    void greaterThanFullMarkBigValueTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("999"));
    }

    @Test
    void lowerBoundGradeATesting(){
        assertEquals('A', gradeCalc4Credit.calculateGrade("320"));
    }

    @Test
    void lowerBoundGradeALargerTesting(){
        assertEquals('A', gradeCalc4Credit.calculateGrade("320.4"));
    }

    @Test
    void lowerBoundGradeASmallerTesting(){
        assertEquals('A', gradeCalc4Credit.calculateGrade("319.8"));
    }

    @Test
    void GradeATesting(){
        assertEquals('A', gradeCalc4Credit.calculateGrade("357"));
    }

    @Test
    void upperBoundGradeATesting(){
        assertEquals('A', gradeCalc4Credit.calculateGrade("400"));
    }

    @Test
    void upperBoundGradeALargerTesting(){
        assertEquals('X', gradeCalc4Credit.calculateGrade("400.69"));
    }

    @Test
    void upperBoundGradeASmallerTesting(){
        assertEquals('A', gradeCalc4Credit.calculateGrade("398.1"));
    }

    @Test
    void lowerBoundGradeBTesting(){
        assertEquals('B', gradeCalc4Credit.calculateGrade("280"));
    }

    @Test
    void lowerBoundGradeBLargerTesting(){
        assertEquals('B', gradeCalc4Credit.calculateGrade("280.9"));
    }

    @Test
    void lowerBoundGradeBSmallerTesting(){
        assertEquals('B', gradeCalc4Credit.calculateGrade("279.1"));
    }

    @Test
    void GradeBTesting(){
        assertEquals('B', gradeCalc4Credit.calculateGrade("302"));
    }

    @Test
    void upperBoundGradeBTesting(){
        assertEquals('B', gradeCalc4Credit.calculateGrade("319"));
    }

    @Test
    void upperBoundGradeBSmallerTesting(){
        assertEquals('B', gradeCalc4Credit.calculateGrade("318.5"));
    }

    @Test
    void lowerBoundGradeCTesting(){
        assertEquals('C', gradeCalc4Credit.calculateGrade("240"));
    }

    @Test
    void lowerBoundGradeCLargerTesting(){
        assertEquals('C', gradeCalc4Credit.calculateGrade("240.5"));
    }

    @Test
    void lowerBoundGradeCSmallerTesting(){
        assertEquals('C', gradeCalc4Credit.calculateGrade("239.3"));
    }

    @Test
    void GradeCTesting(){
        assertEquals('C', gradeCalc4Credit.calculateGrade("262"));
    }

    @Test
    void upperBoundGradeCTesting(){
        assertEquals('C', gradeCalc4Credit.calculateGrade("279"));
    }

    @Test
    void upperBoundGradeCSmallerTesting(){
        assertEquals('C', gradeCalc4Credit.calculateGrade("278.2"));
    }

    @Test
    void lowerBoundGradeFTesting(){
        assertEquals('F', gradeCalc4Credit.calculateGrade("0"));
    }

    @Test
    void lowerBoundGradeFLargerTesting(){
        assertEquals('F', gradeCalc4Credit.calculateGrade("0.05"));
    }

    @Test
    void GradeFTesting(){
        assertEquals('F', gradeCalc4Credit.calculateGrade("198"));
    }

    @Test
    void upperBoundGradeFTesting(){
        assertEquals('F', gradeCalc4Credit.calculateGrade("239"));
    }

    @Test
    void upperBoundGradeFSmallerTesting(){
        assertEquals('F', gradeCalc4Credit.calculateGrade("238.9"));
    }
}
