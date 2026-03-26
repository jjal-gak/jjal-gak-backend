package com.jjalgak.subscribe;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SubscribeController {
	private final SubscribeService ss;
	
	/** 실시간 구독 
	 * 
	 * 
	 */
	
	@GetMapping(value = "/event/comments", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter subscribe(@RequestParam String nickname) {
		return ss.subscribe(nickname);
	}

}
