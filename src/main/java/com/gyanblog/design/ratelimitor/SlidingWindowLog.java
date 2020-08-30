//package com.gyanblog.design.ratelimitor;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * By counting last number of requests
// *
// */
//public class SlidingWindowLog {
//
//	public static class Request {
//		private LinkedList<Date> queue;
//		private int windowTimeInSec;
//		
//		public Request(int windowTimeInSec) {
//			this.windowTimeInSec = windowTimeInSec;
//			this.queue = new LinkedList<>();
//		}
//		
//		public int getCountRequests() {
//			return this.queue.size();
//		}
//		
//		public void evictOld() {
//			Date current = new Date();
//			current.
//			while (this.queue.size() > 0) {
//				if (this.queue.getFirst().before(current)) {
//					this.queue.removeFirst();
//				}
//			}
//		}
//	}
//	
//	private Map<String, Request> requests;
//	public SlidingWindowLog() {
//		this.requests = new HashMap<String, SlidingWindowLog.Request>();
//	}
//	
//	public void shouldAllow(String userId) {
//		if (!this.requests.containsKey(userId)) {
//			this.requests.put(userId, new Request(60));
//		}
//	}
//}
