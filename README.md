# DatabaseViews-StoredProcedures
Recently, I worked on a backend project where I implemented Database Views and Stored Procedures using Spring Data JPA

💡 What I built:
✔ Fetched data using database Views (user_view, user_department_view)
✔ Used Stored Procedures (GetUsersBySalary, GetUsersByDepartment)
✔ Wrote native SQL queries with @Query
✔ Mapped results to DTOs for clean API responses
✔ Handled JOINs at database level instead of Java

🔥 Key Learning:
Working closer to the database helps in building more optimized and scalable backend systems.

💬 This project helped me understand how real-world applications handle data efficiently using DB-level logic instead of overloading the backend.


# DATABASE RELATED QUERIES

CREATE TABLE `users` (
  `department_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary` double DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsbg59w8q63i0oo53rlgvlcnjq` (`department_id`),
  CONSTRAINT `FKsbg59w8q63i0oo53rlgvlcnjq` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;



INSERT INTO `departments` (`id`, `dept_name`) VALUES (1, 'IT');
INSERT INTO `departments` (`id`, `dept_name`) VALUES (2, 'HR');
INSERT INTO `users` (`id`, `email`, `name`, `salary`, `department_id`) VALUES (1, 'ali@test.com', 'Ali', 50000, 1);
INSERT INTO `users` (`id`, `email`, `name`, `salary`, `department_id`) VALUES (2, 'ahmed@test.com', 'Ahmed', 60000, 2);
