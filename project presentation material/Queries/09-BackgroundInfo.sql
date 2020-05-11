SELECT Experience.applicantId, hasBeenBankrupt, involvedInLawsuit, creditScore, income, contractorLicenseNumber
FROM Experience
JOIN Finances ON Experience.applicantId=Finances.applicantId;