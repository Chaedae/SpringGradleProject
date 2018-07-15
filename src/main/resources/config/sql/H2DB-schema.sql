---------------------------
--   Sample DDL History  --
---------------------------
DROP ALL OBJECTS;
-- User
CREATE TABLE TB_USER (
	USERID    VARCHAR2(20)   NOT NULL,
	PWD        VARCHAR2(128)  NOT NULL,
	USERNM    VARCHAR2(20)   NOT NULL,
	HPNO	   VARCHAR2(20),
	EMAIL      VARCHAR2(50),
	REGDT     DATE,
	REGID     VARCHAR2(20)
);

