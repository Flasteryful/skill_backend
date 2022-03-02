

import comparator.GetComparator;
import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorList;
import enums.UniversityComparatorList;
import service.Reader;


public class Main {
    public static void main(String[] args) {

        StudentComparator studentComparator = GetComparator.getStudentComparator(StudentComparatorList.STUDENT_AVGEXAMSCORE_COMPARATOR);
        UniversityComparator universityComparator = GetComparator.getUniversityComparator(UniversityComparatorList.UNIVERSITY_FULLNAME_COMPARATOR);


        Reader.readStudent().stream().sorted(studentComparator).forEach(System.out::println);
//        Reader.readUniversity().stream().sorted(universityComparator).forEach(System.out::println);

    }
}
