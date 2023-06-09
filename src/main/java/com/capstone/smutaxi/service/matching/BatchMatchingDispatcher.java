package com.capstone.smutaxi.service.matching;

import com.capstone.smutaxi.dto.requests.MatchingRequest;

public class BatchMatchingDispatcher implements MatchingDispatcher {
    /**
     * Batch Style Dispatcher
     * @Scheduled 주기 마다 matchingRequest들 모두 가져와서 4명 모인거 있으면 매칭 한다.
     * 매칭완성 안되면 다시 주기를 기다리고 반복
     * pros : 로직 간단, DB 작업 줄어듦 (한방에 write하니까)
     * cons : Bad한 사용자 경험 (안잡히면 3초 기다리니까 기다리는 시간이 긴 것 처럼 느껴짐)
     */
    @Override
    public Long handleMatchingRequest(String userEmail, MatchingRequest matchingRequest) {

        return 0L;
    }
}
