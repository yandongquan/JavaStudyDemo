package com.javazhan.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 14:24 2018/4/3
 * @Modified By:
 */
public class ResponseTool {
    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
