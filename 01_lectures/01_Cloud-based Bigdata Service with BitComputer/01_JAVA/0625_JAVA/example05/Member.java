package com.khy.example05;

public class Member {

	public String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Member) {
			Member member = (Member) obj; // 강제형변환
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	
			
}
