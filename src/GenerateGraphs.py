import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import math
import numpy as np

def graph_results(file_name, title, x_axis, y_axis, out_file, header):
    y_values = []
    curr_file = open(file_name, "r")
    for line in curr_file:
        latency = float(line.split()[-1])
        y_values.append(latency)
    """
    x_values = [i for i in range(1, 4)]
    figure = plt.figure()
    plt.plot(x_values, y_values)
    plt.title(title)
    plt.xlabel(x_axis)
    plt.ylabel(y_axis)
    plt.savefig(out_file)
    print(header)
    """
    avg = sum(y_values) / len (y_values)
    total = 0
    for i in range(0, len(y_values)):
        total += (y_values[i] - avg) ** 2
    total = total / len(y_values)
    total = math.sqrt(total)
    total = total / math.sqrt(2)
    print(avg)
    print(total)

def plot_final(title, x_axis, y_axis, x_values, no_values, fifo_values, causal_values, single_values, out_file):
    figure = plt.figure()
    plt.title(title)
    plt.xlabel(x_axis)
    plt.ylabel(y_axis)
    plt.plot(x_values, no_values, label = 'No Consistency')
    plt.plot(x_values, fifo_values, label = 'FIFO')
    plt.plot(x_values, causal_values, label = 'Causal')
    plt.plot(x_values, single_values, label = 'Single Glitch')
    plt.xticks(x_values)
    y_values = [270000, 710000, 1450000, 2300000]
    plt.yticks(y_values)
    plt.legend()
    plt.savefig(out_file)

plot_final("Latency with Increase of Sleep with 100 Users and 100 Messages", "Sleep Latency (milliseconds)", "Latency (milliseconds)", [20, 50, 100, 150], 
[258432, 692545, 1392748, 2250319], [266127, 711843, 1451039, 2242616], [275363, 712911, 1476710, 2304856], [306301, 736010, 1511362, 2358980], 
"graphs/Latency100x100.png")
#graph_results("logs/temp", "100x10 Causal", "Run Number", "Latency", "graphs/100x10Causal.png", "100x10 Causal")