package service;


import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Reader {
    private static final Logger log = (Logger) LoggerFactory.getLogger(Reader.class);

    private Reader() {
    }

    public static List<Student> readStudent() {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream("universityInfo.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            log.info("Start reading list of stuents");
            log.info("File " + excelFile + " opened");
            for (Row currentRow : datatypeSheet) {
                Student student = new Student();
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                short minColIx = currentRow.getFirstCellNum();
                short maxColIx = currentRow.getLastCellNum();
                for (short colIx = minColIx; colIx < maxColIx; colIx++) {
                    Cell cell = currentRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    switch (colIx) {
                        case 0 -> student.setUniversityId(String.valueOf(cell));
                        case 1 -> student.setFullName(String.valueOf(cell));
                        case 2 -> student.setCurrentCourseNumber((int) Math.round(cell.getNumericCellValue()));
                        case 3 -> student.setAvgExamScore((float) cell.getNumericCellValue());
                    }
                }
                students.add(student);
            }
            log.info("List of students readed in file " + excelFile);
        } catch (FileNotFoundException e) {
            log.error("In process reading list of students file not found " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            log.error("In process reading list of students received unnamed error unnamed error " + e.getMessage());
            e.printStackTrace();
        }
        return students;
    }

    public static List<University> readUniversity() {
        List<University> universities = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(new File("universityInfo.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(1);
            log.info("File " + excelFile + " opened");
            log.info("Start reading list of universities");
            for (Row currentRow : datatypeSheet) {
                University university = new University();
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                short minColIx = currentRow.getFirstCellNum();
                short maxColIx = currentRow.getLastCellNum();
                for (short colIx = minColIx; colIx < maxColIx; colIx++) {
                    Cell cell = currentRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    switch (colIx) {
                        case 0 -> university.setId(String.valueOf(cell));
                        case 1 -> university.setFullName(String.valueOf(cell));
                        case 2 -> university.setShortName(String.valueOf(cell));
                        case 3 -> university.setYearOfFoundation((int) Math.round(cell.getNumericCellValue()));
                        case 4 -> university.setMainProfile(StudyProfile.valueOf(cell.getStringCellValue().toUpperCase(Locale.ENGLISH)));
                    }
                }
                universities.add(university);
                log.info("List of universities readed in file " + excelFile);
            }
        } catch (FileNotFoundException e) {
            log.error("In process reading list of universities file not found " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            log.error("In process reading list of universities received unnamed error " + e.getMessage());
            e.printStackTrace();
        }
        return universities;
    }
}
