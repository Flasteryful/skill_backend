package enums;

public enum StudyProfile {
    PHYSICS("PHYSICS"),
    COMPUTER_SCIENCE("COMPUTER_SCIENCE"),
    MATHEMATICS("MATHEMATICS"),
    JURISPRUDENCE("JURISPRUDENCE"),
    MEDICINE("MEDICINE"),
    LINGUISTICS("LINGUISTICS");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
