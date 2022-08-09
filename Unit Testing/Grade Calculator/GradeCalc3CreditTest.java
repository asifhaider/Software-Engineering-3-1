import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalc3CreditTest {
    public static GradeCalc3Credit gradeCalc3Credit;

    @BeforeAll
    static void initialize(){
        gradeCalc3Credit = new GradeCalc3Credit();
    }

    @Test
    void invalidMarkTesting1(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("sasfse"));
    }

    @Test
    void invalidMarkTesting2(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("10.20.30"));
    }

    @Test
    void invalidMarkTesting3(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("-154+36"));
    }

    @Test
    void negativeMarkTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("-10"));
    }

    @Test
    void negativeMarkSmallValueTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("-0.01"));
    }

    @Test
    void negativeMarkBigValueTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("-1000"));
    }

    @Test
    void greaterThanFullMarkTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("410"));
    }

    @Test
    void greaterThanFullMarkSmallValueTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("400.25"));
    }

    @Test
    void greaterThanFullMarkBigValueTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("10000"));
    }

    @Test
    void lowerBoundGradeATesting(){
        assertEquals('A', gradeCalc3Credit.calculateGrade("240"));
    }

    @Test
    void lowerBoundGradeALargerTesting(){
        assertEquals('A', gradeCalc3Credit.calculateGrade("240.04"));
    }

    @Test
    void lowerBoundGradeASmallerTesting(){
        assertEquals('A', gradeCalc3Credit.calculateGrade("239.1"));
    }

    @Test
    void GradeATesting(){
        assertEquals('A', gradeCalc3Credit.calculateGrade("320"));
    }

    @Test
    void upperBoundGradeATesting(){
        assertEquals('A', gradeCalc3Credit.calculateGrade("400"));
    }

    @Test
    void upperBoundGradeALargerTesting(){
        assertEquals('X', gradeCalc3Credit.calculateGrade("400.25"));
    }

    @Test
    void upperBoundGradeASmallerTesting(){
        assertEquals('A', gradeCalc3Credit.calculateGrade("399.6"));
    }

    @Test
    void lowerBoundGradeBTesting(){
        assertEquals('B', gradeCalc3Credit.calculateGrade("210"));
    }

    @Test
    void lowerBoundGradeBLargerTesting(){
        assertEquals('B', gradeCalc3Credit.calculateGrade("210.25"));
    }

    @Test
    void lowerBoundGradeBSmallerTesting(){
        assertEquals('B', gradeCalc3Credit.calculateGrade("209.7"));
    }

    @Test
    void GradeBTesting(){
        assertEquals('B', gradeCalc3Credit.calculateGrade("225"));
    }

    @Test
    void upperBoundGradeBTesting(){
        assertEquals('B', gradeCalc3Credit.calculateGrade("239"));
    }

    @Test
    void upperBoundGradeBSmallerTesting(){
        assertEquals('B', gradeCalc3Credit.calculateGrade("238.2"));
    }

    @Test
    void lowerBoundGradeCTesting(){
        assertEquals('C', gradeCalc3Credit.calculateGrade("180"));
    }

    @Test
    void lowerBoundGradeCLargerTesting(){
        assertEquals('C', gradeCalc3Credit.calculateGrade("180.4"));
    }

    @Test
    void lowerBoundGradeCSmallerTesting(){
        assertEquals('C', gradeCalc3Credit.calculateGrade("179.5"));
    }

    @Test
    void GradeCTesting(){
        assertEquals('C', gradeCalc3Credit.calculateGrade("198"));
    }

    @Test
    void upperBoundGradeCTesting(){
        assertEquals('C', gradeCalc3Credit.calculateGrade("209"));
    }

    @Test
    void upperBoundGradeCSmallerTesting(){
        assertEquals('C', gradeCalc3Credit.calculateGrade("208.3"));
    }

    @Test
    void lowerBoundGradeFTesting(){
        assertEquals('F', gradeCalc3Credit.calculateGrade("0"));
    }

    @Test
    void lowerBoundGradeFLargerTesting(){
        assertEquals('F', gradeCalc3Credit.calculateGrade("0.05"));
    }

    @Test
    void GradeFTesting(){
        assertEquals('F', gradeCalc3Credit.calculateGrade("100"));
    }

    @Test
    void upperBoundGradeFTesting(){
        assertEquals('F', gradeCalc3Credit.calculateGrade("179"));
    }

    @Test
    void upperBoundGradeFSmallerTesting(){
        assertEquals('F', gradeCalc3Credit.calculateGrade("178.6"));
    }
}
