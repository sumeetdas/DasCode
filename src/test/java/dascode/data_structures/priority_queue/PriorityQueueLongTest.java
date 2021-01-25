package dascode.data_structures.priority_queue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriorityQueueLongTest {
    @Test
    public void testPriorityQueueLongAcendingOrder() {
        final PriorityQueueLong pq = new PriorityQueueLong() {
            @Override
            public long compare(long a, long b) {
                return b - a; // positive means a ranks higher than b (or a is smaller than b in the context)
            }
        };
        pq.push(4);
        pq.push(3);
        pq.push(-2);
        pq.push(0);

        assertEquals("size should be 4", 4, pq.size());
        assertEquals("element should be -2", -2, pq.pop());
        assertEquals("element should be 0", 0, pq.pop());
        assertEquals("element should be 3", 3, pq.peek());
        assertEquals("element should be 3", 3, pq.pop());
        pq.push(1);
        assertEquals("element should be 1", 1, pq.pop());
        assertEquals("element should be 4", 4, pq.pop());
        assertTrue("pq should be empty", pq.isEmpty());
        assertEquals("element should be Long.MIN_VALUE", Long.MIN_VALUE, pq.pop());

        pq.push(-2);
        pq.push(2);
        pq.push(1);
        pq.push(4);
        assertEquals("element should be -2", -2, pq.pop());
        assertEquals("element should be 1", 1, pq.peek());
    }
}
