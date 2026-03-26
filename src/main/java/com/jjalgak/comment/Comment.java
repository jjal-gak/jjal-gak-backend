package com.jjalgak.comment;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Table(name = "COMMENT")
@DynamicInsert
public class Comment {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "memo_id")
	private String memoId;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "like_count") 
	private int likeCount;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
