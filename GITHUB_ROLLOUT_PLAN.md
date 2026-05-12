# PR Rollout & Issue Strategy (Activity Pacing)

## 1. Pushing the Ecosystem
Run these commands to push the infrastructure to GitHub (replace `<YOUR-USERNAME>` with your GitHub username):
```bash
# Set up Remote
git remote add origin https://github.com/Jags-08/java-benchmark-suite.git

# Push main and ALL branches
git push -u origin main
git push -u origin feature/benchmark-engine
git push -u origin feature/sorting-benchmarks
git push -u origin feature/concurrency-demo
git push -u origin docs/project-documentation
git push -u origin ci/github-actions
git push -u origin test/unit-testing
```

## 2. PR Staging (What to Merge Today)
**TODAY (Merge 1-2 PRs max):**
1. **PR 1: Core Engine (`feature/benchmark-engine` -> `main`)**
   * *Title:* `feat: implement core timing engine`
   * *Body:* "Introduces `TimingEngine` class to wrap `Runnable` tasks and measure nanosecond-level execution time. This forms the foundation for our upcoming sorting and concurrency suites."
   * *Action:* Open and Squash/Merge today.

2. **PR 2: Documentation (`docs/project-documentation` -> `main`)**
   * *Title:* `docs: add professional readmes, contributing guidelines, and issue templates`
   * *Body:* "Adds standard community health files to ensure professional onboarding and structured issue tracking."
   * *Action:* Open and Squash/Merge today.

**DELAY (Leave Open as Draft/Active PRs for Tomorrow):**
* `feature/sorting-benchmarks`
* `feature/concurrency-demo`
* `ci/github-actions`
* `test/unit-testing`

---

## 3. High-Fidelity Issues to Open Today
Open these issues via GitHub UI to populate your tracker:

**Issue A: Support CSV Export for Benchmark Runs**
* **Title:** Feature: Add CSV Export Support for Benchmark Results
* **Body:** Currently, `TimingEngine` results print to standard out. We need a `CsvExportHandler` that formats context (Algorithm Name, Workload Size N, Elapsed Time NS) and flushes to a `{timestamp}_results.csv` to support Pandas ingestion.

**Issue B: JMH Framework Integration Evaluation**
* **Title:** Research: Evaluate Java Microbenchmark Harness (JMH) integration
* **Body:** Our custom `TimingEngine` handles basic wall-clock elapsed time, but suffers from potential JVM warmup/JIT optimization pollution. We should evaluate integrating `org.openjdk.jmh` for our concurrency stress testing module.

---

## 4. Professional PR Review Snippets
When "reviewing" your own staged PRs before merging, drop these comments:

*Comment on `feature/benchmark-engine` (on the TimingEngine file):*
> "Nice lightweight start. We should eventually add optional JVM warmup loop executions to this method before recording `start` so we don't accidentally benchmark ClassLoader/JIT overhead."

*Comment on `test/unit-testing` (save for tomorrow's merge):*
> "Good baseline validation, but let's ensure we add `Thread.sleep()` mocks in future tests to explicitly verify the delta calculation avoids intermittent CI runner jitter."
