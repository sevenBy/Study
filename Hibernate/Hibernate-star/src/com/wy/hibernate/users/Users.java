package com.wy.hibernate.users;


import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Users {
	private Long id;
	private String name;
	private String pass;
	
	public Users(){
		
	}
	public Users(Long id ,String name,String pass){
		this.id=id;
		this.pass=pass;
		this.name=name;
	}
	
	
	public String toString(){
		return "Users[id ="+id+",name="+name+",pass="+pass+"]";
	}
}
