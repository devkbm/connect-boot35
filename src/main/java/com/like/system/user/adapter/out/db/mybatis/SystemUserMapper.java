package com.like.system.user.adapter.out.db.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO2;

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
		     , B.DEPT_CD													deptCode
		     , B.DEPT_CD													deptName
		     , A.MOBILE_NUM													mobileNum
		     , A.EMAIL														email
		     , A.FK_FILE													imageBase64
		     , LISTAGG(C.ROLE_CD, ',') WITHIN GROUP (ORDER BY C.ROLE_CD) 	roleList		     
		  FROM COMUSER A
		    JOIN COMUSERCOMPANY B
			  ON (
			      A.USER_ID = B.USER_ID
			  AND B.ORG_CD = #{companyCode} 
			     )
			JOIN COMUSERROLE C
			  ON (
			      B.USER_ID = C.USER_ID
			  AND B.ORG_CD = C.ORG_CD 
			     )
	     WHERE A.USER_ID = #{userId}
         GROUP 
            BY A.USER_ID
             , A.USER_NAME
		     , B.DEPT_CD
		     , B.DEPT_CD
		     , A.MOBILE_NUM	
		     , A.EMAIL
		     , A.FK_FILE
		]]>				 
	</script>
	""")	
	List<SystemUserQueryResultDTO2> selectList2(SystemUserQueryDTO dto);
	
	
}
