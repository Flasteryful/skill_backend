package service;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Reader {
    private Reader() {
    }

    public static List<Student> readStudent() {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream(new File("universityInfo.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return universities;
    }
}
