package model;


import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.EqualsAndHashCode;
import lombok.Getter;



@EqualsAndHashCode
@Getter
@XStreamAlias("studentEntry")
public class Student {
    @SerializedName("fullName")
    @XStreamAlias("studentName")
    private String fullName;

    @SerializedName("universityId")
    @XStreamAlias("universityId")
    private String universityId;

    @SerializedName("currentCourseNumber")
    @XStreamOmitField
    private int currentCourseNumber;

    @SerializedName("avgExamScore")
    @XStreamAlias("avgScore")
    private float avgExamScore;

    public Student() {
    }

    public String fullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String universityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int currentCourseNumber() {
        return currentCourseNumber;
    }

    public int setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return currentCourseNumber;
    }

    public float avgExamScore() {
        return avgExamScore;
    }

    public float setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return avgExamScore;
    }


    @Override
    public String toString() {
        return "model.Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}
