class Solution:
   def twoSum(self,list,target):
        dic = {list[0] : 0}
        res = []
        for i in range(1, len(list)):
            x = target - list[i]
            if x in dic:
                res.append(dic.get(x))
                res.append(i)
                break
            else:
                dic[list[i]] = i
        return res