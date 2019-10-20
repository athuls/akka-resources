# this program is used to parse no consistency layers
# there are four tasks in this program: check for latency, check if ordering is maintained, check the overall runtime, and make sure questions are always first

import re

# this function is used to check question ordering in a file
def check_question_ordering(file_name):
    curr_file = open(file_name, "r")
    question_count = 0
    question_list = []
    for line in curr_file:
        if len(line) > 4 and line[0:4] == "Task":
            question_count += 1
            question_list.append(line)
            if question_count == 3:
                break
    for item in question_list:
        if "Initial" not in item:
            return False
    return True

# makes sure questions are ordered in all files
def check_all_questions_ordered():
    one = check_question_ordering("taskLogs/user2SimpleGlitchSimple.txt")
    two = check_question_ordering("taskLogs/user3SimpleGlitchSimple.txt")
    three = check_question_ordering("taskLogs/user4SimpleGlitchSimple.txt")
    four = check_question_ordering("taskLogs/user5SimpleGlitchSimple.txt")
    return one and two and three and four

# this function is used to check if ordering is maintained or not for a file
def check_ordering(file_name):
    users_map = dict()
    curr_file = open(file_name, "r")
    parse_flag = False
    for line in curr_file:
        if parse_flag == False and "Overall Timestamp" not in line:
            continue
        elif parse_flag == False and "Overall Timestamp" in line:
            parse_flag = True
            continue
        else:
            temp = re.findall(r'\d+', line) 
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
    one = check_ordering("taskLogs/user1SimpleGlitchSimple.txt")
    two = check_ordering("taskLogs/user2SimpleGlitchSimple.txt")
    three = check_ordering("taskLogs/user3SimpleGlitchSimple.txt")
    four = check_ordering("taskLogs/user4SimpleGlitchSimple.txt")
    five = check_ordering("taskLogs/user5SimpleGlitchSimple.txt")
    return one and two and three and four and five

# this function pulls out the overall runtime - works
def get_overall_runtime():
    open_file = open("logs/simpleGlitchSimple.txt", "r")
    for line in open_file:
        if "Time taken to run this in milliseconds" in line:
            temp = re.findall(r'\d+', line) 
            res = list(map(int, temp))
            return res[0]

# this function returns the maximum time it takes for a message to be received by another user for a given file
def get_overall_latency():
    starting_time = 0
    curr_file = open("taskLogs/user1SimpleGlitchSimple.txt", "r")
    for line in curr_file:
        if "[Speaker Local]" in line:
            current_number = line[70:120]
            temp = re.findall(r'\d+', current_number) 
            res = list(map(int, temp))
            timestamp = line.split()[-1]
            number_one = int(timestamp[6:8])
            second = timestamp[9:]
            number_two = 0
            if len(second) == 1:
                number_two = int(second) * 100
            elif len(second) == 2:
                number_two = int(second) * 10
            else:
                number_two = int(second)
            starting_time = number_one * 1000 + number_two
            break
    curr_file.close()
    file_name_list = ["taskLogs/user1SimpleGlitchSimple.txt", "taskLogs/user2SimpleGlitchSimple.txt", "taskLogs/user3SimpleGlitchSimple.txt", 
    "taskLogs/user4SimpleGlitchSimple.txt", "taskLogs/user5SimpleGlitchSimple.txt"]
    total_latency = 0
    for file in file_name_list:
        parse_file = open(file, "r")
        for line in parse_file:
            if "Overall Timestamp" in line:
                timestamp = line.split()[-1]
                number_one = int(timestamp[6:8])
                second = timestamp[9:]
                number_two = 0
                if len(second) == 1:
                    number_two = int(second) * 100
                elif len(second) == 2:
                    number_two = int(second) * 10
                else:
                    number_two = int(second)
                total_val = number_one * 1000 + number_two
                current = total_val - starting_time
                total_latency += current
    avg_latency = float(total_latency) / 5.0
    return avg_latency

# code to test functionality
is_ordered = "No"
if conclude_if_ordered():
    is_ordered = "Yes"
is_question_ordered = "No"
if check_all_questions_ordered():
    is_question_ordered = "Yes"
overall_runtime = get_overall_runtime()
overall_latency = get_overall_latency()
print("Are the questions first: " + str(is_question_ordered) + "; Is this FIFO ordered: " + str(is_ordered) + "; overall runtime: " + str(overall_runtime) + "; overall latency: " + str(overall_latency))