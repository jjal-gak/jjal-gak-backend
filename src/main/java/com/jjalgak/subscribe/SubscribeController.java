package com.jjalgak.subscribe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value = "/event/comments")
	public SseEmitter subscribe(@RequestParam String nickname) {
		return ss.subscribe(nickname);
	}

}
