package twitter4j.management;

import java.util.HashMap;
import java.util.Map;

public class APIStatistics implements APIStatisticsMBean {
    private final InvocationStatisticsCalculator API_STATS_CALCULATOR;
    private final int HISTORY_SIZE;
    private final Map<String, InvocationStatisticsCalculator> METHOD_STATS_MAP = new HashMap(100);

    public APIStatistics(int i) {
        this.API_STATS_CALCULATOR = new InvocationStatisticsCalculator("API", i);
        this.HISTORY_SIZE = i;
    }

    public synchronized void methodCalled(String str, long j, boolean z) {
        getMethodStatistics(str).increment(j, z);
        this.API_STATS_CALCULATOR.increment(j, z);
    }

    private synchronized InvocationStatisticsCalculator getMethodStatistics(String str) {
        InvocationStatisticsCalculator invocationStatisticsCalculator;
        invocationStatisticsCalculator = (InvocationStatisticsCalculator) this.METHOD_STATS_MAP.get(str);
        if (invocationStatisticsCalculator == null) {
            invocationStatisticsCalculator = new InvocationStatisticsCalculator(str, this.HISTORY_SIZE);
            this.METHOD_STATS_MAP.put(str, invocationStatisticsCalculator);
        }
        return invocationStatisticsCalculator;
    }

    public synchronized Iterable<? extends InvocationStatistics> getInvocationStatistics() {
        return this.METHOD_STATS_MAP.values();
    }

    public synchronized void reset() {
        this.API_STATS_CALCULATOR.reset();
        this.METHOD_STATS_MAP.clear();
    }

    public String getName() {
        return this.API_STATS_CALCULATOR.getName();
    }

    public long getCallCount() {
        return this.API_STATS_CALCULATOR.getCallCount();
    }

    public long getErrorCount() {
        return this.API_STATS_CALCULATOR.getErrorCount();
    }

    public long getTotalTime() {
        return this.API_STATS_CALCULATOR.getTotalTime();
    }

    public long getAverageTime() {
        return this.API_STATS_CALCULATOR.getAverageTime();
    }

    public synchronized Map<String, String> getMethodLevelSummariesAsString() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (InvocationStatisticsCalculator invocationStatisticsCalculator : this.METHOD_STATS_MAP.values()) {
            hashMap.put(invocationStatisticsCalculator.getName(), invocationStatisticsCalculator.toString());
        }
        return hashMap;
    }

    public synchronized String getMethodLevelSummary(String str) {
        return ((InvocationStatisticsCalculator) this.METHOD_STATS_MAP.get(str)).toString();
    }
}
