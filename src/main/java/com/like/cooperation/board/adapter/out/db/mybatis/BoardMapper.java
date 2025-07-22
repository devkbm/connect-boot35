package com.like.cooperation.board.adapter.out.db.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.like.cooperation.board.application.port.in.post.query.PostQueryResultDTO;

@Mapper
public interface BoardMapper {
					
	/**
	 * 게시글 리스트 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */		
	//@Options()
	@Select("""
<script>

SELECT TO_CHAR(A.BOARD_ID)	boardId
     , TO_CHAR(A.POST_ID)	postId     
     , D.USER_ID			writerId
     , D.USER_NAME 			writerName
     , D.FK_FILE			writerImage	         	         	        
     , A.TITLE				title	         
     , NVL(A.HIT_CNT,0)		hitCount	         			 	        
     , CASE WHEN A.USER_ID = #{userId} THEN true
                ELSE false
       END					editable
     , (CASE WHEN B.CNT > 0 THEN true ELSE false END) isAttachedFile
     , B.CNT				fileCount
     , CASE WHEN C.HIT_CNT > 0 THEN true
            ELSE false
       END 					isRead      											          
  FROM GRWPOST A
  	LEFT OUTER JOIN (
     	SELECT X.POST_ID 
     	     , COUNT(*) CNT
          FROM GRWPOSTFILE X                 
         GROUP 
           BY X.POST_ID
	    ) B
    ON (A.POST_ID = B.POST_ID)
    LEFT OUTER JOIN GRWPOSTCHECK  C
    ON (A.POST_ID = C.POST_ID
    AND C.USER_ID = #{userId})
  	LEFT OUTER JOIN COMUSER D
  	ON (A.USER_ID = D.USER_ID) 
 WHERE 1=1		
   AND A.BOARD_ID = #{data.boardId}
       	         
<if test="data.title != null"><![CDATA[
   AND A.TITLE LIKE #{data.title}
]]></if>
<if test="data.contents != null"><![CDATA[
   AND A.CONTENTS LIKE #{data.contents}
]]></if>           
 ORDER
    BY A.POST_ID DESC
<if test="_databaseId == 'oracle'">
OFFSET #{pagenumber} * #{pagesize} ROWS 
FETCH NEXT #{pagesize} + 1 ROWS ONLY      	
</if>
<if test="_databaseId != 'oracle'">
 limit #{pagesize} + 1 offset #{pagenumber} * #{pagesize}      	
</if>	
</script>
	""")		
	List<PostQueryResultDTO> getArticleList(Map<String, Object> params);
			
}
