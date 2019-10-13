import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt

def graph_results(file_name, title, x_axis, y_axis, out_file):
    y_values = []
    curr_file = open(file_name, "r")
    for line in curr_file:
        latency = float(line.split()[-1])
        y_values.append(latency)
    x_values = [i for i in range(1, 51)]
    figure = plt.figure()
    plt.plot(x_values, y_values)
    plt.title(title)
    plt.xlabel(x_axis)
    plt.ylabel(y_axis)
    plt.savefig(out_file)

graph_results("logs/CausalSimpleResults.txt", "Running Causal Consistency Simple", "Run Number", "Latency", "graphs/CausalSimple.png")
graph_results("logs/SimpleGlitchSimpleResults.txt", "Running Simple Glitch Simple", "Run Number", "Latency", "graphs/SimpleGlitchSimple.png")
graph_results("logs/FIFOSimpleResults.txt", "Running FIFO Simple", "Run Number", "Latency", "graphs/FIFOSimple.png")
graph_results("logs/NoConsistencySimpleResults.txt", "Running No Consistency Simple", "Run Number", "Latency", "graphs/NoLayersSimple.png")