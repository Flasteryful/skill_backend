package model;

import enums.StudyProfile;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Statistics {
    private StudyProfile studyProfile;
    private BigDecimal avgExamScore;
    private long amountStudentOnProfile;
    private long amountUniversityOnProfile;
    private List<String> univesityNames;
    public Statistics(){}
}
