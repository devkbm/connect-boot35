package com.like.system.user.adapter.out.db.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO;

@Mapper
public interface SystemUserMapper {

	
	/*           
	<if test="_databaseId == 'oracle'">
	 ORDER
	    BY A.POST_ID DESC
	OFFSET #{pagenumber} * #{pagesize} ROWS 
	FETCH NEXT #{pagesize} + 1 ROWS ONLY      	
	 </if>
	 */
	
	@Select("""
	<script>		
		<![CDATA[
		SELECT A.USER_ID												 	userId
		     , A.USER_NAME												 	name
		     , B.ORG_CD														companyCode
		     , A.USER_ID													staffNo		     
		     , B.DEPT_CD													deptCode
		     , B.DEPT_NM_KOR												deptName
		     , A.MOBILE_NUM													mobileNum
		     , A.EMAIL														email
		     , A.FK_FILE													imageBase64
		     , LISTAGG(C.ROLE_NM, ',') WITHIN GROUP (ORDER BY C.ROLE_CD) 	roleList
		     , LISTAGG(D.MENU_GROUP_NM, ',') WITHIN GROUP (ORDER BY D.SEQ) 	menuGroupList	
		     , true   														enabled		     	    
		  FROM COMUSER A
		    JOIN (SELECT A.ORG_CD 
				       , A.USER_ID
				       , A.DEPT_CD
				       , B.DEPT_NM_KOR
				    FROM COMUSERCOMPANY A
				      JOIN COMDEPT B
				        ON (A.ORG_CD = B.ORG_CD AND A.DEPT_CD = B.DEPT_CD)
		         )  B
			  ON (A.USER_ID = B.USER_ID)
			JOIN (SELECT C.ORG_CD
					   , C1.USER_ID		
			           , C.ROLE_CD
			           , C.ROLE_NM			           
			        FROM COMROLE C
			          JOIN COMUSERROLE C1
			            ON (C.ORG_CD = C1.ORG_CD AND C.ROLE_CD = C1.ROLE_CD)
			     ) C     
			  ON (
			      B.USER_ID = C.USER_ID AND B.ORG_CD = C.ORG_CD 
			     )
		    JOIN (SELECT A.ORG_CD
				       , A.MENU_GROUP_CD
				       , B.MENU_GROUP_NM
				       , A.ROLE_CD
				       , B.SEQ          
				    FROM COMMENUROLE A
				      JOIN COMMENUGROUP B
				        ON (A.ORG_CD = B.ORG_CD AND A.MENU_GROUP_CD = B.MENU_GROUP_CD)
                   GROUP 
                      BY A.ORG_CD
                       , A.MENU_GROUP_CD
                       , B.MENU_GROUP_NM
                       , A.ROLE_CD
                       , B.SEQ				        
				 ) D
		      ON (D.ORG_CD = C.ORG_CD AND D.ROLE_CD = C.ROLE_CD)	     
	     WHERE B.ORG_CD = #{companyCode}
	    ]]>    
	    <if test="userId != null">
	       AND A.USER_ID = #{userId}
	    </if>
	    <if test="name != null">
	       AND A.USER_NAME LIKE '%'||#{name}||'%'
	    </if>
	    <if test="deptCode != null">
	       AND A.DEPT_CD = #{deptCode}
	    </if>
	    <![CDATA[ 
         GROUP 
            BY A.USER_ID             
             , A.USER_NAME
             , B.ORG_CD
		     , B.DEPT_CD
		     , B.DEPT_NM_KOR
		     , A.MOBILE_NUM	
		     , A.EMAIL
		     , A.FK_FILE
		]]>				 
	</script>
	""")	
	List<SystemUserQueryResultDTO> selectList(SystemUserQueryDTO dto);
	
	
}
