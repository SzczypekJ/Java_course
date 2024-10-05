SELECT * FROM Students
JOIN Enrollments ON Students.studentId = Enrollments.studentId
JOIN Courses ON Enrollments.courseId = Courses.courseId
JOIN Animals ON Students.studentId = Animals.studentId
JOIN Cars ON Students.studentId = Cars.studentId
JOIN Laptops ON Students.studentId = Laptops.studentId
JOIN Phones ON Students.studentId = Phones.studentId
JOIN BookLoans ON Students.studentId = BookLoans.studentId
JOIN Books ON BookLoans.bookId = Books.bookId
JOIN Libraries ON Books.libraryId = Libraries.libraryId
JOIN StudentExams ON Students.studentId = StudentExams.studentId
JOIN Exams ON StudentExams.examId = Exams.examId;
