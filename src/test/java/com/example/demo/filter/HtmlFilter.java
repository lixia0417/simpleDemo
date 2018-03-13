package com.example.demo.filter;

public class HtmlFilter implements Filter {
    public String doFilter(Request req, Response resp, FilterChain chain) {
        //过滤req.reqStr中的HTML标记
        req.reqStr = req.reqStr.replace("<", "&lt;").replace(">", "&gt;");
        req.reqStr += "---HtmlFilter()---";
        String str = chain.doFilter(req, resp);
        resp.respStr += "---HtmlFilter()---";
        return str + " |html";
    }
}