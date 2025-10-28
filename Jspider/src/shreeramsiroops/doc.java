package shreeramsiroops;

public class doc {
	public static void main(String[] args) {
		/*
		 * 
		 * Object Oriented Programming (OOPs)
		 * 
		 * 
		 * OOPs is a Design principle which helps us connect/map code instructions with
		 * real world entities making the code short and easy to understand
		 * 
		 * ------Topics OOPS Basics classes and Objects Constructor constructor
		 * overloading Blocks this, final Access Specifiers java bean class
		 * --Encapsulation --Inheritance(Is-A Relationship) Method overloading Method
		 * overriding type casting generalization and specialization --Polymorphism
		 * Abstract class interfaces --Abstraction has-a Relationship
		 * 
		 * 
		 * ----------------------- class type definition is made up of two parts 1)class
		 * declaration/signature 2)class body
		 * 
		 * The class declaration specifies the --accessSpecifier modifier class
		 * ClassName.
		 * 
		 * The body specifies variables and methods Anything which is defined inside the
		 * body of the class is known as members of the class
		 * 
		 * the list of variables defined inside the class is
		 * 
		 * known as member variable The list of methods defined in the class body is
		 * known as member methods
		 * 
		 * 
		 * The members of the class are classified into 2 types 1)static member 2)non
		 * static members
		 * 
		 * 1)static members : static members are declared with static keyword Static
		 * members have single copy in the memory -Static does not mean constant ,we can
		 * modify the value but they have single copy in the memory
		 * 
		 * 2) non static members : non static member are declared without static
		 * keyword. we can create multiple copy of the non static members by creating
		 * Objects
		 * 
		 * 
		 * --------------------
		 * 
		 * Q) can i write any number of class files in one source file ? ans: yes , when
		 * we compile --for every class byte code will be generated (if 3 classes 3 byte
		 * codes)
		 * 
		 * A class is eligible to execute only if class contains main method Execution
		 * starts with main and end with main method
		 * 
		 * ## Note: - -->In a single sourcefile we can define any number of java class
		 * type, each class name should be unique - -->the compiler will generate
		 * separate byte code for each class - ->In one sourcefile i can create only one
		 * "public" class - ->with which name i create my sourcefile there only i have
		 * to write my main method for smooth execution
		 * 
		 * 
		 * Accessing static members of one class in another class
		 * 
		 * 1)Accessing static variable syntax: Classname.staticvariablename
		 * 
		 * 2)Accessing static method
		 * 
		 * syntax: Classname.staticmethodname()
		 * 
		 * ---------------------------
		 * 
		 * # Accessing Nonstatic members of one class in another class
		 * 
		 * 1)Accessing Nonstatic variable syntax: new Classname().nonstaticvariablename
		 * 
		 * 2)Accessing nonstatic method syntax: new Classname().nonstaticmethodname()
		 * 
		 * Members of a class can be accessed in any other class by using . operator(Dot
		 * operator)
		 * 
		 * ------------------ Local Variable: A variable declared inside a method body
		 * or constructor body is know as local variable (And local variables can be
		 * accessed only inside those methods) local variable doesn't have static
		 * ,non-static concept
		 * 
		 * 
		 * Global Variable : A variable declared outside the method block and inside the
		 * class block is know as global variable (And it can be accessed anywhere
		 * inside the class block)
		 * 
		 * ------------------------------ # Object
		 * 
		 * An Entity having states(Attributes/properties), behaviour and unique
		 * identification is know as Object (All real word entities are Object)
		 * 
		 * States : represent the information about the object (variables). The sates
		 * are also known as data members or attributes or fields
		 * 
		 * 
		 * Behaviour: represent the actions which must be performed on the object
		 * (methods).
		 * 
		 * A class is a definition block used to define the states and behaviour Class:
		 * "Class is A BluePrint of an Object". -----------
		 * 
		 * 
		 * Object Creation/instantiation (Object/instance) --------------------------
		 * 
		 * Reference Variable
		 * 
		 * Its a non primitive type variable declared using java class type
		 * 
		 * ( Classtype ) Ex: Tesla t1 ; here Tesla is class ,"t1" is reference variable
		 * 
		 * "ReferenceVariable Contains ADDRESS of an Object"
		 * 
		 * The referencevariable is used to refer Object hence it is also know as
		 * "Object reference" Using Object reference we can access datamembers and
		 * methods of the Object
		 * 
		 * 
		 * ---------------------------- ## Initialization of Object States/attributes
		 * 
		 * 1)default Initialization 2)using Constructors 3)Using Blocks 4)using methods
		 * 
		 * Default values are only applicable for global variables , Default values are
		 * NOT-applicable for local variables
		 * 
		 * ## Constructor -->used to Initialize attributes of an Object --->It is
		 * internally called "at the Object creation time" (Not before , not After)
		 * --->Constructor is a special member of class used for initialization of
		 * attributes of an Object (to load non-static members of an object)
		 * 
		 * 
		 * syntax:
		 * 
		 * --------------------- Note: Constructor name will be same as class name it is
		 * similar to method but constructor don't have any return type not even void.
		 * ------------------------ Constructor is a special member of class used to
		 * initialize states of an Object ,during Object creation Time The constructor
		 * is always called whenever we create the Object of a class
		 * 
		 * When We define a Constructor ,The following Rules must be followed 1)The
		 * constructor name should be same as class name 2)The constructor should not
		 * have Return Type(not even void) 3)modifiers should not be used in constructor
		 * declaration 4)A constructor can be declared with parameter or without
		 * parameter 5)Defining a constructor in a class provides the benefits of
		 * initializing the Object states during the Object creation, It makes Object
		 * Ready to consume
		 * 
		 * 
		 * ---------------------------------------
		 *** 
		 * "this" keyword
		 * 
		 * java always refers the current Object through "this" keyword The Object by
		 * which method/Constructor is invoked in known as current object The current
		 * Object details is stored in 'this' Keyword
		 * 
		 * "this" keyword must be used either in non-static method of a class or
		 * Constructor
		 * 
		 * "this keyword holds the ADDRESS of Current Object"..
		 * 
		 * ----------------------
		 * 
		 * ## Constructor OverLoading
		 * 
		 * Defining more than one Constructor with different parameter-list is known as
		 * Constructor Overloading
		 * 
		 * The Parameter list should differ in any one of the following 1)parameter type
		 * 2)parameter length 3)Sequence of parameter
		 * 
		 * Constructor Overloading helps us create Object with different set of data.
		 * The Overloaded Constructor are executed based on the parameter
		 * 
		 * ------------------------------------- Blocks
		 * 
		 * A block is a set of instruction used for initialization ----Blocks are
		 * categorized into two types 1)static block 2)non static block
		 ** 
		 * Static Block/Multiline static initializer static block is a set of
		 * instruction used for initializing "only static variables"
		 * 
		 * 
		 * syntax: static { //set of instruction
		 * 
		 * }
		 * 
		 * Note:1) static blocks run before main method, static block run only once.
		 * 2)If there are multiple static blocks they run sequentially
		 * -------------------------------------- #Non static Block //Multiline
		 * non-static initializer
		 * 
		 * syntax: { //set of instruction }
		 * 
		 * The non static block is set of instruction used to initialize both static and
		 * non-static variables (but it is not good practice to initialize static
		 * variables in non static block) We majorly use non static block to initialize
		 * non static variables only
		 * 
		 * 
		 * Non static Blocks are executed at the time of Object Creation When we have
		 * multiple non static blocks they also execute sequentially
		 * 
		 * Important: 1)static blocks runs only Once 2)Non static block runs whenever
		 * Object is created
		 * 
		 * 
		 * -------------------------
		 * 
		 * Interview Question In one class , we have both non-static Block and
		 * Constructor if we create Object and initialize parameter both are called
		 * ,which will run first ? and which value will be there in the Object?
		 * 
		 * 
		 * Ans) ---First non-static blocks will run -----Then constructor will run
		 * -----Constructor will run later so the value initialized in constructor will
		 * be stored
		 * 
		 * 
		 * ------------------------------- ## final Variable
		 * 
		 * Any variable declared by using 'final keyword' is known as final variable
		 * --->final variables are 'constants' in java language --->final variable must
		 * be initialized only once , It cannot be reinitialized
		 * 
		 * final variable cannot be Reinitialized final method cannot be overridden
		 * final class cannot be inherited ------------------------------ Access
		 * Specifiers
		 * 
		 * 1)Public If you declare any entity as public, then it can be accessed by the
		 * classes present in the same package or different package Public entities will
		 * have highest visibility and lowest security
		 * 
		 * 2)Protected If you declare any entity as protected ,then it can be accessed
		 * by the classes present in same package Protected entity can be accessed by
		 * other classes present in different package through inheritance and creating
		 * the object of SUBCLASS(Child class) only.
		 * 
		 * 3)Pkg-level (default) if you declare any entity without using any access
		 * specifiers then it is considered as pkg-level member (default member) If you
		 * declare any entity as pkg-level ,then it can be strictly accessed only by the
		 * classes present in same package
		 * 
		 * 4)private If you declare any entity as private then it can be accessed only
		 * by the class within which they are declared
		 * 
		 * Private entities will have highest security and lowest visibility
		 * 
		 * --------------------------------- ## Encapsulation
		 * 
		 * Binding the data members and related operation into the class is known as
		 * encapsulation
		 * 
		 * Encapsulation is defined as the wrapping up of data and methods under a
		 * single unit is Know as Encapsulation .It also implements data hiding.
		 * 
		 * The encapsulation specifies that a data and its related operation must be in
		 * the class body It also specifies that the data members should be
		 * protected(Hide) using access specifiers
		 * 
		 * Java bean class (java bean class Format is Perfect Example for Encapsulation)
		 * The characteristics of java bean class 1)The class must be public 2)the
		 * member variable should be private 3)constructors must be public 4)the class
		 * must define public getters and setters method
		 * 
		 * - the getters method are used to get the private variable values. - the
		 * setters method are used to change/modify the private variable values. get and
		 * set is not a keyword its a format
		 * 
		 * 
		 * ## Getter Method to get the value of private attribute of object
		 * 
		 * Format: datatype getAttributename() { return attributename; }
		 * 
		 * Example: private int age;
		 * 
		 * //getter method
		 * 
		 * int getAge(){ return age; } ---
		 * 
		 * ## Setter method Used to change value of private attribute of an object
		 * 
		 * Format:
		 * 
		 * void setAttributename(datatype (naya)attributename){ this.attributename =
		 * (naya)attributename; }
		 * 
		 * ### Ex: void setAge(int age){ this.age=age; }
		 * 
		 * ----------------------------------- # Inheritance 1)Is-A Relationship
		 * (Inheritance) 2)Has-A Relationship
		 * 
		 * [base Class or/ super class or/ parent class]
		 * 
		 * [derived class or/ sub class or/ child class]
		 * 
		 * - -extends Keyword is used for inheritance --implements ---we will study in
		 * interface topic
		 * 
		 * ""One class acquiring the properties of another class is called as
		 * Inheritance in java""
		 * 
		 * The class from which members are inherited is know as Super class/Parent
		 * class The class to which the members are inherited is know as sub class/child
		 * class
		 * 
		 * 
		 * note: Subclass inherits non static members from superclass The class can
		 * inherit from another class by using "extends" keyword Private non static
		 * members of super class will not be inherited to subclass because of private
		 * access specifier The constructor of super class will not be inherited to
		 * subclass
		 * 
		 * 
		 * - **In order to achieve inheritance we make use of keyword called as
		 * "extends"** - **We also refer Inheritance as Is-A relationship** - **Blocks
		 * and constructor of the superclass will not be inherited to subclass
		 * (variables and methods are inherited)**
		 * 
		 * -------------------------------------------- Implicit constructor call
		 * 
		 * Whenever we write inheritance program the subclass constructor must call the
		 * super class constructor to initialize the attributes
		 * 
		 * If the superclass contains non-parameter constructor ,the subclass
		 * constructor makes Implicit call. ---------------------- Explicit Constructor
		 * call
		 * 
		 * The subclass constructor can make a call to super class constructor by using
		 * ( super() )super calling statement. If the superclass contains parameterized
		 * constructor ,the subclass should make Explicit call. (using super())
		 * 
		 * 
		 * Constructor calling statement super() -----This makes a call to the
		 * superclass constructor it can call with parameter or without parameter
		 * 
		 * Rules : 1)super calling statement must be used only inside the constructor
		 * body 2)Super calling statement(super()) must be the first statement in the
		 * constructor body 3)in one constructor body only one super calling statement
		 * is allowed
		 * 
		 * Constructor Chaining 1)"A phenomenon of running more than one constructor to
		 * initialize the attributes of an object is called as Constructor Chaining"
		 * 2)the constructor chaining should happen whenever we write inheritance
		 * program
		 * 
		 * ## Why Multiple inheritance is Not supported in java Class type
		 * 
		 * Ans) Java doesn't support multiple inheritance because constructor chaining
		 * will not happen from diff class, since more than one constructor calling
		 * statement is not supported ,It leads to ambiguity of Diamond Problem
		 * ----------------------------------------------
		 * 
		 * ## Method Overloading
		 * 
		 * A class defining multiple methods with same name but with different parameter
		 * list is known as method Overloading, The parameter list should differ in any
		 * one of the following 1)parameter type 2)parameter length 3)parameter sequence
		 * 
		 * ---In one class we can Overload both static and non static methods ---We can
		 * overload in the subclass with inherited methods
		 * 
		 * Whenever we want to perform same operation on different types of data or set
		 * of then we should apply method overloading
		 * 
		 * note: We can overload main method,But the execution begins only if the main
		 * method with (String[] args) String array parameter is present.
		 * 
		 * - --"The method overloading is used to achieve compile time Polymorphism"
		 * 
		 * 
		 * 
		 * # Java Interview Questions!!!!!
		 * 
		 * What is a Variable ? and Explain different types of variables What are data
		 * types and Explain different types of data types with there sizes Explain this
		 * keyword What are default values Difference between Static and Non static What
		 * are Blocks and Explain different types of Blocks What are constructors and
		 * Explain constructors overloading what are methods and Explain method
		 * Overloading what is Encapsulation? what is Inheritance? Explain final keyword
		 * ? Explain super calling statement with example what are access specifiers?
		 * Explain constructor chaining.
		 * 
		 * what is method overriding? what is TypeCasting? a)Upcasting b)Downcasting
		 * What is Generalization and Specialization
		 * 
		 * What is Polymorphism a)Compiletime Polymorphism(method Overloading) b)Runtime
		 * Polymorphism(method Overiding)
		 * 
		 * Whta is Abstraction? a)what is Abstract class ,abstract method a)what is
		 * Interface ---
		 * 
		 * 
		 * 
		 * 
		 * ## Method OverRiding
		 * 
		 * "Inheriting method from superclass and changing its implementation in the
		 * subclass according to the subclass specification is known as method
		 * Overriding"
		 * 
		 * When a sub class inherits a superclass method with same declaration it is
		 * called override ,It is used to change/modify the method body..
		 * 
		 * While overRiding a method ,the subclass method should be written with same
		 * declaration defined in superclass
		 * 
		 * We can override only non static methods The static methods of superclass
		 * cannot be overridden in the subclass, because the static members will not be
		 * inherited in subclass
		 * 
		 * The non static methods having private access specifier in the superclass
		 * cannot be Overridden ,the private access specifier restricts the access only
		 * to that class.
		 * 
		 * ---Method Overriding is an example for "Run time Polymorphism".
		 * 
		 * ---------------------- Can we Overload and Override at the Same time?
		 * ----------------------
		 * 
		 * 
		 * 
		 * Type Casting
		 * 
		 * Casting one type of information to another type is known as typecasting The
		 * typecasting is divided into two Types 1)primitive typecasting and 2)non
		 * primitive typecasting
		 * 
		 * 1)Primitive typecasting--Converting one primitive type of datatype into
		 * another primitive type of data is known as primitive typecasting Ex: int x =
		 * (int)95.65; //narrowing It is also known as data-type casting It is further
		 * classified into two types 1)Widening 2)Narrowing Casting lower datatype to
		 * any of the higher datatype is known as Widining Ex: double d = 50; //int type
		 * data stored in double container
		 * 
		 * Widening is done by compiler ,it is known as autowidening /implicitly The
		 * widening can be done explicitly in the code(user done ,but Widening will be
		 * done implicitly)
		 * 
		 * Narrowing : casting higher data-type to any of the lower DataType is known as
		 * Narrowing The narrowing should be performed explicitly in the code ,Whenever
		 * we performing narrowing it leads to DATALOSS.
		 * 
		 * ---
		 * 
		 * ---
		 * 
		 * 
		 * Non primitive typecasting It is also known as class-Typecasting Casting one
		 * class type to another class type is known as class typecasting
		 * 
		 * It is further classified into two types 1)Upcasting 2)downcasting
		 * 
		 * The class type casting can be done only for the classes which has Is-A
		 * relationship
		 * 
		 * 1)Upcasting: a)reference variable must be of superclass type b)object must be
		 * of subclass type
		 * 
		 * casting subclass type to superclass type is know as "Upcasting" Upcasting can
		 * be performed automatically (by compiler) or we can do it Explicitly When
		 * upcasting happens the subclass Object behaves like superclass, the subclass
		 * Object shows the properties of superclass ,Subclass properties are hidden The
		 * subclass Object can be casted to any of the superclasstype
		 * 
		 * 2)Downcasting:
		 * 
		 * a)reference variable must be of subclass type b)super class Upcasted Object
		 * Reference
		 * 
		 * (For downcasting upcasting is mandatory)
		 * 
		 * Casting super classtype back to subclass type is known as "Downcasting". The
		 * downcasting must be done Explicitly in the program The downcasting should be
		 * performed only on the object which is upcasted orelse we will get
		 * "ClassCastException".
		 * 
		 * --------------------------------------------- Generalization and
		 * Specialization
		 * 
		 * Generalization Defining a function/method which operates on different types
		 * of Object is known as Generalization
		 * 
		 * To achieve generalization the method parameter must be of superclass type for
		 * such methods we can pass subclass objects The subclass type will
		 * automatically cast to superclass type
		 * 
		 * Specialization
		 * 
		 * to achieve Specialization the method/function parameter must be of subclass
		 * type. For such method we cannot pass different type of Objects
		 * 
		 * Generalization is used to work on common properties and functionalities where
		 * as Specialization is defined to work on specific properties of subclass
		 * 
		 * 
		 * -------------------------------- Polymorphism
		 * 
		 * Ability of a method to behave differently ,when different Objects are acting
		 * upon it, is known as polymorphism
		 * 
		 * (Polymorphism means many forms)
		 * 
		 * An Object showing different behaviour at different stages of the life cycle
		 * is known as polymorphism
		 * 
		 * There are two types of polymorphism 1)compile time polymorphism(method
		 * Overloading) 2)Run time polymorphism(method Overriding)
		 * 
		 * 
		 * 
		 * Method Binding Associating/mapping the method declaration/signature to its
		 * method Implementation/body is called as method Binding
		 * ----------------------------------------- Is java Fully object oriented
		 * ...?No -------------------------------- ## Memory Allocation in java
		 * 
		 * The JVM uses 4 memory area during execution 1)Heap area 2)class area 3)method
		 * area 4)stack area
		 * 
		 * 1)Heap area: heap area is used to store objects , the objects created in
		 * program gets a memory allocation in heap area In other words Non static
		 * members of the class are loaded in the heap area
		 * 
		 * 2)Class area / class static area: the class area is used to store the static
		 * members of the class For each class created in the project a separate area is
		 * reserved in the class area and that area is known as static pool Static pool
		 * contains only static members of the class
		 * 
		 * 3)The method area stores ,the method body statements But the method
		 * declaration part of a method is always stored in either heap area or class
		 * area
		 * 
		 * If a method is non static method , the method declaration part/details is
		 * stored in heap area , if the method declaration is static, the declaration
		 * part /details is stored in class area.
		 * 
		 * 4)The stack area is used for execution purpose When a method is called , the
		 * method enters the stack memory/area executes the statements defined in the
		 * method body , after finishing of execution it exit from the stack area
		 * 
		 * JVM does all execution , Before it does execution it has to allocate memory
		 * 
		 * -------------------------------------------
		 * 
		 * # 1)Compile time polymorphism
		 * 
		 * ------> compile time polymorphism is achieved with the help of method
		 * Overloading Compile time polymorphism is referred as Early Binding or static
		 * binding
		 * 
		 * Method Binding is happening in the compile time ,hence we call method
		 * Overloading as early binding or static binding
		 * 
		 * Once the binding is done by the complier it cannot be rebinded ,Hence it is
		 * known as static polymorphism
		 * 
		 * Method Overloading is an Example for compile time polymorphism
		 * 
		 * In method Overloading ----> Out of so many methods, which method
		 * implementation/body should get executed is decided by the complier during
		 * Compile time.... -------------------------------- # Run time Polymorphism
		 * 
		 * ----->Run time Polymorphism is achieved with the help of
		 * 
		 * 1)Is-A relationship(Inheritance) 2)Method Overriding 3)Upcasting
		 * 
		 * 1)When we call a Overridden method on a superclass reference, the method
		 * implementation which gets executed is dependent on the subclass acting upon
		 * it Ex Animal a1 = new Cat(); a1.sound(): //Meoww Meoww
		 * 
		 * 2)Out of so many overridden methods , which method implementation should get
		 * executed is decided by JVM at Runtime ,Hence we call it as Runtime
		 * Polymorphism
		 * 
		 * 3)Runtime polymorphism is also called as late-Binding/dynamic-binding/
		 * Dynamic method Dispatch
		 * 
		 * Note: If we call a Overridden method on a Superclass reference, always the
		 * Overridden method (Subclass)implementation only gets executed Ex: Animal a1 =
		 * new Dog(); //upcasting a1.sound(); //Boww Boww --------------------------- #
		 * Abstraction
		 * 
		 * Hiding the internal implementation logic of an Object(or application) and
		 * showing only object Functionalities is known as Abstraction
		 * 
		 * The abstraction specifies that don't show internal implementation-logic and
		 * show only object functionalities.
		 * 
		 * 1)abstract is keyword which is used with class and method 2)A class which is
		 * not declared using abstract keyword is called as concrete class 3)Concrete
		 * class can allow only concrete methods 4)A class which is declared using
		 * abstract keyword is called as abstract class 5)abstract class will allow both
		 * abstract methods and concrete methods 6)Concrete class will not allow
		 * abstract methods 7)concrete methods will have both method declaration and
		 * method implementation/body 8)abstract method will have only declaration part
		 * but "No method body/implementation" 9)all abstract methods should be declared
		 * using abstract keyword
		 * 
		 * 
		 * # Contract of abstract or(what should we do when a class extends abstract
		 * class)
		 * 
		 * 1Rule) When a class inherits an abstract class ,we have to override all the
		 * abstract methods and give implementation/body
		 * 
		 * 2Rule) When a class inherits an abstract class ,and we don't want to override
		 * the inherited abstract method ,then make the subclass as abstract class
		 * 
		 * ----------
		 * 
		 * Important Note: 1)can a class inherit an abstract class? ----->Yes 2)Can we
		 * create Object of abstract class -----> No ..We cannot create Object of
		 * abstract class
		 * 
		 * -->abstract method cannot be private(if it is not accessible outside the
		 * class how can i override and give implementation so it cannot be private)
		 * 
		 * 4)abstract methods cannot be static(static methods cannot be inherited)
		 * 5)abstract methods cannot be final(because final methods cannot be
		 * overridden) 6)can abstract class have constructors? ------->yes but it has to
		 * be invoked by the subclass-constructor either implicitly or explicitly using
		 * super();
		 * 
		 * 
		 * We can write abstract methods as well as concrete methods in abstract class ,
		 * So we cannot achieve 100% abstraction using abstract class ,Hence we use
		 * interface to achieve 100% abstraction
		 * 
		 * -------------------------------- # Interface
		 * 
		 * 1)interface is a java type definition which has to be declared using
		 * " interface " keyword. 2)interface is a medium between two systems, where one
		 * system is client/user another system is Object with services
		 * 
		 * 3)syntax: interface InterfaceName{ //set if instruction } 4)Interface can
		 * have variables ,Those variables are automatically public static and final.
		 * 5)interface can achieve Is-A relationship with class using implements keyword
		 * 
		 * 6)Interface can allow only abstract methods, those methods are automatically
		 * public and abstract. 7)when a class implements an interface, mandatorily we
		 * should override the abstract methods
		 * 
		 * 8)while overriding the method, access specifier should be same or of higher
		 * visibility ex: Public ----to public is Correct public ------protected
		 * ,default ,private is Wrong
		 * 
		 * 9)A class can implement any number of interfaces (multiple inheritance)
		 * 
		 * 10)A class can extend 1 class and implement any number of interfaces
		 * 
		 * 11)Interfaces doesn't contain Constructors 12)we cannot create object of an
		 * interface 13) In interface we can write static concrete methods(main method)
		 * ,and default methods . ------------------------------- Example for
		 * abstraction using Interface --------
		 * 
		 * Abstraction 1)"The process of hiding the internal implementation
		 * details(unnecessary details) and showing only the object
		 * functionalities(necessary things/Behavior)to the user with the help of
		 * abstract class or interface is called as abstraction"
		 * 
		 * 2)Abstraction can be achieved by the following rules below a)abstract class/
		 * interface b)Is-A relationship(inheritance) c)upcasting d)method Overriding
		 * ------------------------------
		 * 
		 * 
		 * Has-A Relationship (An Object containing another Object) 1)Composition
		 * Imagine there are two classes A and B , A class has-A B class in such a way
		 * that A cannot function if B is not functioning It is called as
		 * "Tight Coupling". Ex: Mobile and Battery Human and Heart Human and Oxygen Car
		 * and Tire (Boys relationship with a girl---> if your not there I m not there)
		 * 
		 * 2)Aggregation A class has-A B class in such a way that A can function if B is
		 * not functioning, It is called as "Loose Coupling". Ex: Mobile and Sim card
		 * Human and food Human and mobile (Girl relationship with boy, if not u ,
		 * someone else) -------------------------------------------
		 * 
		 */
	}

}
