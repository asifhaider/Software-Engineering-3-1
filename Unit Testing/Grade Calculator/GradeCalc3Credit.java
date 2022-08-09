class GradeCalc3Credit extends GradeCalculator{
    @Override
    public char calculateGrade(String marks) {
        char grade = super.calculateGrade(marks);
        if(grade == 'X')
            return 'X';

        double primaryMarks = Double.parseDouble(marks);
        double roundedMarks = (int)primaryMarks;
        if(primaryMarks - roundedMarks > 0)
            roundedMarks++;

        if(roundedMarks >= A_MIN_3_CRED_MARKS && roundedMarks <= HIGHEST_POSSIBLE_MARKS){
            return 'A';
        } else if(roundedMarks >= B_MIN_3_CRED_MARKS && roundedMarks <= B_MAX_3_CRED_MARKS){
            return 'B';
        } else if(roundedMarks >= C_MIN_3_CRED_MARKS && roundedMarks <= C_MAX_3_CRED_MARKS){
            return 'C';
        } else
            return 'F';
    }
}