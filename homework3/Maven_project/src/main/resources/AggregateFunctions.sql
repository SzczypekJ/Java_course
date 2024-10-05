-- without HAVING
SELECT COUNT(*) AS totalStudents FROM Students;

SELECT AVG(age) AS averageAge FROM Animals;

SELECT SUM(year) AS totalYears FROM Cars GROUP BY model;

SELECT MIN(score) AS lowestScore FROM StudentExams GROUP BY examId;

SELECT MAX(score) AS highestScore FROM StudentExams GROUP BY studentId;

SELECT COUNT(*) AS totalBooks FROM Books GROUP BY libraryId;

SELECT COUNT(*) AS totalCourses FROM Courses;

-- with HAVING 
SELECT COUNT(*) AS totalStudents FROM Students GROUP BY lastName HAVING totalStudents > 1;

SELECT AVG(age) AS averageAge FROM Animals GROUP BY animalType HAVING averageAge > 3;

SELECT SUM(year) AS totalYears FROM Cars GROUP BY model HAVING totalYears > 4000;

SELECT MIN(score) AS lowestScore FROM StudentExams GROUP BY examId HAVING lowestScore > 50;

SELECT MAX(score) AS highestScore FROM StudentExams GROUP BY studentId HAVING highestScore < 90;

SELECT COUNT(*) AS totalBooks FROM Books GROUP BY libraryId HAVING totalBooks > 2;

SELECT COUNT(*) AS totalCourses FROM Courses HAVING totalCourses > 5;
