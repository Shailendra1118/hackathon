package com.bdd;

import java.util.Scanner;

public class BDD {
	
	    public static void main( String args[] )
	    {

	        Scanner in = new Scanner(System.in);
	        int _names_size = 0;
	        _names_size = Integer.parseInt(in.nextLine().trim());
	        String[] _names = new String[_names_size];

	        String _names_item;
	        for(int _names_i = 0; _names_i < _names_size; _names_i++) {
	            try {
	                _names_item = in.nextLine();
	            } catch (Exception e) {
	                _names_item = null;
	            }
	            _names[_names_i] = _names_item;
	        }
	        BaseClass[] employees = new BaseClass[_names_size];

	        Manager manager = new BDD().new Manager("",0d, 0d);
	        for(int _names_i = 0; _names_i < _names_size; _names_i++) {

	          String[] parts = _names[_names_i].split(":");

	            switch ( parts[0]) {
	                case "M":
	                    manager = new BDD().new Manager(parts[1],Integer.parseInt(parts[2]), Integer.parseInt(parts[3]) );
	                    System.out.println( manager.getName() + " has an additional bonus of " + manager.getBonus() );
	                    employees[_names_i] =  manager;
	                    break;
	                case "PA":
	                    PersonalAssistant pa = new BDD().new PersonalAssistant( parts[1], Integer.parseInt(parts[2]), manager );
	                    System.out.println( pa.getName() + "'s boss is " + pa.getBossName() );
	                    employees[_names_i] = pa;
	                    break;
	                default:
	                    try {
	                        Employee employee = new BDD().new Employee(parts[1], Integer.parseInt(parts[2]));
	                        employees[_names_i] = employee;
	                    }
	                    catch(Exception ex) {
	                        System.out.println(parts[1] + "'s salary is incorrect. " + ex.getMessage());
	                    }
	                    break;
	            }
	        }

	        System.out.println( "\nPackage before increase" );
	        for( int i = 0; i < _names_size; i++ )
	        {
	            if (employees[i] != null)
	                employees[i].printSalaryPackage();
	        }
	        for( int i = 0; i < _names_size; i++ )
	        {
	            if (employees[i] != null)
	                employees[i].increaseSalary();
	        }
	        System.out.println( "\nPackage after increase" );
	        for( int i = 0; i < _names_size; i++ )
	        {
	            if (employees[i] != null)
	                employees[i].printSalaryPackage();
	        }
	    }
	    
	    
	    class BaseClass
		{
		    protected String name;
		    protected double salary;

		    public BaseClass()
		    {
		        name = "no name";
		        salary = 0.00;
		    }

		    public BaseClass( String n, double s )
		    {
		        name = n;
		        setSalary(s);
		    }
		    public double getSalary()
		    {
		        return salary;
		    }
		    public void setSalary( double s )
		    {

		        salary = s;
		    }

		    public String getName()
		    {
		        return name;
		    }

		    public void increaseSalary()
		    {
		        //
		    }

		    public void printSalaryPackage()
		    {
		        System.out.println( "Salary of " + name + " is " + salary );
		    }
		}
		
		class Employee extends BaseClass 
	    {
	        public void increaseSalary(){
	           this.salary = this.salary + (this.salary*5/100);
	        }
	        
	        public Employee(String name, double salary){
	            this.name = name;
	            this.salary = salary;
	        }

	    }
	    class Manager extends Employee
		{
	        protected double bonus = 0.0;
	        public Manager(String name, double salary, double bonus){
	        	super(name, salary);          
	            this.bonus = bonus;
	        }
	        
	        public Manager(String name, double salary){
	            super(name, salary);
	        }
	        
	        public String getBonus(){
	            return getName()+" has an additional bonus of "+this.bonus;
	        }
	        
	        public void printSalaryPackage(){        
	            System.out.println( "Salary of " + name + " is " + salary +" with a bonus of "+this.bonus);
	        }
	        
	      
		
		}
		final class PersonalAssistant extends Employee
		{
	        protected Employee boss;  
	        public PersonalAssistant(String name, double salary, Employee boss){
	           super(name, salary);
	           this.boss = boss;
	        }
	        
	        public PersonalAssistant(String name, double salary){
	            super(name, salary);
	        }
	        
	        public String  getBossName(){
	            return getName()+"'s boss is "+this.boss.getName();
	        }
	        
	        public void increaseSalary(){
	            this.salary = this.salary + (this.salary*11/100);
	        }

	         public String getName(){
	            return this.name;
	        }
		
		}


	}

	

