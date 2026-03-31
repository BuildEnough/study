scores = [120, 150, 180, 200, 170]

max_score = 0
for score in scores:
    if(max_score < score):
        max_score = score
print(max_score)
print(max(scores))