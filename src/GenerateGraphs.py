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
    x_values = [i for i in range(1, 4)]
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
    #y_vals = [20000, 40000, 270000, 470000]
    #plt.yticks(y_vals)
    plt.legend()
    plt.savefig(out_file)

plot_final("10 Machine: Error with Increase in Number of Messages", "Number of Messages", "Standard Deviation", ["10", "100"], [29, 8287], 
[436, 1478], [1495, 13818], [1683, 2489], 
"graphs/10MachineMessageError.png")
#graph_results("logs/temp", "100x10 Causal", "Run Number", "Latency", "graphs/100x10Causal.png", "100x10 Causal")