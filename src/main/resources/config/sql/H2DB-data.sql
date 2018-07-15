---------------------------------
--   Sample DDL History (Data) --
---------------------------------

-- User
INSERT INTO TB_USER 
(
	USERID
	, PWD    
	, USERNM
	, HPNO	
	, EMAIL  
	, REGDT 
	, REGID 
) 
VALUES 
(
	'master'
	, 'a1234'
	, 'master'
	, '01012345678'
	, 'master@chaedae.com'
	, SYSDATE
	, 'master'
);

INSERT INTO TB_USER 
(
	USERID
	, PWD    
	, USERNM
	, HPNO	
	, EMAIL  
	, REGDT 
	, REGID  
) 
VALUES 
(
	'test01'
	, 'a1234'
	, 'tester01'
	, '01011112222'
	, 'test01@chaedae.com'
	, SYSDATE
	, 'master'
);

INSERT INTO TB_USER 
(
	USERID
	, PWD    
	, USERNM
	, HPNO	
	, EMAIL  
	, REGDT 
	, REGID 
) 
VALUES 
(
	'test02'
	, 'a1234'
	, 'tester02'
	, '01033334444'
	, 'test02@chaedae.com'
	, SYSDATE
	, 'master'
);

INSERT INTO TB_USER 
(
	USERID
	, PWD    
	, USERNM
	, HPNO	
	, EMAIL  
	, REGDT 
	, REGID  
) 
VALUES 
(
	'test03'
	, 'a1234'
	, 'tester03'
	, '01055556666'
	, 'test03@chaedae.com'
	, SYSDATE
	, 'master'
);

commit;
