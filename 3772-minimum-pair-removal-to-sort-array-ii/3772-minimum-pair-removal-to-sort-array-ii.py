class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:

        cum = [0]
        for num in nums:
            cum.append(cum[-1] + num)
        n, i0, moves = len(nums), 1, 0
        left = {i: i-1 for i in range(1, n+1)}
        right = {i: i+1 for i in range(n)}
        h = [(nums[i]+nums[i+1], i, i+1, i+2) for i in range(n-1)]
        heapq.heapify(h)

        while True:
            while i0 < n and cum[i0] - cum[left[i0]] <= cum[right[i0]] - cum[i0]:
                i0 = right[i0]
            if i0 == n:
                return moves
            moves += 1

            while right.get(h[0][1]) != h[0][2] or right.get(h[0][2]) != h[0][3]: # Lazy update of heap.
                heapq.heappop(h)
            
            _, i, j, k = heapq.heappop(h)
            right[i], left[k] = k, i
            del left[j]
            del right[j]
            if i > 0:
                heapq.heappush(h, (cum[k]-cum[left[i]], left[i], i, k))
            if k < n:
                heapq.heappush(h, (cum[right[k]]-cum[i], i, k, right[k]))

            if i0 == j:
                i0 = i if i > 0 else k
            elif i0 >= k:
                if i > 0 and cum[i] - cum[left[i]] > cum[k] - cum[i]:
                    i0 = i
                elif cum[k] - cum[i] > cum[right[k]] - cum[k]:
                    i0 = k