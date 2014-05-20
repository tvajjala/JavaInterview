package com.xml.parsing

class Person {


	private String name;
	private def salary;
	def  department;


	Person(){
	}

	Person(name,salary,department){
		this.name=name;
		this.salary=salary;
		this.department=department;
	}

	static main(args){
		def p1=new Person("TR","1000","IT")
		def p2= new Person(salary:"100",name:"TRR",department:"JAVA")
		
		println p1;
		println p2;
		4.times {
			println "Hi "+it;
		}
		
		//System.getProperties().list(System.out);
		
		def lst=['Groovy','interesting','language'];
		
		println lst.join(' IS ');
		println lst.getClass();
		
		String.metaClass.isPalindrome = {->
			delegate == delegate.reverse()
		  }
			  
		def  word = 'tattarrattat'
		  println "$word is a palindrome? ${word.isPalindrome()}"
		  word = 'Groovy'
		  println "$word is a palindrome? ${word.isPalindrome()}"
		
		  
		  println  "java -v".execute().text;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NAME :$name;  SAL : $salary ;  DEPARTMENT : $department ";
	}
}