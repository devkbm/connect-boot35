CREATE TABLE GRWBOARD (
	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	BOARD_ID            	BIGINT             	NOT NULL  	,
  	BOARD_P_ID          	BIGINT             	NULL    	,
  	BOARD_TYPE          	VARCHAR(10)     	NOT NULL	,
  	BOARD_NAME          	VARCHAR(500)		NULL    	,
  	BOARD_DESC          	TEXT			    NULL    	,
  	USE_YN              	BOOLEAN         	NULL    	,
  	SEQ                 	INT             	NULL    	,
  	constraint pk_grwboard primary key(BOARD_ID)
);
COMMENT ON TABLE GRWBOARD IS '게시판';


CREATE TABLE GRWPOST (
	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	POST_ID          		BIGINT             	NOT NULL    ,
  	POST_P_ID        		BIGINT             	NULL    	,
  	BOARD_ID            	BIGINT             	NOT NULL	,
  	USER_ID             	VARCHAR(500)    	NOT NULL	,
  	TITLE               	VARCHAR(500)		NULL    	,
  	CONTENTS            	TEXT			    NULL    	,  	
  	PWD                 	VARCHAR(500)		NULL    	,
  	DEPTH_LEVEL          	INT             	NULL    	,
  	HIT_CNT             	INT             	NULL    	,  	
  	TOP_FIXED_YN        	BOOLEAN         	NULL    	,  	
  	constraint pk_grwpost primary key(POST_ID),  
  	constraint fk_grwpost1 	foreign key(BOARD_ID) references GRWBOARD(BOARD_ID)
);
COMMENT ON TABLE GRWPOST IS '게시글';

CREATE TABLE GRWPOSTFILE (
	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	POST_FILE_ID     		BIGINT             	NOT NULL  	,
  	POST_ID          		BIGINT             	NOT NULL	,  
  	FILE_ID             	BIGINT		      	NULL		,
  	FILE_PATH				VARCHAR(500)		NULL		,
  	UUID					VARCHAR(500)		NULL		,
  	FILE_NM					VARCHAR(500)		NULL		,
  	FILE_SIZE				BIGINT				NULL		,
  	CONTENT_TYPE			VARCHAR(500)		NULL		,	  
  	constraint pk_grwpostfile primary key(POST_FILE_ID),  
  	constraint fk_grwpostfile1 foreign key(POST_ID) references GRWPOST(POST_ID)
);
COMMENT ON TABLE GRWPOSTFILE IS '게시글첨부파일';


CREATE TABLE GRWPOSTCHECK (
	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,  
  	POST_ID  	        	BIGINT             	NOT NULL	,
  	USER_ID             	VARCHAR(50)     	NOT NULL	,
  	HIT_CNT             	INT             	NULL		,  
  	constraint pk_grwarticlecheck primary key(POST_ID, USER_ID),
  	constraint fk_grwarticlecheck1 foreign key(POST_ID) references GRWPOST(POST_ID)
);
COMMENT ON TABLE GRWPOSTCHECK IS '게시글사용자조회수';


CREATE TABLE GRWWORKCALENDAR(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	ID                  	BIGINT             	NOT NULL    ,
  	CALENDAR_NAME       	VARCHAR(500)    	NOT NULL	,
  	COLOR               	VARCHAR(10)     	NULL    	,
  	constraint pk_grwworkcalendar primary key(ID)
);
COMMENT ON TABLE GRWWORKCALENDAR IS 'WORKCALENDAR';


CREATE TABLE GRWWORKCALENDAREVENT(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	ID                  	BIGINT             	NOT NULL    ,
  	FK_WORKCALENDAR     	BIGINT             	NOT NULL	,
  	TITLE               	VARCHAR(500)    	NOT NULL	,
  	START_DT            	DATETIME        	NULL    	,
  	END_DT              	DATETIME        	NULL    	,
  	ALLDAY              	BOOLEAN         	NULL    	,
  	constraint pk_grwworkcalendarevent primary key(ID),
  	constraint fk_grwworkcalendarevent1 foreign key(FK_WORKCALENDAR) references GRWWORKCALENDAR(ID)
);
COMMENT ON TABLE GRWWORKCALENDAREVENT IS 'GRWWORKCALENDAREVENT';

CREATE TABLE GRWWORKCALENDARUSER(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	ID                  	BIGINT             	NOT NULL    ,  
  	USER_ID             	VARCHAR(500)    	NOT NULL	,
  	constraint pk_grwworkcalendaruser primary key(ID, USER_ID),
  	constraint fk_grwworkcalendaruser1 foreign key(ID) references GRWWORKCALENDAR(ID)
);
COMMENT ON TABLE GRWWORKCALENDARUSER IS 'GRWWORKCALENDARUSER';

CREATE TABLE GRWTODOGROUP(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	ID                  	BIGINT             	NOT NULL    ,
  	TODO_GROUP_NAME     	VARCHAR(500)    	NOT NULL	,
  	USER_ID             	VARCHAR(500)    	NOT NULL	,    
  	constraint pk_grwtodogroup primary key(ID)
);
COMMENT ON TABLE GRWTODOGROUP IS 'TODO그룹';


CREATE TABLE GRWTODO(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	ID                  	BIGINT             	NOT NULL    ,
  	TODO_GROUP_ID       	BIGINT             	NOT NULL	,
  	TODO                	VARCHAR(500)    	NOT NULL	,
  	COMPLETE_YN         	BOOLEAN         	NULL    	,
  	DUE_DT              	DATETIME        	NULL    	,
  	COMMENTS            	VARCHAR(500)    	NULL    	,
  	constraint pk_grwtodo primary key(ID),
  	constraint fk_grwtodo1 foreign key(TODO_GROUP_ID) references GRWTODOGROUP(ID)
);
COMMENT ON TABLE GRWTODO IS 'TODO';

CREATE TABLE GRWTEAM(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	TEAM_ID             	BIGINT             	NOT NULL    ,  
  	TEAM_NAME           	VARCHAR(500)    	NOT NULL	,  
  	constraint pk_grwteam primary key(TEAM_ID)
);
COMMENT ON TABLE GRWTEAM IS 'TEAM';

CREATE TABLE GRWTEAMUSER(
  	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	TEAM_ID             	BIGINT             	NOT NULL	,  
  	USER_ID             	VARCHAR(500)    	NOT NULL	, 
  	AUTHORITY           	VARCHAR(500)    	NULL    	, 
  	constraint pk_grwteamuser primary key(TEAM_ID, USER_ID),
  	constraint fk_grwteamuser1 foreign key(TEAM_ID) references GRWTEAM(TEAM_ID)
);
COMMENT ON TABLE GRWTEAMUSER IS 'TEAMUSER';
