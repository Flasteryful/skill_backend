package model;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
@Getter
public class Student {
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("universityId")
    private String universityId;
    @SerializedName("currentCourseNumber")
    private int currentCourseNumber;
    @SerializedName("avgExamScore")
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
