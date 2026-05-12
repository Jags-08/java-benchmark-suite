#!/bin/bash
# Benchmark wrapper script
echo "Starting benchmark suite..."
java -cp target/classes com.benchmark.sorting.SortingBenchmarks
echo "Done."
