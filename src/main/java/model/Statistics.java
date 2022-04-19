package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
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
@XStreamAlias("statisticsEntry")
public class Statistics {
    @XStreamAlias("universityProfile")
    private StudyProfile studyProfile;

    @XStreamAlias("avgScore")
    private BigDecimal avgExamScore;

    @XStreamOmitField
    private long amountStudentOnProfile;

    @XStreamOmitField
    private long amountUniversityOnProfile;

    @XStreamOmitField
    private List<String> univesityNames;
}
