CREATE TABLE KOMMUN(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(64) NOT NULL,
  TAXRATE DECIMAL(18,4) NOT NULL
);

CREATE TABLE PERSON(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CHURCHMEMBER BIT,
    SALARY BIGINT,
    SALARYAFTERTAX BIGINT
);

