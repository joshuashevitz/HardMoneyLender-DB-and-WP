SELECT timetable
FROM Loan
WHERE status="Accepted"
GROUP BY applicantId;