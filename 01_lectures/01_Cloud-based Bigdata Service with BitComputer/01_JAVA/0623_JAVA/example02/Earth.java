package com.khy.example02;

public class Earth {

	static final double EARTH_RADIUS = 6400; // 어차피 상수 쓸건데 new 해서 인스턴스화 하는 것 보단 static으로 선언하는게 더 좋음
	static final double EARTH_SURFACE_AREA;
	
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
