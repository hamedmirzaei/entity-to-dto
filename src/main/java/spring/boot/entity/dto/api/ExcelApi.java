package spring.boot.entity.dto.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.entity.dto.domain.Student;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
@Api(value = "Excel Download API", tags = {"Excel Controller"})
public class ExcelApi {

    private static String[] header = {"نام", "نام خانوادگی"};
    private static Student[] students = {new Student("حامد", "میرزایی"), new Student("رضا", "میرزایی")};

    private static void createHeaderCell(Row row, short col, String cellValue) {
        Cell c = row.createCell(col);
        c.setCellValue(cellValue);
    }

    private static void createDataCell(Row row, short col, String cellValue) {
        Cell c = row.createCell(col);
        c.setCellType(CellType.STRING);
        c.setCellValue(cellValue.trim());
    }

    @GetMapping(value = "/download")
    @ApiOperation(value = "download the list as excel file")
    public void getUser(HttpServletResponse response) throws IOException {

        /*set headers for csv file attachment*/
        response.addHeader("Content-Type", "application/vnd.ms-excel; charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment; filename=test.xls");
        response.setCharacterEncoding("UTF-8");

        // Creating Workbook instances
        Workbook wb = new HSSFWorkbook();

        // Creating Sheets using sheet object
        Sheet sheet1 = wb.createSheet("Sheet 1");

        Row rr = sheet1.createRow(0);
        for (int i = 0; i < header.length; i++) {
            createHeaderCell(rr, (short) i, header[i]);
        }

        for (int i = 0; i < students.length; i++) {
            rr = sheet1.createRow(i + 1);
            createDataCell(rr, (short) 0, students[i].getFirstName());
            createDataCell(rr, (short) 1, students[i].getLastName());
        }


        System.out.println("Sheets Has been Created successfully");

        wb.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

}
