# Last updated: 9/14/2025, 9:19:07 AM
class Solution:
    
    def isValid(self, s: str) -> bool:
        stack=[]
        map={'}':'{',')':'(',']':'['}
        for i in s:
            if i in map:
                #take the top element if stack is not empty otherwise assign duplicate value
                top_ele=stack.pop() if stack else '#'
                if top_ele!=map[i]:
                    return False
            else:
                stack.append(i)
        #not stack will return stack is empty or not ie true or false
        return not stack

