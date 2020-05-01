SELECT CONCAT(fName, " ", lName) AS "Employee", SUM(hours) AS "Hours"
FROM Person
JOIN Employee ON Person.ssn=Employee.ssn
JOIN Hours ON Employee.ssn=Hours.ssn
GROUP BY fName, lName;
