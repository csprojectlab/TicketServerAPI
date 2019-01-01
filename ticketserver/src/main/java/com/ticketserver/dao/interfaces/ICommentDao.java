package com.ticketserver.dao.interfaces;

import com.ticketserver.dto.CommentDto;

public interface ICommentDao {
	CommentDto addComment(CommentDto comment);

}
