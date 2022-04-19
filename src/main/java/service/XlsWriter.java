package service;

import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class XlsWriter {
    private static final Logger log = (Logger) LoggerFactory.getLogger(XlsWriter.class);

    public XlsWriter() {
    }

    public void writeStatistics(Set<Statistics> statistics, String pathToFile) {

        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Statistics");

        int rowNum = 0;
        String[] rowNames = new String[]{"Study profile", "Average exam score", "Amount of student in profile", "Amount of university in profile", "University names"};
        List<String> columnNames = List.of(rowNames);
        Row row = sheet.createRow(rowNum);
        Font font = book.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        XSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        columnNames.forEach(column -> {
            Cell cell = row.createCell(columnNames.indexOf(column));
            cell.setCellValue(column);
            cell.setCellStyle(style);
        });
        for (Statistics statistic : statistics) {
            rowNum++;
            XSSFSheet sheetOne = book.getSheetAt(0);
            Row rowVal = sheetOne.createRow(rowNum);
            rowVal.createCell(0).setCellValue(String.valueOf(statistic.getStudyProfile()));
            rowVal.createCell(1).setCellValue(String.valueOf(statistic.getAvgExamScore()));
            rowVal.createCell(2).setCellValue(statistic.getAmountStudentOnProfile());
            rowVal.createCell(3).setCellValue(statistic.getAmountUniversityOnProfile());
            rowVal.createCell(4).setCellValue(String.valueOf(statistic.getUnivesityNames()));
        }
        try {
            FileOutputStream out = new FileOutputStream(pathToFile, false);
            book.write(out);
            log.info("Statistics writed in file " + pathToFile);
        } catch (IOException e) {
            log.error("Statistics not writed in file " + e.getMessage());
            e.printStackTrace();
        }

    }
}
