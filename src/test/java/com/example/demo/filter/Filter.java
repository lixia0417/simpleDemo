package com.example.demo.filter;

public interface Filter {
	public String doFilter(Request request,Response response,FilterChain chain);
}
