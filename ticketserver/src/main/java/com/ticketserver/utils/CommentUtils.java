package com.ticketserver.utils;

import com.ticketserver.dto.CommentDto;
import com.ticketserver.model.Comment;

public class CommentUtils {
	public static CommentDto generateCommentDto(Comment comment) {
		CommentDto dto = new CommentDto();
		dto.setAuthor(comment.getAuthor());
		dto.setComment(comment.getComment());
		dto.setDate(comment.getDate().toString());
		dto.setTicketId(comment.getTicket().getId().intValue());
		return dto;
	}
}
