# Last updated: 9/14/2025, 9:11:11 AM
class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack=[]
        top=-1
        for i in s:
            if top==-1:
                top+=1
                stack.append(i)
            elif i!=stack[top]:
                stack.append(i)
                top+=1
            else:
                top-=1
                stack.pop()
        # string=""
        # for i in range(0,top+1):
        #     string+=stack[i]
        # return string
        return ''.join(stack)