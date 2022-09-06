
def solution(n):
    sum = 0
    i = 1
    while n > sum:
        sum += i
        i += 1
    if n >= sum:
        print(i-1)
    else:
        print(i - 2)


n = int(input())
solution(n)
