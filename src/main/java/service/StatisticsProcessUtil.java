package service;

import comparator.GetComparator;
import enums.StudyProfile;
import lombok.*;
import model.Statistics;
import model.Student;
import model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class StatisticsProcessUtil {
    private static final Logger log = (Logger) LoggerFactory.getLogger(StatisticsProcessUtil.class);
    private StatisticsProcessUtil() {
    }

    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class StudentCharachter {
        private long studentCount;
        private Double studentAvgExamScore;
        private StudyProfile mainProfile;
    }

    public static Set<Statistics> collectStatistics(List<Student> students, List<University> universities) {
        Set<Statistics> collectStatistics = new HashSet<>();
        List<StudentCharachter> studentCharachters = new ArrayList<>();
        Set<Statistics> collectStatisticsClean = new HashSet<>();
        log.info("Trying collect statistics");

        getStudentsGroupingByStudyProfile(students, universities, studentCharachters);
        log.info("Students lists grouped by study profile");
        getUnivecitiesGroupingByStudyProfile(universities, studentCharachters, collectStatistics);
        log.info("Universities lists grouped by study profile");
        collectStatistics.stream()
                .collect(Collectors.groupingBy(Statistics::getStudyProfile)).values()
                .forEach(list -> {
                    if (list.size() > 1) {
                        AtomicReference<Double> avg = new AtomicReference<>((double) 0);
                        AtomicInteger amountStudentOnProfile = new AtomicInteger();
                        AtomicInteger count = new AtomicInteger(0);
                        list.forEach(statistics -> {
                            if (statistics.getAvgExamScore().doubleValue() != 0) {
                                count.updateAndGet(v -> v + 1);
                            }
                            avg.updateAndGet(v -> v + statistics.getAvgExamScore().doubleValue());
                            amountStudentOnProfile.addAndGet((int) statistics.getAmountStudentOnProfile());
                        });
                        collectStatisticsClean.add(Statistics.builder()
                                .studyProfile(list.get(0).getStudyProfile())
                                .avgExamScore(BigDecimal.valueOf(avg.get()).divide(BigDecimal.valueOf(count.get()), 2, RoundingMode.HALF_UP))
                                .amountStudentOnProfile(amountStudentOnProfile.get())
                                .amountUniversityOnProfile(list.get(0).getUnivesityNames().size())
                                .univesityNames(list.get(0).getUnivesityNames())
                                .build());
                    } else {
                        collectStatisticsClean.add(list.get(0));
                    }
                });
        log.info("Statistics returned");
        return collectStatisticsClean;
    }

    private static void getStudentsGroupingByStudyProfile(List<Student> students, List<University> universities, List<StudentCharachter> studentCharachters) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getUniversityId)).values()
                .forEach(list -> universities.forEach(university -> {
                    if (list.get(0).getUniversityId().equals(university.getId())) {
                        studentCharachters.add(StudentCharachter.builder()
                                .studentCount(list.size())
                                .studentAvgExamScore(list.stream()
                                        .mapToDouble(Student::getAvgExamScore)
                                        .average().getAsDouble())
                                .mainProfile(university.getMainProfile())
                                .build());
                    }
                }));
    }

    private static void getUnivecitiesGroupingByStudyProfile(List<University> universities, List<StudentCharachter> studentCharachters, Set<Statistics> collectStatistics) {
        universities.stream()
                .collect(Collectors.groupingBy(University::getMainProfile,
                        Collectors.mapping(University::getFullName, Collectors.toList())))
                .forEach((key, value) -> studentCharachters.forEach(studentCharachter -> {
                    if (key.equals(studentCharachter.getMainProfile())) {
                        collectStatistics.add(Statistics.builder()
                                .studyProfile(key)
                                .avgExamScore(BigDecimal.valueOf(studentCharachter.getStudentAvgExamScore()).setScale(2, RoundingMode.HALF_UP))
                                .amountUniversityOnProfile(value.size())
                                .amountStudentOnProfile(studentCharachter.getStudentCount())
                                .univesityNames(value)
                                .build());
                    } else {
                        collectStatistics.add(Statistics.builder()
                                .studyProfile(key)
                                .amountUniversityOnProfile(1)
                                .avgExamScore(BigDecimal.valueOf(0))
                                .univesityNames(value)
                                .build());
                    }
                }));
    }
}
