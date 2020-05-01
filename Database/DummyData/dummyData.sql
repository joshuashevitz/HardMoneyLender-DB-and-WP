-- Rows for Person
INSERT INTO Person (ssn, email, fName, lName, sex, dateOfBirth) VALUES ('987654321', 'cjohn@yahoo.com', 'Caroline', 'John', 'F', '1990-01-10');
INSERT INTO Person (ssn, email, fNaSme, lName, sex, dateOfBirth) VALUES ('666007777', 'sfieder@gmail.com', 'Stan', 'Fiederheimer', 'M', '1970-03-23');
INSERT INTO Person (ssn, email, fName, lName, sex, dateOfBirth) VALUES ('000112222', 'pdilo@hotmail.com', 'Paige', 'Dilo', 'F', '1989-09-24');
INSERT INTO Person (ssn, email, fName, lName, sex, dateOfBirth) VALUES ('999999999', 'gklink@yahoo.com', 'George', 'Klink', 'M', '1985-07-29');

-- Rows for Applicant
INSERT INTO Applicant (ssn) VALUES ('987654321');
INSERT INTO Applicant (ssn) VALUES ('999999999');

-- Rows for Employee
INSERT INTO Employee (ssn, position, username, password) VALUES ('666007777', 'Originator', 'fiederLord', 'toor');
INSERT INTO Employee (ssn, position, username, password) VALUES ('000112222', 'Originator', 'pugaboo', 'qwerty99');

-- Rows for Degree
INSERT INTO Degree (ssn, study, level) VALUES ('666007777', 'Financing', 'BA');

-- Rows for Phone
INSERT INTO Phone (ssn, number, type) VALUES ('666007777', '4100009911', 'Cell');
INSERT INTO Phone (ssn, number, type) VALUES ('000112222', '1337800813', 'Cell');

-- Rows for Experience
INSERT INTO Experience (applicantId) VALUES ('00002');
INSERT INTO Experience (applicantId) VALUES ('00003');

-- Rows for Projects
INSERT INTO Projects (applicantId, status, state, city, street, zipCode) VALUES ('00002', 'Working', 'CA', 'San Francisco', '123 Madeup Road', '12345');

-- Rows for Property
INSERT INTO Property (applicantId, aquisitionDate, exitStrategy, renovationStage, state, city, street, zipCode, currentValue, futureValue) VALUES ('00001', '2015-12-25', 'Demolish', 'Rebuild', 'FL', 'Branford', '172 Orange Hood Court', '32188', '80000', '100000');
INSERT INTO Property (applicantId, aquisitionDate, exitStrategy, renovationStage, state, city, street, zipCode, currentValue, futureValue) VALUES ('00002', '2019-05-02', 'Sell', 'Eletric', 'CO', 'Bolder', '3312 Rocky Mountain Drive', '80922', '75000', '500000');
UPDATE Property SET street = '1 President Street' WHERE (applicantId = '00001') and (aquisitionDate = '2020-03-23');
INSERT INTO Property (applicantId, aquisitionDate, exitStrategy, renovationStage, state, city, street, zipCode, currentValue, futureValue) VALUES ('00003', '2020-04-01', 'Sell', 'Destruction', 'MA', 'Blately', '993 Mitten Way', '48492', '50000', '60000');

-- Rows for Hours
INSERT INTO Hours (ssn, date, hours) VALUES ('111223333', '2020-04-30', '8');
INSERT INTO Hours (ssn, date, hours) VALUES ('666007777', '2020-04-27', '10');
INSERT INTO Hours (ssn, date, hours) VALUES ('666007777', '2020-04-28', '10');
INSERT INTO Hours (ssn, date, hours) VALUES ('666007777', '2020-04-30', '5');
INSERT INTO Hours (ssn, date, hours) VALUES ('000112222', '2020-04-27', '8');
INSERT INTO Hours (ssn, date, hours) VALUES ('000112222', '2020-04-28', '8');
INSERT INTO Hours (ssn, date, hours) VALUES ('000112222', '2020-04-30', '8');

-- Rows for Loan
INSERT INTO Loan (applicantId, reviewerSsn, percentForConstruction, percentForPurchase, purchasePrice, status) VALUES ('00002', '111223333', '50', '50', '2000', 'Pending');
INSERT INTO Loan (applicantId, reviewerSsn, percentForConstruction, percentForPurchase, purchasePrice, status) VALUES ('00003', '111223333', '10', '90', '9000', 'Rejected');
INSERT INTO Loan (applicantId, reviewerSsn, percentForConstruction, percentForPurchase, purchasePrice, status) VALUES ('00003', '111223333', '30', '70', '10000', 'Accepted');

-- Rows for Profits
INSERT INTO Profits (loanId, loanAmount, grossIncome) VALUES ('5', '10000', '1000');

-- Rows for Finances
INSERT INTO Finances (applicantId, jobTitle, hasBeenBankrupt, involvedInLawsuit, creditScore, income, assets) VALUES ('00002', 'Media Influencer', 'F', 'F', '500', '100000', '1000000');
INSERT INTO Finances (applicantId, jobTitle, hasBeenBankrupt, involvedInLawsuit, creditScore, income, assets) VALUES ('00003', 'Carpenter', 'F', 'F', '900', '70000', '10000');

-- Rows for View
INSERT INTO View (employeeSsn, applicantId) VALUES ('111223333', '00002');
INSERT INTO View (employeeSsn, applicantId) VALUES ('666007777', '00002');
INSERT INTO View (employeeSsn, applicantId) VALUES ('000112222', '00003');
