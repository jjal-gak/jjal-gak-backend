package com.jjalgak.comment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
	
	private final CommentService cs;
	
	/**
	 * 댓글 등록
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/comments", method = RequestMethod.POST)
	public ResponseEntity<?> addComments(@RequestBody CommentDto commentDto ){
		return ResponseEntity.ok(true);
	}

	/**
	 * 댓글 목록
	 * 
	 * @return
	 */
	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	public ResponseEntity<?> getComments(){
		return ResponseEntity.ok(true);
	}
}
