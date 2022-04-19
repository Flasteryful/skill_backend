package model;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import enums.StudyProfile;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@XStreamAlias("universityEntry")
public class University {
    @SerializedName("id")
    @XStreamAlias("universityId")
    private String id;

    @SerializedName("fullName")
    @XStreamOmitField
    private String fullName;

    @SerializedName("shortName")
    @XStreamAlias("universityName")
    private String shortName;

    @SerializedName("yearOfFoundation")
    @XStreamOmitField
    private int yearOfFoundation;

    @SerializedName("mainProfile")
    @XStreamAlias("universityProfile")
    StudyProfile mainProfile;

    public University() {
    }

    public String id() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String fullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String shortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int yearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile mainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "model.University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
