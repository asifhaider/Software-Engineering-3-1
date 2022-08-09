public class GradeCalculator {
    public static final double LOWEST_POSSIBLE_MARKS = 0;
    public static final double HIGHEST_POSSIBLE_MARKS = 400;

    public static final double A_MIN_3_CRED_MARKS = 240;
    public static final double B_MIN_3_CRED_MARKS = 210;
    public static final double B_MAX_3_CRED_MARKS = 239;
    public static final double C_MIN_3_CRED_MARKS = 180;
    public static final double C_MAX_3_CRED_MARKS = 209;



    public static final double A_MIN_4_CRED_MARKS = 320;
    public static final double B_MIN_4_CRED_MARKS = 280;
    public static final double B_MAX_4_CRED_MARKS = 319;
    public static final double C_MIN_4_CRED_MARKS = 240;
    public static final double C_MAX_4_CRED_MARKS = 279;

    public char calculateGrade(String marks){
        double totalMarks;
        try{
            totalMarks = Double.parseDouble(marks);
        } catch(Exception e){
            System.out.println("Not a valid marks number");
            return 'X';
        }
        if(totalMarks < LOWEST_POSSIBLE_MARKS){
            System.out.println("Negative marks not possible");
            return 'X';
        } else if(totalMarks > HIGHEST_POSSIBLE_MARKS) {
            System.out.println("Greater than full marks");
            return 'X';
        }
        return 'P'; // dummy grade
    }
}