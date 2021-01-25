package dascode.data_structures.priority_queue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriorityQueueDoubleTest {
    @Test
    public void testPriorityQueueDoubleAcendingOrder() {
        final PriorityQueueDouble pq = new PriorityQueueDouble() {
            @Override
            public double compare(double a, double b) {
                return b - a; // positive means a ranks higher than b (or a is smaller than b in the context)
            }
        };
        pq.push(4.1);
        pq.push(3.3);
        pq.push(-2.4);
        pq.push(0.5);

        assertEquals("size should be 4", 4, pq.size());
        assertEquals("element should be -2.4", -2.4, pq.pop(), 0.0001);
        assertEquals("element should be 0.5", 0.5, pq.pop(), 0.0001);
        assertEquals("element should be 3.3", 3.3, pq.peek(), 0.0001);
        assertEquals("element should be 3.3", 3.3, pq.pop(), 0.0001);
        
        pq.push(1.3);
        assertEquals("element should be 1.3", 1.3, pq.pop(), 0.0001);
        assertEquals("element should be 4.1", 4.1, pq.pop(), 0.0001);
        assertTrue("pq should be empty", pq.isEmpty());
        assertEquals("element should be Double.MIN_VALUE", Double.MIN_VALUE, pq.pop(), 0.0001);

        pq.push(-2.0);
        pq.push(1.95);
        pq.push(1.93);
        pq.push(4);
        assertEquals("element should be -2.0", -2.0, pq.pop(), 0.0001);
        assertEquals("element should be 1.93", 1.93, pq.peek(), 0.0001);
    }
}
