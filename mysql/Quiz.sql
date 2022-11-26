# DELETE SCHEMA IF EXSIT
DROP SCHEMA IF EXISTS `quiz`;
CREATE SCHEMA `quiz`;

CREATE TABLE `quiz`.`user` (
  `user_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(255),
  `phone` varchar(30),
  `isAdmin` tinyint NOT NULL DEFAULT 0,
  `isActive` tinyint NOT NULL DEFAULT 1
);

CREATE TABLE `quiz`.`submission` (
  `submission_id` int PRIMARY KEY AUTO_INCREMENT,
  `score` int,
  `start_time` timestamp,
  `end_time` timestamp,
  `user_id` int,
  `quiz_type_id` int
);

CREATE TABLE `quiz`.`result` (
  `result_id` int PRIMARY KEY AUTO_INCREMENT,
  `user_choice` varchar(255),
  `question_id` int,
  `submission_id` int
);

CREATE TABLE `quiz`.`quizType` (
  `quiz_type_id` int PRIMARY KEY AUTO_INCREMENT,
  `type_name` varchar(30),
  `time_limit` int,
  `description` varchar(255)
);

CREATE TABLE `quiz`.`question` (
  `question_id` int PRIMARY KEY AUTO_INCREMENT,
  `question_type` varchar(255),
  `description` varchar(255),
  `correct_answer` varchar(255),
  `quiz_type_id` int
);

CREATE TABLE `quiz`.`option` (
  `option_id` int PRIMARY KEY AUTO_INCREMENT,
  `description` varchar(255),
  `question_id` int
);

CREATE TABLE `quiz`.`feedback` (
  `feedback_id` int PRIMARY KEY AUTO_INCREMENT,
  `rate` int,
  `comment` varchar(255),
  `quiz_type_id` int
);

ALTER TABLE `quiz`.`submission` ADD FOREIGN KEY (`user_id`) REFERENCES `quiz`.`user` (`user_id`);

ALTER TABLE `quiz`.`submission` ADD FOREIGN KEY (`quiz_type_id`) REFERENCES `quiz`.`quizType` (`quiz_type_id`);

ALTER TABLE `quiz`.`result` ADD FOREIGN KEY (`question_id`) REFERENCES `quiz`.`question` (`question_id`);

ALTER TABLE `quiz`.`result` ADD FOREIGN KEY (`submission_id`) REFERENCES `quiz`.`submission` (`submission_id`);

ALTER TABLE `quiz`.`question` ADD FOREIGN KEY (`quiz_type_id`) REFERENCES `quiz`.`quizType` (`quiz_type_id`);

ALTER TABLE `quiz`.`option` ADD FOREIGN KEY (`question_id`) REFERENCES `quiz`.`question` (`question_id`);

ALTER TABLE `quiz`.`feedback` ADD FOREIGN KEY (`quiz_type_id`) REFERENCES `quiz`.`quizType` (`quiz_type_id`);

# Create some quiz types
INSERT INTO `quiz`.`quizType` (`type_name`, `time_limit`, `description`) VALUES ('Java', 60, 'Java quiz');
INSERT INTO `quiz`.`quizType` (`type_name`, `time_limit`, `description`) VALUES ('SQL', 60, 'SQL quiz');
INSERT INTO `quiz`.`quizType` (`type_name`, `time_limit`, `description`) VALUES ('Spring', 60, 'Spring Framework quiz');

# Create 20 different questions & options for each type
# JAVA questions
INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of the following is not a Java features?', 'Dynamic', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Dynamic', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Architecture Neutral', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Use of pointers', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Object-oriented', 1);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', '_____ is used to find and fix bugs in the Java programs.', 'JDB', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('JRE', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('JDK', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('JDB', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('JAV', 2);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What is the return type of the hashCode() method in the Object class?', 'int', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Object', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('long', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('void', 3);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of the following is a valid declaration of a char?', 'char[] ch = new char[5]', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('char[] ch = new char[5];', 4);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('char ch = new char();', 4);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('char[] ch = new char([5]);', 4);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('char ch = new char[5];', 4);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of the following is a valid long literal?', 'ABH8097', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('ABH8097', 5);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('L990023', 5);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('904423', 5);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('0xnf029L', 5);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?', 'javap tool', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('javap tool', 6);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('javaw command', 6);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Javadoc tool', 6);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('javah command', 6);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Number of primitive data types in Java are?', '8', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('7', 7);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('8', 7);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('9', 7);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('10', 7);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What is the size of float and double in java?', '32 bit and 64 bit', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('32 bit and 64 bit', 8);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('32 bit and 32 bit', 8);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('64 bit and 64 bit', 8);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('64 bit and 32 bit', 8);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Select the valid statement.', 'int a = 10;', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int a = 10;', 9);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int a = 010;', 9);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int a = 0x10;', 9);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('All of the above', 9);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'When an array is passed to a method, what does the method receive?', 'A reference to the array', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('A reference to the array', 10);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('A copy of the array', 10);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('A copy of the reference to the array', 10);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('The array itself', 10);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Select the valid statement to declare and initialize an array.', 'int[] a = new int[5];', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int[] a = new int[5];', 11);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int[] a = new int(5);', 11);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int[] a = new int[];', 11);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('int[] a = new int([5]);', 11);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'A class can have multiple constructors.', 'True', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 12);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 12);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'int x[] = new int[]{10,20,30}; Arrays can also be created and initialize as in above statement.', 'True', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 13);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 13);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'In an instance method or a constructor, "this" is a reference to the current object.', 'True', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 14);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 14);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Garbage Collection is manual process.', 'False', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 15);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 15);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Java is a platform independent language.', 'True', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 16);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 16);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Constructor overloading is not possible in Java.', 'False', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 17);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 17);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Assignment operator is evaluated Left to Right.', 'False', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 18);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 18);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Java is a statically typed language.', 'True', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 19);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 19);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'A .class file contains bytecodes?', 'True', 1);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 20);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 20);


# SQL questions
INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'When you have a subquery inside of the main query, which query is executed first?', 'The main query', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('The main query', 21);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('The subquery', 21);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Both queries are executed at the same time', 21);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('The queries are executed in a random order', 21);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'You need to export the entire database, including the database objects, in addition to the data. Which command-line tool do you use?', 'mysqldump', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('mysqldump', 22);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('mysqlimport', 22);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('mysql', 22);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('mysqladmin', 22);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of the following is not a valid data type in MySQL?', 'FLOAT', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('FLOAT', 23);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('VARCHAR', 23);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('BLOB', 23);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('INT', 23);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'You must ensure the accuracy and reliability of the data in your database. You assign some constraints to limit the type of data that can go into a table. What type of constraints are you assigning?', 'Data integrity constraints', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Data integrity constraints', 24);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Data type constraints', 24);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Data access constraints', 24);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Data security constraints', 24);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'MySQL uses environment variables in some of the programs and command-line operations. Which variable is used by the shell to find MySQL programs?', 'MYSQL_HOME', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MYSQL_HOME', 25);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MYSQL_PATH', 25);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MYSQL_BIN', 25);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MYSQL_BIN_PATH', 25);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'If you were building a table schema to store student grades as a letter (A, B, C, D, or F) which column type would be the best choice?', 'CHAR', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('CHAR', 26);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('VARCHAR', 26);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('INT', 26);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('FLOAT', 26);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which query would NOT be used to administer a MySQL server?', 'SELECT', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SELECT', 27);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SHOW', 27);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SET', 27);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('GRANT', 27);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'MySQL server can operate in different SQL modes, depending on the value of the sql_mode system variable. Which mode changes syntax and behavior to conform more closely to standard SQL?', 'ANSI', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('ANSI', 28);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('STRICT', 28);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('TRADITIONAL', 28);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MYSQL', 28);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'MySQL programs are a set of command-line utilities that are provided with typical MySQL distributions. MySQL is designed to be a database.', 'client and server', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('client and server', 29);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('database and programming', 29);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('user and administrator', 29);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('syntax and objects', 29);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which MySQL command shows the structure of a table?', 'DESCRIBE table;', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('DESCRIBE table;', 30);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SHOW table;', 30);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('EXPLAIN table;', 30);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('INFO table;', 30);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'MySQL uses security based on _ for all connections, queries, and other operations that users can attempt to perform.', 'access control lists', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('access control lists', 31);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('administrator schema', 31);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('user settings', 31);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('encrypted algorithms', 31);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which MySQL command modifies data records in a table?', 'UPDATE', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('UPDATE', 32);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MODIFY', 32);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('CHANGE', 32);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('ALTER', 32);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'MySQL is a relational database management system (RDBMS) based on Structured Query Language (SQL).', 'True', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 33);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 33);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'It is mandatory to define constraint for each attribute of a table.', 'False', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 34);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 34);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Each table can contain more than one primary key.', 'False', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 35);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 35);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'SQL Server automatically sets the NOT NULL constraint for all the primary key columns if the NOT NULL constraint is not specified for these columns.', 'True', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 36);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 36);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Unique constraints ensures that all the values in a column are distinct/unique.', 'True', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 37);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 37);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'A NULL value is treated as a blank or zero.', 'False', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 38);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 38);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'By default, each attribute can take NULL values except for the primary key.', 'True', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 39);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 39);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'A relation may have multiple foreign keys.', 'True', 2);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 40);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 40);

# Spring Question
INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'How filters are used in Spring Web?', 'Filters are called before a request hits the DispatcherServlet. They allow for interception-style, chained processing of web requests for security, timeouts, and other purposes.', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Filters are called before a request hits the DispatcherServlet. They allow for interception-style, chained processing of web requests for security, timeouts, and other purposes.', 41);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Filters are used with a checksum algorithm that will filter invalid bytes out of a byte stream request body and allow for processing of HTTP requests from the DispatcherRequestServlet.', 41);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Filters are used with a checksum algorithm that will filter invalid bytes out of an octet stream a multipart upload and allow for chained processing of WebDispatcherServlet requests.', 41);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Filters are used to validate request parameters out of the byte stream request body and allow for processing of requests from the DispatcherRequestServlet.', 41);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of these is a valid Advice annotation?', '@AfterReturning', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@AfterReturning', 42);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@AfterError', 42);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@AfterException', 42);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@AfterExecution', 42);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What is the default scope of a Spring bean?', 'Singleton', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Singleton', 43);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Prototype', 43);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Request', 43);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Session', 43);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'The process of linking aspects with other objects to create an advised object is called', 'weaving', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('weaving', 44);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('dynamic chaining', 44);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('banding', 44);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('interleaving', 44);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which of these is not a valid method on the JoinPoint interface?', 'getExceptions()', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('getExceptions()', 45);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('getArgs()', 45);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('getSignature()', 45);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('getTarget()', 45);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What is the root interface for accessing a Spring bean container?', 'BeanFactory', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('BeanFactory', 46);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SpringInitContainer', 46);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('ResourceLoader', 46);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('ApplicationEventPublisher', 46);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which annotation can be used within Spring Security to apply method level security?', '@Secured', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@Secured', 47);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@RequiresRole', 47);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@RestrictedTo', 47);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('@SecurePath', 47);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Which property can be used to change the port of a Spring application?', 'server.port', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('server.port', 48);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Port', 48);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('spring.port', 48);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('spring.settings.port', 48);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What is the name of the central servlet that dispatches requests to controllers?', 'DispatcherServlet', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('DispatcherServlet', 49);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('ControllerServlet', 49);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SpringServlet', 49);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('DispatchingDelegatorServlet', 49);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'How does Spring generate bean names for classes annotated with @Component that do not specify a name?', 'It uses the short name of the class with the first letter in lowercase.', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('It uses the short name of the class with the first letter in lowercase.', 50);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('It uses the short name of the class.', 50);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('It uses the full name of the class.', 50);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('It uses the short name of the class in uppercase.', 50);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'Modularization of a concern that cuts across multiple classes is known as a(n)____.', 'aspect', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('aspect', 51);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('crosscut', 51);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('sidecut', 51);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('multiclass', 51);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What is a Spring bean uniquely identified?', 'a unique String name', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('a unique String name', 52);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('an autogenerated UUID', 52);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('an auto-incremented Integer ID', 52);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('an ID derived from its location in memory', 52);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Can be bean be configured to have an inner bean?', 'True', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 53);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 53);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Spring beans are singletons by default.', 'True', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 54);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 54);


INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Spring beans are thread-safe by default.', 'True', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 55);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 55);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('True or False', 'Spring beans are lazy by default.', 'True', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('True', 56);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('False', 56);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What pattern does Spring MVC implement to delegate request processing to controllers?', 'Front Controller', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Front Controller', 57);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Facade', 57);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Reactive Chain', 57);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('Observer', 57);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What interface can be specified as a parameter in a controller method signature to handle file uploads?', 'MultipartFile', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MultipartFile', 58);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('File', 58);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('FilePath', 58);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('MvcFile', 58);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What property can be used to set the active Spring profiles?', 'spring.profiles.active', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('spring.profiles.active', 59);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('active.profile', 59);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('spring.active.profile', 59);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('profiles', 59);

INSERT INTO `quiz`.`question` (`question_type`, `description`, `correct_answer`, `quiz_type_id`) VALUES ('Multiple Choice', 'What interface is used to represent a permission in Spring Security?', 'AccessRule', 3);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('AccessRule', 60);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('GrantedAuthority', 60);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('SecurityChain', 60);
INSERT INTO `quiz`.`option` (`description`, `question_id`) VALUES ('PermissionMatrix', 60);

# Create default admin user
INSERT INTO `quiz`.`user` (`first_name`, `last_name`, `email`, `password`, `isAdmin`, `isActive`) VALUES ('Inupedia', 'Zhang', 'admin@inupedia.com', 'password', 1, 1);

# Check admin user
SELECT * FROM `quiz`.`user` WHERE isAdmin = 1;

















