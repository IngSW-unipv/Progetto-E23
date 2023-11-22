package it.unipv.ingsw.gi.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;

public class SetTest {
	
	Set<String> test = new HashSet<>();
	Set<Libro> libtest = new HashSet<>(); 
	
	
	



	public SetTest(Set<String> test, Set<Libro> libtest) {
		super();
		this.test = test;
		this.libtest = libtest;
	}



	public String addS(String s) {
		String add = s;
		test.add(add);
		return s;
		
	}
	
	
	
	public void addLib(Libro libro) {
		Libro lib = libro;
		libtest.add(lib);
	}
	
	
	
	
	public static void main(String []args){
		
		Set<String> s = new HashSet<>();
		Set<Libro> r = new HashSet<>();
		
		
		
		/*Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		Libro lib2 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		ArrayList<Libro> a = new ArrayList<>();
		
		

		a.add(lib2);
		a.add(lib2);
		
		s.add(lib1);
		s.add(lib1);
		
		System.out.println(s);
		System.out.println(a);*/
		
		Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		Libro lib2 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		
		SetTest a = new SetTest(s,r);
		a.addS("test");
		a.addS("test");
		
		r.add(lib2);
		r.add(lib1);
		
		
		
		System.out.println(s);
		System.out.println(r);
		
		
	}

}
