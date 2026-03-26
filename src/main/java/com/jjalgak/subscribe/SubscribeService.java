package com.jjalgak.subscribe;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface SubscribeService {
	public SseEmitter subscribe(String nickname);
	public void sendToClient(String eventName, Object data);
}
