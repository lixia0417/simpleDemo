package com.example.demo.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

	private List<Filter> filters = new ArrayList<Filter>();
	private int index = 0;

	public String doFilter(Request request, Response response) {
		if (index == filters.size()) {
			return "endString";
		}
		Filter filter = filters.get(index);
		index++;
		return filter.doFilter(request, response, this);
	}

	public FilterChain addFilter(Filter f) {
		filters.add(f);
		return this;
	}
	
}
