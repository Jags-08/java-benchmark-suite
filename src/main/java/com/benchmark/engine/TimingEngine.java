package com.benchmark.engine; public class TimingEngine { public static long measureExecutionTime(Runnable task) { long start = System.nanoTime(); task.run(); return System.nanoTime() - start; } }
