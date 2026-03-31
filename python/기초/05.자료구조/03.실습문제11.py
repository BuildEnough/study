rooms = [
    [3, 1, 2],
    [2, 0, 1],
    [1, 3, 2]
]

total = 0
for room in rooms:
    for roo in room:
        total += roo
print(total)

total = 0
for room in rooms:
    total += sum(room)
print(total)