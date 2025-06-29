package com.like.cooperation.board.application.port.out.post;

import com.like.cooperation.board.application.port.in.post.select.PostSelectDTO;

public interface PostSelectDbPort {

	PostSelectDTO get(String readerUserId, Long articleId);
}
