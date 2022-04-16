

import comparator.GetComparator;
import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorList;
import enums.StudyProfile;
import enums.UniversityComparatorList;
import lombok.*;
import model.Statistics;
import model.Student;
import model.University;
import service.JsonUtil;
import service.Reader;
import service.StatisticsProcessUtil;
import service.XlsWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        StudentComparator studentComparator = GetComparator.getStudentComparator(StudentComparatorList.STUDENT_AVGEXAMSCORE_COMPARATOR);
        UniversityComparator universityComparator = GetComparator.getUniversityComparator(UniversityComparatorList.UNIVERSITY_FULLNAME_COMPARATOR);

        Student student0 = new Student();
        student0.setFullName("Иванов А.С.");
        student0.setUniversityId("657");
        student0.setCurrentCourseNumber(4);
        student0.setAvgExamScore(4.7f);
        Student student1 = new Student();
        student1.setFullName("Иванов А.С.");
        student1.setUniversityId("657");
        student1.setCurrentCourseNumber(5);
        student1.setAvgExamScore(4.8f);
        List<Student> students = new ArrayList<>();
        students.add(student0);
        students.add(student1);
        students.stream().filter(student -> student.getAvgExamScore() == 4.8f)
                .peek(student -> System.out.println("filter " + JsonUtil.StudentSerialize(student)))
                .peek(student -> System.out.println("filter " + JsonUtil.StudentDeserialize(JsonUtil.StudentSerialize(student))))
                .collect(Collectors.toList());


        XlsWriter xlsWriter = new XlsWriter();
        xlsWriter.writeStatistics(StatisticsProcessUtil.collectStatistics(Reader.readStudent(),Reader.readUniversity()),"universityInfo.xlsx");

    }
}
