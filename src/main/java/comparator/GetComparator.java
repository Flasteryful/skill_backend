package comparator;

import enums.StudentComparatorList;
import enums.UniversityComparatorList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.Reader;

public class GetComparator {
    private static final Logger log = (Logger) LoggerFactory.getLogger(GetComparator.class);

    private GetComparator() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorList studentComparatorList) {
        log.info("Trying select student comparator");
        StudentComparator studentComparator = null;
        switch (studentComparatorList) {
            case STUDENT_AVGEXAMSCORE_COMPARATOR -> studentComparator = new StudentAvgExamScoreComparator();
            case STUDENT_CURRENTCOURSENUMBER_COMPARATOR -> studentComparator = new StudentCurrentCourseNumberComparator();
            case STUDENT_FULLNAME_COMPARATOR -> studentComparator = new StudentFullNameComparator();
            case STUDENT_UNIVERSITYID_COMPARATOR -> studentComparator = new StudentUniversityIdComparator();
        }
        log.info("Selected comparator: " + studentComparator);
        return studentComparator;
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorList universityComparatorList) {
        log.info("Trying select university comparator");
        UniversityComparator universityComparator = null;
        switch (universityComparatorList) {
            case UNIVERSITY_FULLNAME_COMPARATOR -> new UniversityFullNameComparator();
            case UNIVERSITY_ID_COMPARATOR -> new UniversityIdComparator();
            case UNIVERSITY_MAINPROFILE_COMPARATOR -> new UniversityMainProfileComparator();
            case UNIVERSITY_SHORTNAME_COMPARATOR -> new UniversityShortNameComparator();
            case UNIVERSITY_YEAROFFOUNDATION_COMPARATOR -> new UniversityYearOfFoundationComparator();
        }
        log.info("Selected comparator: " + universityComparator);
        return universityComparator;
    }
}