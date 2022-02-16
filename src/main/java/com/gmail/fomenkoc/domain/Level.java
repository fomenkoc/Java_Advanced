package com.gmail.fomenkoc.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {
	L1, L2, L3, L4, L5;

	public static List<Level> getList() {
		return new ArrayList<Level>(Arrays.asList(Level.values()));
	}
}
