package com.wisdom.agriculture.utils;

import com.wisdom.agriculture.pojo.FaultRecord;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FileUtil {

    public static void getHSSFWorkbook1( String []title,List<FaultRecord> faultRecords,HttpServletResponse response,String fileName){
        XSSFWorkbook wb=new XSSFWorkbook();


        XSSFSheet sheet = wb.createSheet("first");

        XSSFRow row = sheet.createRow(0);

        XSSFCellStyle style = wb.createCellStyle();


        //声明列对象
        XSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
  /*      for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }*/


        int i=1;
        for (FaultRecord f:faultRecords){
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(f.getId());
            row.createCell(1).setCellValue(f.getDid());
            row.createCell(2).setCellValue(f.getDeviceId());
            row.createCell(3).setCellValue(f.getDeviceName());
            row.createCell(4).setCellValue(f.getLongitude());
            row.createCell(5).setCellValue(f.getLatitude());
            row.createCell(6).setCellValue(f.getPlace());
            row.createCell(7).setCellValue(f.getTime());
            i++;
        }

        try {
            setResponseHeader( response,  fileName);
            OutputStream outputStream=response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
