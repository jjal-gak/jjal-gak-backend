package com.jjalgak.comment;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
		private int id;
		private String memoId;
		private String nickname;
		private String content;
		private int likeCount; /* */
		private LocalDateTime createdAt; /* */
}
