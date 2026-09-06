class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        min_heap = []
        for i, l in enumerate(lists):
            if l:
                heapq.heappush(min_heap, (l.val, i))

        dummy = ListNode()
        current = dummy

        while min_heap:
            val, idx = heapq.heappop(min_heap)
            current.next = ListNode(val)
            current = current.next
            if lists[idx].next:
                heapq.heappush(min_heap, (lists[idx].next.val, idx))
                lists[idx] = lists[idx].next

        return dummy.next