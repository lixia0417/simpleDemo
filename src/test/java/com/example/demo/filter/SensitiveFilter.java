package com.example.demo.filter;

public class SensitiveFilter implements Filter {
    public String doFilter(Request req, Response resp, FilterChain chain) {
        // 过滤req.reqStr中的敏感词
        req.reqStr = req.reqStr.replace("敏感", "").replace("被就业", "就业");
        req.reqStr += "===SensitiveFilter";
        String str = chain.doFilter(req, resp);
        resp.respStr += "===SensitiveFilter";
        return str + "| sensitive";
    }
}
