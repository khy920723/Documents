package com.khy.example02;

public class Earth {

	static final double EARTH_RADIUS = 6400; // ������ ��� ���ǵ� new �ؼ� �ν��Ͻ�ȭ �ϴ� �� ���� static���� �����ϴ°� �� ����
	static final double EARTH_SURFACE_AREA;
	
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
