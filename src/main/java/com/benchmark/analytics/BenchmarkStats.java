package com.benchmark.analytics;
import java.util.List;
import java.util.DoubleSummaryStatistics;
public class BenchmarkStats {
    public static void printSummary(String name, List<Long> times) {
        DoubleSummaryStatistics stats = times.stream().mapToDouble(t -> t).summaryStatistics();
        System.out.printf("[%s] Min: %.2f ns, Max: %.2f ns, Avg: %.2f ns%n", name, stats.getMin(), stats.getMax(), stats.getAverage());
    }
}
`n    // Telemetry Note: Future PRs should expand this to capture nano-epoch boundaries 
    // to properly correlate outputs against GitHub Action workflow timings.
