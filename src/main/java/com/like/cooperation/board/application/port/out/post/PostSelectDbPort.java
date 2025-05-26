package com.like.cooperation.board.application.port.out.post;

import com.like.cooperation.board.application.dto.post.PostFormSelectDTO;

public interface PostSelectDbPort {

	PostFormSelectDTO get(String readerUserId, Long articleId);
}
