# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        if not root: return False
        q.append(root)
        xFlag = False
        yFlag = False
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.right is not None and curr.left is not None:
                    if curr.right.val == x and curr.left.val == y: return False
                    if curr.right.val == y and curr.left.val == x: return False
                if curr.val == x: xFlag = True
                if curr.val == y: yFlag = True
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            if xFlag and yFlag: return True
            if xFlag or yFlag: return False
        return False








        
