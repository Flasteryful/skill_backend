public class Main {
    public static void main(String[] args) {
        University university = new University()
                .setId("1")
                .setFullName("Российский экономический университет им. Г.В.Плеханова")
                .setShortName("РЭУ им. Г.В.Плеханова")
                .setYearOfFoundation(-1983882790)
                        .setMainProfile(StudyProfile.ECONOMYST);
        System.out.println(university);

        Student student = new Student()
                .setFullName("Ivanov Artem Sergeevich")
                .setUniversityId("1")
                .setCurrentCourseNumber(6)
                .setAvgExamScore(4.723f);
        System.out.println(student);
    }
}
