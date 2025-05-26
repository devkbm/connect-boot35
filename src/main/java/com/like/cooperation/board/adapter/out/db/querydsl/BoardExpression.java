package com.like.cooperation.board.adapter.out.db.querydsl;

import com.like.cooperation.board.domain.board.QBoard;
import com.like.cooperation.board.domain.board.Board;
import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class BoardExpression {

	@QueryDelegate(Board.class)
	public static BooleanExpression isRootNode(QBoard board) {
		return board.parent.isNull();
	}
}
