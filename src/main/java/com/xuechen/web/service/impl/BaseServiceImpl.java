package com.xuechen.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xuechen.web.bo.AppDictDetail;
import com.xuechen.web.service.BaseService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl implements BaseService {

    public void exportExcel(ServletOutputStream outputStream, ServletContext context, String header, String jsonData) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        // 获取系统路径
        HSSFDataFormat format = wb.createDataFormat();

        // 标题栏样式
        HSSFCellStyle styleTitle = wb.createCellStyle();
        styleTitle.setLeftBorderColor(HSSFColor.BLACK.index);
        styleTitle.setBorderLeft(BorderStyle.THIN);
        styleTitle.setRightBorderColor(HSSFColor.BLACK.index);
        styleTitle.setBorderRight(BorderStyle.THIN);
        styleTitle.setBottomBorderColor(HSSFColor.BLACK.index);
        styleTitle.setBorderBottom(BorderStyle.THIN);
        styleTitle.setBorderTop(BorderStyle.THIN);
        styleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleTitle.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
        styleTitle.setDataFormat(format.getFormat("@"));
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        styleTitle.setFont(font);

       // List<Map<String, Object>> titles = JsonUtils.parseJSON2List(header);
        JSONArray array =  JSONObject.parseArray(header);
        // 标题栏
        HSSFRow rowTtile = sheet.createRow(0);
        for (int j = 0; j < array.size(); j++) {
            HSSFCell cell = rowTtile.createCell((short) j);
            JSONObject map=(JSONObject) array.get(j);
            String value = map.get("header").toString();
            String widthStr = map.get("width").toString();
            int width = 0;
            if (widthStr != null && widthStr.length() > 0) {
                width = Integer.parseInt(widthStr.replace("px", "")) * 70;
            } else {
                width = (value.getBytes().length * 300);
            }
            cell.setCellValue(new HSSFRichTextString(value));
            sheet.setColumnWidth((short) j, (short) width);
            cell.setCellStyle(styleTitle);
        }

        // 设置样式，奇偶不同
        HSSFCellStyle styleCell1 = wb.createCellStyle();
        styleCell1.setLeftBorderColor(HSSFColor.BLACK.index);
        styleCell1.setBorderLeft(BorderStyle.THIN);
        styleCell1.setRightBorderColor(HSSFColor.BLACK.index);
        styleCell1.setBorderRight(BorderStyle.THIN);
        styleCell1.setBottomBorderColor(HSSFColor.BLACK.index);
        styleCell1.setBorderBottom(BorderStyle.THIN);
        styleCell1.setBorderTop(BorderStyle.THIN);
        styleCell1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleCell1.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        styleCell1.setDataFormat(format.getFormat("@"));
        HSSFCellStyle styleCell2 = wb.createCellStyle();
        styleCell2.setLeftBorderColor(HSSFColor.BLACK.index);
        styleCell2.setBorderLeft(BorderStyle.THIN);
        styleCell2.setRightBorderColor(HSSFColor.BLACK.index);
        styleCell2.setBorderRight(BorderStyle.THIN);
        styleCell2.setBottomBorderColor(HSSFColor.BLACK.index);
        styleCell2.setBorderBottom(BorderStyle.THIN);
        styleCell2.setBorderTop(BorderStyle.THIN);
        styleCell2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleCell2.setFillForegroundColor(HSSFColor.WHITE.index);
        styleCell2.setDataFormat(format.getFormat("@"));

        JSONObject object =  (JSONObject) JSONObject.parse(jsonData);
        Object datas = object.get("data");
        if (datas != null) {
            JSONArray jsonArray=(JSONArray)datas;
            for (int i = 0; i < jsonArray.size(); ++i) {
                HSSFRow row = sheet.createRow(i + 1);

                // 设置行高
                row.setHeight((short) 270);

                JSONObject data=(JSONObject) jsonArray.get(i);
                for (int j = 0; j < array.size(); ++j) {
                    JSONObject map = (JSONObject) array.get(j);
                    String field = map.get("field").toString();
                    if (field != null) {
                        Object objectValue = data.get(field);
                        if (objectValue == null)
                            continue;
                        String value = objectValue.toString();

                        // 是否需要字典转义
                        String code = map.get("code").toString();
                        if (code != null && code.equals("1")) {
                            List<AppDictDetail> appDictDetails=(List<AppDictDetail>)context.getAttribute(field.toUpperCase());

                            if (appDictDetails != null) {
                                for (int m = 0; m < appDictDetails.size(); m++) {
                                    AppDictDetail appDictDetail = appDictDetails.get(m);
                                    if (appDictDetail.getDictVal().equals(value)) {
                                        value = appDictDetail.getDictName();
                                        break;
                                    }
                                }
                            }
                        }

                        HSSFCell cell = row.createCell((short) j);

                        cell.setCellType(CellType.STRING);
                        if (i % 2 == 0) {
                            cell.setCellStyle(styleCell1);
                        } else {
                            cell.setCellStyle(styleCell2);
                        }
                        cell.setCellValue(new HSSFRichTextString(value));
                    }
                }
            }
        }

        wb.write(outputStream);
		/*
		 * String filePath = path+"/dksal.xls"; File file =new File(filePath);
		 * file.mkdirs(); FileOutputStream fos = new FileOutputStream(file);
		 * wb.write(fos); fos.close();
		 */
    }
}
