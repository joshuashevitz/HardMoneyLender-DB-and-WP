SELECT CONCAT(fName, " ", lName) AS "Employee", SUM(hours) AS "Hours"
FROM Person
JOIN Employee ON Person.ssn=Employee.ssn
JOIN Hours ON Employee.ssn=Hours.ssn
WHERE date >= (
	SELECT DATE_SUB(CURDATE(), INTERVAL 2 WEEK)
)
GROUP BY fName, lName;