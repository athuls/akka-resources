# this program is used to parse no consistency layers
# there are four tasks in this program: check for latency, check if ordering is maintained, check the overall runtime, and make sure questions are always first

import re
import sys

# this function is used to check question ordering in a file
def check_question_ordering(file_name):
    curr_file = open(file_name, "r")
    remote_count = 0
    remote_list = []
    for line in curr_file:
        if "[Speaker Remote]" in line:
            remote_count += 1
            remote_list.append(line)
            if remote_count == 3:
                break
    for item in remote_list:
        if "QUESTION" not in item:
            return False
    return True

# makes sure questions are ordered in all files
def check_all_questions_ordered(num_users):
    for i in range(2, num_users + 1):
        curr = "logs/speaker" + str(i) + "CausalSimple.txt"
        ordered = check_question_ordering(curr)
        if ordered == False:
            return False
    return True

# this function is used to check if ordering is maintained or not for a file
def check_ordering(file_name):
    users_map = dict()
    curr_file = open(file_name, "r")
    for line in curr_file:
        if "[Speaker Remote]" in line:
            current_number = line[42:91]
            temp = re.findall(r'\d+', current_number) 
            res = list(map(int, temp))
            key_user = res[0]
            key_value = res[1]
            if key_user not in users_map.keys():
                users_map[key_user] = []
                users_map[key_user].append(key_value)
            else:
                users_map[key_user].append(key_value)
    curr_file.close()
    for key in users_map.keys():
        if users_map[key] != sorted(users_map[key]):
            return False
    return True

# this function checks overall ordering - works
def conclude_if_ordered(num_users):
    for i in range(1, num_users + 1):
        curr = "logs/speaker" + str(i) + "CausalSimple.txt"
        ordered = check_ordering(curr)
        if ordered == False:
            return False
    return True

# this function pulls out the overall runtime - works
def get_overall_runtime():
    open_file = open("logs/simpleCausal.txt", "r")
    for line in open_file:
        if "Time taken to run this in milliseconds" in line:
            temp = re.findall(r'\d+', line) 
            res = list(map(int, temp))
            return res[0]

# this function returns the maximum time it takes for a message to be received by another user for a given file
def get_total_latency(num_users):
    file_name_list = []
    for i in range(num_users):
        curr = "logs/speaker" + str(i + 1) + "CausalSimple.txt"
        file_name_list.append(curr)
    starting_time = 0
    for file in file_name_list:
        curr_file = open(file, "r")
        for line in curr_file:
            if "[Speaker Local]" in line:
                current_number = line[41:90]
                temp = re.findall(r'\d+', current_number) 
                res = list(map(int, temp))
                timestamp = line.split()[-1]
                hour = int(timestamp[0:2])
                minute = int(timestamp[3:5])
                number_one = int(timestamp[6:8])
                second = timestamp[9:]
                number_two = 0
                if len(second) == 1:
                    number_two = int(second) * 100
                elif len(second) == 2:
                    number_two = int(second) * 10
                else:
                    number_two = int(second)
                curr_time = 3600000 * hour + 60000 * minute + number_one * 1000 + number_two
                if starting_time == 0:
                    starting_time = curr_time
                else:
                    if curr_time < starting_time:
                        starting_time = curr_time
                break
        curr_file.close()

    max_latency = 0
    for file in file_name_list:
        parse_file = open(file, "r")
        for line in parse_file:
            if "[Speaker Remote]" in line:
                current_number = line[42:91]
                temp = re.findall(r'\d+', current_number) 
                res = tuple(list(map(int, temp)))
                timestamp = line.split()[-1]
                hour = int(timestamp[0:2])
                minute = int(timestamp[3:5])
                number_one = int(timestamp[6:8])
                second = timestamp[9:]
                number_two = 0
                if len(second) == 1:
                    number_two = int(second) * 100
                elif len(second) == 2:
                    number_two = int(second) * 10
                else:
                    number_two = int(second)
                total_val = 3600000 * hour + 60000 * minute + number_one * 1000 + number_two
                current = total_val - starting_time
                if current > max_latency:
                    max_latency = current
    return max_latency

# code to test functionality
num_users = int(sys.argv[1])
is_ordered = "No"
if conclude_if_ordered(num_users):
    is_ordered = "Yes"
is_question_ordered = "No"
if check_all_questions_ordered(num_users):
    is_question_ordered = "Yes"
overall_runtime = get_overall_runtime()
overall_latency = get_total_latency(num_users)
print("Are the questions first: " + str(is_question_ordered) + "; Is this FIFO ordered: " + str(is_ordered) + "; overall runtime: " + str(overall_runtime) + "; overall latency: " + str(overall_latency))