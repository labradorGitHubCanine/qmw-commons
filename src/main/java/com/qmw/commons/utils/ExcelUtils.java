package com.qmw.commons.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class ExcelUtils {

    public static void main(String[] args) {
        read();
    }

    public static void read() {
        Workbook workbook;
        File file = new File("C:\\Users\\12334\\Desktop\\测试文件\\tb_invoice.xlsx");
        try (FileInputStream stream = new FileInputStream(file)) {
            workbook = new XSSFWorkbook(stream);
        } catch (Exception ignored) {
            System.out.println("error");
        }
    }

//    private static String getCellValue(Cell cell) {
//        if (cell == null)
//            return "";
//        // 是否日期格式
//        if (CellType.NUMERIC.equals(cell.getCellType()) && DateUtil.isCellDateFormatted(cell)) {
//            LocalDateTime date = cell.getLocalDateTimeCellValue();
//            if (Stream.of(date.getHour(), date.getMinute(), date.getSecond()).allMatch(e -> e == 0))
//                return date.toLocalDate().toString();
//            else
//                return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        } else {
//            return new DataFormatter().formatCellValue(cell).trim();
//        }
//
//    }

}
