package comparator;

import model.Student;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAvgExamScore() < o2.getAvgExamScore())
            return 1;
        if (o1.getAvgExamScore() > o2.getAvgExamScore())
            return -1;

        int thisBits    = Float.floatToIntBits(o1.getAvgExamScore());
        int anotherBits = Float.floatToIntBits(o2.getAvgExamScore());

        return (Integer.compare(anotherBits, thisBits));
//
    }

}
