package comparator;

import enums.StudentComparatorList;
import enums.UniversityComparatorList;

public class GetComparator {
    private GetComparator() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorList studentComparatorList){
        StudentComparator studentComparator = null;
        switch(studentComparatorList){
            case STUDENT_AVGEXAMSCORE_COMPARATOR -> studentComparator = new StudentAvgExamScoreComparator();
            case STUDENT_CURRENTCOURSENUMBER_COMPARATOR -> studentComparator = new StudentCurrentCourseNumberComparator();
            case STUDENT_FULLNAME_COMPARATOR -> studentComparator = new StudentFullNameComparator();
            case STUDENT_UNIVERSITYID_COMPARATOR -> studentComparator = new StudentUniversityIdComparator();
        }
        return studentComparator;
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorList universityComparatorList){
        UniversityComparator universityComparator = null;
        switch(universityComparatorList){
            case UNIVERSITY_FULLNAME_COMPARATOR -> universityComparator = new UniversityFullNameComparator();
            case UNIVERSITY_ID_COMPARATOR -> universityComparator = new UniversityIdComparator();
            case UNIVERSITY_MAINPROFILE_COMPARATOR -> universityComparator = new UniversityMainProfileComparator();
            case UNIVERSITY_SHORTNAME_COMPARATOR -> universityComparator = new UniversityShortNameComparator();
            case UNIVERSITY_YEAROFFOUNDATION_COMPARATOR -> universityComparator = new UniversityYearOfFoundationComparator();
        }
        return universityComparator;
    }
}