package com.example.chopeeservice.util;

import com.alibaba.excel.EasyExcel;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel操作常用的工具类
 */
public class ExcelUtil {

    /**
     * 默认excel文件名和单元sheet名一样的 Excel文件导出
     * @param httpServletResponse
     * @param data
     * @param fileName
     * @param clazz
     * @throws IOException
     */
    public static void writeExcel(HttpServletResponse httpServletResponse, List data, String fileName, Class clazz) throws IOException {
        writeExcel(httpServletResponse, data, fileName, fileName, clazz);
    }

    /**
     * 导出数据为Excel文件
     * @param response  响应实体
     * @param data  导出数据
     * @param fileName 文件名
     * @param sheetName 单元格名
     * @param clazz  定义excel导出的实体
     * @throws IOException
     */
    public static void writeExcel(HttpServletResponse response, List data, String fileName, String sheetName, Class clazz) throws IOException {
        //防止中文乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //防止导入excel文件名中文不乱码
        response.setHeader("Content-disposition", "attachment;fileName=" + fileName + ".xlsx" + ";fileName*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(data);
    }

}

