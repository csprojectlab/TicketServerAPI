package com.ticketserver.dao.interfaces;

import java.util.List;

import com.ticketserver.dto.CommentDto;
import com.ticketserver.model.Comment;

public interface ICommentDao {
	CommentDto addComment(CommentDto comment);
	List<Comment> getComments(long ticketId);
}
