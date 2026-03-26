package com.jjalgak.subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl {

	private final Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();
	
	/** 구독 사용자 추가
	 * 
	 * @param nickname
	 * @return SseEmitter
	 */
	public SseEmitter subscribe(String nickname) {
		
		/* 연결 시간 설정 : 30분 */
		long connectTime = 1000L*60*30; 
		
		
		SseEmitter sseEmitter = new SseEmitter(connectTime);
		sseEmitters.put(nickname, sseEmitter);
		
		sseEmitter.onCompletion(() -> {  
//          log.info("sseKey : {}", nickname);  
            sseEmitters.remove(nickname);  
        }); 
		
		sseEmitter.onTimeout(sseEmitter::complete);
		sseEmitter.onError(throwable -> sseEmitter.complete());
		
		return sseEmitter;
	}
	
	/** 모든 구독자 데이터 전송
	 * 
	 * @param eventName [comment, like]
	 * @param data
	 */
	public void sendToClient(String eventName, Object data) {
	    List<String> disconnectedEmitters = new ArrayList<>();

	    sseEmitters.forEach((nickname, emitter) -> {
	        try {
	            emitter.send(SseEmitter.event()
	                    .name(eventName)
	                    .data(data));
	        } catch (IOException e) {
	        	disconnectedEmitters.add(nickname);
	        }
	    });
	    disconnectedEmitters.forEach(sseEmitters::remove);
	}
}
