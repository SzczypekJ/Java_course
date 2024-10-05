-- Left Join
SELECT Students.firstName, Books.title
FROM Students
LEFT JOIN BookLoans ON Students.studentId = BookLoans.studentId
LEFT JOIN Books ON BookLoans.bookId = Books.bookId;

-- Right Join
SELECT Students.firstName, Books.title
FROM Students
RIGHT JOIN BookLoans ON Students.studentId = BookLoans.studentId
RIGHT JOIN Books ON BookLoans.bookId = Books.bookId;

-- Inner Join
SELECT Students.firstName, Courses.courseName
FROM Students
INNER JOIN Enrollments ON Students.studentId = Enrollments.studentId
INNER JOIN Courses ON Enrollments.courseId = Courses.courseId;

-- Outer Join
SELECT Students.firstName, Books.title
FROM Students
LEFT JOIN BookLoans ON Students.studentId = BookLoans.studentId
LEFT JOIN Books ON BookLoans.bookId = Books.bookId
UNION
SELECT Students.firstName, Books.title
FROM Students
RIGHT JOIN BookLoans ON Students.studentId = BookLoans.studentId
RIGHT JOIN Books ON BookLoans.bookId = Books.bookId;

SELECT Students.firstName, Cars.model, Cars.year
FROM Students
LEFT JOIN Cars ON Students.studentId = Cars.studentId;
