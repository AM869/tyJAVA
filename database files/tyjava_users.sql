-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2017 at 03:51 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tyjava_users`
--

-- --------------------------------------------------------

--
-- Table structure for table `advanced_questions`
--

CREATE TABLE `advanced_questions` (
  `id` int(11) NOT NULL,
  `questionbody` varchar(300) NOT NULL,
  `answer1` varchar(300) NOT NULL,
  `answer2` varchar(300) NOT NULL,
  `answer3` varchar(300) NOT NULL,
  `answer4` varchar(300) NOT NULL,
  `correctanswer` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `advanced_questions`
--

INSERT INTO `advanced_questions` (`id`, `questionbody`, `answer1`, `answer2`, `answer3`, `answer4`, `correctanswer`) VALUES
(1, 'Can a constructor be made final or static?', 'It can be made final but not static.', 'It can be made both.\r\n', 'It can''t be either.', 'It can be static but not final.', 'C'),
(2, 'Can a constructor be made static or abstract?', 'It can be made abstract but not static.', 'It can''t be both at the same time.But it can be either static or abstract.', 'It can be made static but not abstract.', 'It can''t be either.', 'D'),
(3, 'Dynamic binding uses which information for binding?\r\n', 'type.\r\n', 'object.\r\n', 'Both of the above.\r\n', 'None of the above.\r\n', 'B'),
(4, 'Method Overloading is an example of', 'Static Binding.\r\n', 'Dynamic Binding.\r\n', 'Both of the above.\r\n', 'None of the above.\r\n', 'A'),
(5, 'Method Overriding is an example of', 'Static Binding.', 'Dynamic Binding.', 'Both of the above.', 'None of the above.', 'B'),
(6, 'Static binding uses which information for binding?\r\n', 'type.\r\n', 'object.\r\n', 'Both of the above.\r\n', 'None of the above.', 'A'),
(7, 'This is the parent of Error and Exception classes.\r\n', 'Throwable\r\n', 'Catchable', 'MainError', 'MainException\r\n', 'A'),
(8, 'Under what conditions is an object''s finalize() method invoked by the\r\ngarbage collector?\r\n', 'When it detects that the object has become unreachable.\r\n', 'As soon as object is set as null.\r\n', 'At fixed interval it checks for null value.\r\n', 'None of the above.\r\n', 'A'),
(9, 'What are Wrapper classes?', 'These are classes that allow primitive types to be accessed as objects.\r\n', 'These are classes that wraps functionality of an existing class.\r\n', 'Both of the above.', 'None of the above.', 'A'),
(10, 'What happens when thread''s sleep() method is called?\r\n', 'Thread returns to the ready state.\r\n', 'Thread returns to the waiting state.\r\n', 'Thread starts running.\r\n', 'None of the above.', 'B'),
(11, 'What happens when thread''s yield() method is called?\r\n', 'Thread returns to the ready state.\r\n', 'Thread returns to the waiting state.', 'Thread starts running.\r\n\r\n', 'None of the above.\r\n', 'A'),
(12, 'What invokes a thread''s run() method?\r\n', 'JVM invokes the thread''s run() method when the thread is initially executed.\r\n', 'Main application running the thread.', 'start() method of the thread class.\r\n', 'None of the above.\r\n', 'A'),
(13, 'What is a marker interface?\r\n', 'marker interface is an interface with no method.\r\n', 'marker interface is an interface with single method, mark().\r\n', 'marker interface is an interface with single method, marker().\r\n', 'none of the above.\r\n', 'A'),
(14, 'What is a transient variable?\r\n', 'A t ransient variable is a variable which is serialized during Serialization.\r\n', 'A transient variable is a variable that may not be serialized during Serialization.\r\n', 'A transient variable is a variable which is to be marked as serializable.', 'None of the above.\r\n', 'B'),
(15, 'What is composition?', 'Composition is a data structure.\r\n', 'Composition is a way to create an object.\r\n', 'Holding the reference of the other class within some other class is known as composition.\r\n', 'None of the above.\r\n', 'C'),
(16, 'What is JIT compiler?\r\n', 'JIT improves the runtime performance of computer programs based on bytecode.', 'JIT is an application development framework.\r\n', 'JIT is an implementation of the Java Virtual Machine which executes Java programs.\r\n', 'None of the above.\r\n', 'A'),
(17, 'What is runtime polymorphism?\r\n', 'Runtime polymorphism is a process in which a call to an overridden method is resolved at\r\nruntime rather than at compile-time.', 'Runtime polymorphism is a process in which a call to an overloaded method is resolved at\r\nruntime rather than at compile-time.\r\n', 'Both of the above.\r\n', 'None of the above.', 'A'),
(18, 'What is Set Interface?', 'Set is a collection of element which contains elements along with their key.', 'Set is a collection of element which contains hashcode of elements.', 'Set is a collection of element which cannot contain duplicate elements.', 'Set is a collection of element which can contain duplicate elements.', 'C'),
(19, 'What is static block?\r\n', 'It is used to create syncronized code.\r\n', 'There is no such block.\r\n', 'It is used to initialize the static data member., It is excuted before main method at the time of\r\nclass loading.\r\n', 'None of the above.\r\n', 'C'),
(20, 'What is synchronization?\r\n', 'Synchronization is the capability to control the access of multiple threads to shared resources.', 'Synchronization is the process of writing the state of an object to another object.', 'Synchronization is the process of writing the state of an object to byte stream.', 'None of the above.\r\n', 'A'),
(21, 'What is TreeSet Interface?\r\n', 'It is a Set implemented when we want elements in a tree based order.\r\n', 'It is a Set implemented when we want elements in a sorted order.\r\n', 'It is a Set implemented when we want elements in a binary tree format.', 'It is a Set implemented when we want elements in a hiearchical order.\r\n', 'B'),
(22, 'What is true about a final class?\r\n', 'class declared final is a final class.\r\n', 'Final classes are created so the methods implemented by that class cannot be overridden.', 'It can''t be inherited.\r\n', 'All of the above.', 'D'),
(23, 'What will happen if static modifier is removed from the signature of the\r\nmain method?', 'Compilation Error.\r\n', 'RunTime Error: NoSuchMethodError.\r\n', 'Program will compile and run without any output.\r\n', 'Program will compile and run to show the required output.\r\n', 'B'),
(24, 'When finally block gets executed?\r\n', 'Always when try block get executed, no matter exception occurred or not.', 'Always when a method get executed, no matter exception occurred or not.\r\n', 'Always when a try block get executed, if exception do not occur.\r\n', 'Only when exception occurs in try block code.', 'A'),
(25, 'When static binding occurs?', 'Static binding occurs during Compile time.', 'Static binding occurs during load time.\r\n', 'Static binding occurs during runtime.', 'None of the above.\r\n', 'A'),
(26, 'Which is the way in which a thread can enter the waiting state?', 'Invoke its sleep() method.\r\n', 'Invoke object''s wait method.', 'Invoke its suspend() method.\r\n', 'All of the above.', 'D'),
(27, 'Which method must be implemented by all threads?', 'wait()\r\n', 'start()\r\n', 'stop()\r\n', 'run()', 'D'),
(28, 'Which of the following is a marker interface?\r\n', 'serializable\r\n', 'comparable\r\n', 'cloneable\r\n', 'none of the above.\r\n', 'A'),
(29, 'Which of the following is a thread safe?', 'StringBuilder.\r\n', 'StringBuffer.\r\n', 'Both of the above.\r\n', 'None of the above.\r\n', 'B'),
(30, 'Which of the following is Faster, StringBuilder or StringBuffer?', 'StringBuilder.', 'StringBuffer.', 'Both of the above.', 'None of the above.', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `basic_questions`
--

CREATE TABLE `basic_questions` (
  `id` int(11) NOT NULL,
  `questionbody` varchar(300) NOT NULL,
  `answer1` varchar(300) NOT NULL,
  `answer2` varchar(300) NOT NULL,
  `answer3` varchar(300) NOT NULL,
  `answer4` varchar(300) NOT NULL,
  `correctanswer` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basic_questions`
--

INSERT INTO `basic_questions` (`id`, `questionbody`, `answer1`, `answer2`, `answer3`, `answer4`, `correctanswer`) VALUES
(1, 'A compiled java file ends with ', '.java', '.javac', '.jar', '.class', 'D'),
(2, 'An object could be ', 'anything', 'an algorithm', 'a data container', 'a program', 'A'),
(3, 'Array indexing always starts with the number', '0', '1', '2', '0.0', 'A'),
(4, 'Byte code is the machine language for a hypothetical computer called the', 'Java Byte Code Compiler', 'Java Byte Code Interpreter', 'Java Virtual Machine', 'Java Memory Machine', 'C'),
(5, 'In  general a good programming way is to declare all class fields as', 'private', 'protected', 'without declaration (default-package access)', 'public', 'A'),
(6, 'In Java, 12%5 =', '1', '2', '2.5', '8', 'B'),
(7, 'In Java, 5/2 =', '2', '2.5', '3', 'none of the above', 'A'),
(8, 'In Java, the % refers to', 'percentages', 'division', 'modulus operator', 'data storage', 'C'),
(9, 'In which case, a program is expected to recover?', 'If an error occurs.', 'If an exception occurs.', 'Both of the above.', 'None of the above.', 'B'),
(10, 'Java allows for three forms of commenting', '// single line, ** block lines, /*/ documentation', '// single line, /*...*/ block lines, /**...*/ documentation', '/ single line, /* block lines, ** documentation', ' // single line, //...// block lines, //*...*// documentation', 'B'),
(11, 'Java Source Code is compiled into', '.exe', 'Source Code', '.Obj', 'Bytecode', 'D'),
(12, 'Object-Oriented Programming means', 'Being objective about what you develop', 'Designing the application based on the objects discovered when analyzing the problem', 'Writing an algorithm before writing your program and having a test plan', 'Writing a program composed of java classes', 'B'),
(13, 'The name of a variable is known as its:', 'identifier', 'constant', 'data type', 'base', 'A'),
(14, 'Variables that are declared, but not initialized, contain', 'blank spaces', 'zeros', '"garbage" values', 'nothing - they are empty', 'C'),
(15, 'Variables that describe the data stored at that particular memory location are called', 'identifiers', 'constant variables', 'floating point variables', 'mnemonic variables', 'D'),
(16, 'What is a class in java?', 'A class is a blue print from which individual objects are created. A class can contain fields and methods to describe the behavior of an object.', 'class is a special data type.', 'class is used to allocate memory to a data type.', 'none of the above.', 'A'),
(17, 'What is an immutable object?', 'An immutable object can be changed once it is created.', 'An immutable object can''t be changed once it is created.', 'An immutable object is an instance of an abstract class.', 'None of the above.', 'B'),
(18, 'What is correct syntax for main method of a java class?', 'public static int main(St ring[] args)\r\n', 'public int main(St ring[] args)\r\n', 'public static void main(St ring[] args)\r\n', 'None of the above.\r\n', 'C'),
(19, 'What is function overloading?', 'Methods with same name but different parameters.', 'Methods with same name but different return types.', 'Methods with same name, same parameter types but different parameter names.', 'None of the above.', 'A'),
(20, 'What is JRE?', 'JRE is a java based GUI application.', 'JRE is an application development framework.', ' JRE is an implementation of the Java Virtual Machine which executes Java programs.', 'None of the above.', 'C'),
(21, 'What is Serialization?', 'Serialization is the process of writing the state of an object to another object.', 'Serialization is the process of writing the state of an object to a byte stream.', 'Both of the above.', 'None of the above.', 'B'),
(22, 'What is the default value of byte variable?', '0', '0.0', 'null', 'not defined', 'A'),
(23, 'What is the default value of int variable?', '0', '0.0', 'null', 'not defined', 'A'),
(24, 'What is the default value of short variable?', '0.0', '0', 'null', 'not defined', 'B'),
(25, 'What is the size of boolean variable?', '8 bit', '16 bit', '32 or 64 bit depends on virtual machine', 'not precisely defined, is virtual machine dependent', 'D'),
(26, 'What is the size of byte variable?', '8 bit', '16 bit', '32 bit', '64 bit', 'A'),
(27, 'What is the size of char variable?', '8 bit', '16 bit', '32 bit', '64 bit', 'B'),
(28, 'What is the size of double variable?', '8 bit', '16 bit', '32 bit', '64 bit', 'D'),
(29, 'What is the size of float variable?', '8 bit', '16 bit', '32 bit', '64 bit', 'C'),
(30, 'What is the size of int variable?\r\n', '8 bit', '16 bit', '32 bit', '64 bit', 'C'),
(31, 'What is the size of long variable?', '8 bit', '16 bit', '32 bit', '64 bit', 'D'),
(32, 'What is the size of short variable?', '8 bit', '16 bit', '32 bit', '64 bit', 'B'),
(33, 'What of the following is the default value of a local variable?', 'null', '0', 'Depends upon the type of variable', 'Not assigned', 'D'),
(34, 'What of the following is the default value of an instance variable?', 'null\r\n', '0', 'Depends upon the type of variable', 'Not assigned', 'C'),
(35, 'When a data type must contain decimal numbers, assign the type', 'int', 'char', 'double', 'long int', 'C'),
(36, 'Which of the following is not a keyword in java?\r\n', 'static\r\n', 'Boolean', 'void', 'private', 'B'),
(37, 'Which of the following is not a keyword in java?', 'boolean', 'new', 'try', 'Integer', 'D'),
(38, 'Which of the following stands true about default modifier of class members?', 'By default, variables, methods and constructors can be accessed by subclass only.', 'By default, variables, methods and constructors can be accessed by any class lying in any package.', 'By default, variables, methods and constructors can be accessed by any class lying in the same package.', 'None of the above.', 'C'),
(39, 'Which of the following tool is used to execute java code?', 'jar', 'java', 'javac', 'javadoc', 'B'),
(40, 'Which of the tools is used to compile java code?', 'java', 'javac', 'jar', 'javadoc', 'B'),
(41, 'Which one is not correct?', 'A class needs to be instantiated before being used', 'An object exists in memory in run time', 'Class and Object are just different names for the same thing', 'An object is a variable, where its type is the class used to declare the variable', 'C');

-- --------------------------------------------------------

--
-- Table structure for table `intermediate_questions`
--

CREATE TABLE `intermediate_questions` (
  `id` int(11) NOT NULL,
  `questionbody` varchar(300) NOT NULL,
  `answer1` varchar(300) NOT NULL,
  `answer2` varchar(300) NOT NULL,
  `answer3` varchar(300) NOT NULL,
  `answer4` varchar(300) NOT NULL,
  `correctanswer` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intermediate_questions`
--

INSERT INTO `intermediate_questions` (`id`, `questionbody`, `answer1`, `answer2`, `answer3`, `answer4`, `correctanswer`) VALUES
(1, 'Can constructor be inherited?', 'True.', 'False.', 'Only if it is declared public.', 'Only if it is declared protected.', 'B'),
(2, 'Is it necessary that each try block must be followed by a finally block?\r\n', 'True.', 'Try must be followed by either catch or finally or both.', 'Only if we also have a catch block.', 'Try can be followed by a catch block or a finally block but not both at the same time.', 'B'),
(3, 'What is Abstraction?', 'Abstraction is a technique to define different methods of same type.', 'Abstraction is the ability of an object to take on many forms.', 'It refers to the ability to make a class abstract in OOP.\r\n', 'It is the ability of a class to inherit the properties from its superclass.', 'C'),
(4, 'What is an applet?', 'An applet is a Java program that runs in a Web browser.\r\n', 'Applet is a standalone java program.\r\n', 'Applet is a tool.\r\n', 'Applet is a run time environment.', 'A'),
(5, 'What is an immutable object?', 'An immutable object can be changed once it is created.', 'An immutable object can''t be changed once it is created.', 'An immutable object is an instance of an abstract class.', 'None of the above.\r\n', 'B'),
(6, 'What is an Interface?', 'Interface is a nested class.', 'Interface is an abstract class.', 'Interface is a concrete class.', 'None of the above.', 'D'),
(7, 'What is class variable?', 'class variables are static variables within a class but outside any method.', 'class variables are variables defined inside methods, constructors or blocks.', 'class variables are variables within a class but outside any method.\r\n', 'None of the above.', 'A'),
(8, 'What is Encapsulation?\r\n', 'Encapsulation is a technique to define different methods of same type.', 'Encapsulation is the ability of an object to take on many forms.\r\n', 'Encapsulation is the technique of making the fields in a class private and providing access to\r\nthe fields via public methods.', 'Encapsulation is the technique of making the methods in a class private and all fields public.\r\n', 'C'),
(9, 'What is function overloading?\r\n', 'Methods with same name but different parameters.', 'Methods with same name but different return types.\r\n', 'Methods with same name, same parameter types but different parameter names.', 'None of the above.', 'A'),
(10, 'What is function overriding?', 'If a subclass uses a method that is already provided by its parent class, it is known as Method\r\nOverriding.', 'If a subclass provides a specific implementation of a method that is already provided by its\r\nparent class, it is known as Method Overriding.', 'Both of the above.', 'None of the above.', 'B'),
(11, 'What is inheritance?', 'It is the process where one object acquires the properties of another.', 'Inheritance is the ability of an object to take on many forms.', 'Inheritance is a technique to define different methods of same type.', 'None of the above.', 'A'),
(12, 'What is instance variable?', 'Instance variables are static variables within a class but outside any method.', 'Instance variables are variables defined inside methods, constructors or blocks.\r\n', 'Instance variables are variables within a class but outside any method.', 'None of the above.\r\n', 'C'),
(13, 'What is local variable?', 'Variables defined inside methods, constructors or blocks are called local variables.', 'Variables defined outside methods, constructors or blocks are called local variables.', 'Static variables defined outside methods, constructors or blocks are called local variables.', 'None of the above.', 'A'),
(14, 'What is NullPointerException?', 'A NullPointerException is thrown when calling the instance method of a null object or\r\nmodifying/accessing field of a null object.', 'A NullPointerException is thrown when object is set as null.', 'A NullPointerException is thrown when object property is set as null.', 'None of the above.\r\n', 'A'),
(15, 'What is polymorphism?', 'Polymorphism is a technique to define different objects of same type.', 'Polymorphism is the ability of an object to take on many forms.', 'Polymorphism is a technique to define different methods of same type.', 'None of the above.', 'B'),
(16, 'What is the default value of a Boolean variable?', 'true', 'false', 'null', 'not defined', 'B'),
(17, 'What is the default value of char variable?', '''\\u0000''\r\n', '0', 'null', 'not defined', 'A'),
(18, 'What is the default value of double variable?', '0.0d\r\n', '0.0f', '0', 'not defined', 'A'),
(19, 'What is the default value of float variable?', '0.0d', '0.0f\r\n', '0', 'not defined', 'B'),
(20, 'What is the default value of long variable?\r\n', '0', '0.0', '0L', 'not defined', 'C'),
(21, 'What is the default value of Object variable?', 'undefined', 'null', '0', '&', 'B'),
(22, 'What is the default value of String variable?', '"', '""', 'null', 'not defined', 'C'),
(23, 'What kind of variables a class can consist of?', 'class variables, instance variables', 'class variables, local variables, instance variables', 'class variables', 'class variables, local variables', 'B'),
(24, 'Which of the following is false about String?', 'String is immutable.', 'String can be created using new operator.', 'String is a primitive data type.', 'A string literal is a reference to an instance of class String.', 'C'),
(25, 'Which of the following is true about private access modifier?', 'Variables, methods and constructors which are declared private can be accessed only by the\r\nmembers of the same class.', 'Variables, methods and constructors which are declared private can be accessed by any class\r\nlying in same package.\r\n', 'Variables, methods and constructors which are declared private in the superclass can be\r\naccessed only by its child class.', 'None of the above.', 'A'),
(26, 'Which of the following is true about protected access modifier?', 'Variables, methods and constructors which are declared protected can be accessed by any\r\nclass.', 'Variables, methods and constructors which are declared protected can be accessed by any\r\nclass lying in same package and a subclass of this class in other packages.', 'Variables, methods and constructors which are declared protected in the superclass can be\r\naccessed only by its child class.', 'Variables, methods and constructors which are declared protected cannot be accessed outside this class', 'B'),
(27, 'Which of the following is true about public access modifier?', 'Variables, methods and constructors which are declared public can be accessed by any class.', 'Variables, methods and constructors which are declared public can be accessed by any class\r\nlying in same package.\r\n', '- Variables, methods and constructors which are declared public in the superclass can be\r\naccessed only by its child class.', 'None of the above.', 'A'),
(28, 'Which of the following is true about String?', 'String is mutable.\r\n', 'String is immutable.', 'String is a data type.', 'None of the above.', 'B'),
(29, 'Which of the following is true about super class?\r\n', 'Variables, methods and constructors which are declared private can be accessed only by the\r\nmembers of the super class.\r\n', 'Variables, methods and constructors which are declared public in the superclass can be\r\naccessed by any class.\r\n', 'Variables, methods and constructors which are declared protected can be accessed by any\r\nsubclass of the super class.\r\n', 'All of the above', 'D'),
(30, 'Which of the following stands true about default modifier of class\r\nmembers?', 'By default, variables, methods and const ructors can be accessed by subclass only.', 'By default, variables, methods and constructors can be accessed by any class lying in any\r\npackage.', 'By default, variables, methods and constructors can be accessed by any class lying in the same\r\npackage.', 'None of the above', 'C'),
(31, 'Which operator is considered to be with highest precedence?\r\n', ' () , []\r\n', ' =\r\n', ' ?:', '%', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `registered_users`
--

CREATE TABLE `registered_users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mean1` float NOT NULL DEFAULT '0',
  `mean2` float NOT NULL DEFAULT '0',
  `mean3` float NOT NULL DEFAULT '0',
  `rank` varchar(15) NOT NULL DEFAULT 'Beginner',
  `count1` int(11) NOT NULL DEFAULT '0',
  `count2` int(11) NOT NULL DEFAULT '0',
  `count3` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advanced_questions`
--
ALTER TABLE `advanced_questions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `questionbody` (`questionbody`);

--
-- Indexes for table `basic_questions`
--
ALTER TABLE `basic_questions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `questionbody` (`questionbody`);

--
-- Indexes for table `intermediate_questions`
--
ALTER TABLE `intermediate_questions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `questionbody` (`questionbody`);

--
-- Indexes for table `registered_users`
--
ALTER TABLE `registered_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advanced_questions`
--
ALTER TABLE `advanced_questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `basic_questions`
--
ALTER TABLE `basic_questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT for table `intermediate_questions`
--
ALTER TABLE `intermediate_questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `registered_users`
--
ALTER TABLE `registered_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
