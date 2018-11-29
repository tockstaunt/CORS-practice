package com.cors.demo;

import java.util.List;

public class ListToArray {
	public String[] convert(List<String> list) {
		return list.toArray(new String[list.size()]);
	}

}
