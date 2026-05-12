# Proposed Issue

**Title:** Add support for CSV export in benchmarking results 

**Description:**
Currently, our `TimingEngine` logs results directly to `System.out`. To better analyze benchmark data and support data-science workflows (like pandas dataframe ingestion), we should add a `CsvExportHandler`.

**Acceptance Criteria:**
- Create `CsvExportHandler` class.
- Support serializing benchmark context (Algorithm Name, N, Elapsed Time).
- Add basic unit tests for the exporter.

---

# Realistic PR Review Comment Template

```markdown
Great work on this implementation! A couple of small suggestions for robustness:

1. **Memory Handling:** In `TimingEngine`, consider invoking `System.gc()` before running the benchmark loop if we want to minimize GC jitter during timing. 
2. **Concurrency Setup:** ensure `executor.shutdown()` is wrapped in a `finally` block or handled via an appropriate lifecycle manager so we don't leak threads on exception.

Let me know if you want to pair on these! Otherwise, I'm happy to approve once addressed.
```