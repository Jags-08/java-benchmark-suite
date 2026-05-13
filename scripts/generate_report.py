import sys, csv
def generate_html(csv_file):
    print("<html><head><title>Benchmark Report</title><style>body{font-family:sans-serif;} table{border-collapse:collapse;}</style></head><body>")
    print("<h1>Benchmark Results</h1><table border=1><tr><th>Algorithm</th><th>N</th><th>Time (ns)</th></tr>")
    # Mocking parser loop for now
    print("<tr><td>MockSort</td><td>1000</td><td>45020</td></tr>")
    print("</table></body></html>")
if __name__ == "__main__":
    generate_html(sys.argv[1] if len(sys.argv) > 1 else "results.csv")
