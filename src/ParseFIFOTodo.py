# this program is used to parse no consistency layers
# there are three tasks in this program: check for latency, check if ordering is maintained, and check the overall runtime

import re

# this function is used to check if ordering is maintained or not for a file
def check_ordering(file_name):
    users_map = dict()
    curr_file = open(file_name, "r")
    for line in curr_file:
        if "[Speaker Remote]" in line:
            current_number = line[70:120]
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
def conclude_if_ordered():
    one = check_ordering("taskLogs/user1FIFOSimple.txt")
    two = check_ordering("taskLogs/user2FIFOSimple.txt")
    three = check_ordering("taskLogs/user3FIFOSimple.txt")
    four = check_ordering("taskLogs/user4FIFOSimple.txt")
    five = check_ordering("taskLogs/user5FIFOSimple.txt")
    six = check_ordering("taskLogs/user6FIFOSimple.txt")
    seven = check_ordering("taskLogs/user7FIFOSimple.txt")
    eight = check_ordering("taskLogs/user8FIFOSimple.txt")
    nine = check_ordering("taskLogs/user9FIFOSimple.txt")
    ten = check_ordering("taskLogs/user10FIFOSimple.txt")
    return one and two and three and four and five and six and seven and eight and nine and ten

# this function pulls out the overall runtime - works
def get_overall_runtime():
    open_file = open("taskLogs/simpleFIFOTodo.txt", "r")
    for line in open_file:
        if "Time taken to run this in milliseconds" in line:
            temp = re.findall(r'\d+', line) 
            res = list(map(int, temp))
            return res[0]

# this function returns the maximum time it takes for a message to be received by another user for a given file
def get_max_file_latency():
    file_name_list = ["taskLogs/user1FIFOSimple.txt", "taskLogs/user2FIFOSimple.txt", "taskLogs/user3FIFOSimple.txt", 
    "taskLogs/user4FIFOSimple.txt", "taskLogs/user5FIFOSimple.txt", "taskLogs/user6FIFOSimple.txt", 
    "taskLogs/user7FIFOSimple.txt", "taskLogs/user8FIFOSimple.txt", "taskLogs/user9FIFOSimple.txt", 
    "taskLogs/user10FIFOSimple.txt"]
    file_times = dict()
    starting_time = 0
    for file_name in file_name_list:
        curr_file = open(file_name, "r")
        for line in curr_file:
            if "[Speaker Local]" in line:
                current_number = line[70:120]
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
                current_number = line[70:120]
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
is_ordered = "No"
if conclude_if_ordered():
    is_ordered = "Yes"
overall_runtime = get_overall_runtime()
overall_latency = get_max_file_latency()
print("Is this ordered: " + str(is_ordered) + "; overall runtime: " + str(overall_runtime) + "; overall latency: " + str(overall_latency))