import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import math

def graph_results(file_name, title, x_axis, y_axis, out_file, header):
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
    print(header)
    avg = sum(y_values) / len (y_values)
    total = 0
    for i in range(0, len(y_values)):
        total += (y_values[i] - avg) ** 2
    total = total / len(y_values)
    total = math.sqrt(total)
    print(avg)
    print(total)

graph_results("logs/temp", "10x10 FIFO Chat", "Run Number", "Latency", "graphs/10x10FIFOChat.png", "10x10 FIFO Chat")