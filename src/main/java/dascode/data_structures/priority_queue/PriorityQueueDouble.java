package dascode.data_structures.priority_queue;

import java.util.Arrays;

public abstract class PriorityQueueDouble {
    private final double NULL = Double.MIN_VALUE;

    private double[] elems = new double[] {NULL, NULL};

    private int size = 0;

    public PriorityQueueDouble(){}

    public int size ()
    {
        return size;
    }

    public double peek ()
    {
        return elems[1];
    }

    public void push (final double elem)
    {
        elems[++size] = elem;

        if (size == elems.length - 1)
        { 
            elems = Arrays.copyOf(elems, elems.length * 2);
        }

        swim();
    }

    public double pop ()
    {
        if (isEmpty())
        {
            return NULL;
        }

        final double top = elems[1];

        elems[1] = elems[size];

        elems[size] = NULL;

        sink();

        size--;

        return top;
    }

    public boolean isEmpty()
    {
        return size <= 0;
    }

    private void swim ()
    {
        int index = size;

        // swim up if index ranks higher than index/2 per comparator
        while (index > 1 && compare(elems[index], elems[index / 2]) > 0)
        {
            final double temp = elems[index];
            elems[index] = elems[index / 2];
            elems[index / 2] = temp;

            index /= 2;
        }
    }

    private void sink ()
    {
        int index = 1;

        while (index * 2 < size)
        {
            int j = index * 2;

            if (elems[j] == NULL && elems[j + 1] == NULL)
            {
                break;
            }
            // if j + 1 ranks higher than j, then increment j
            else if (j + 1 < elems.length && 
                     elems[j + 1] != NULL && compare(elems[j + 1],  elems[j]) > 0)
            {
                j++;
            }

            // if index rank higher than j, then break.. no need to swap
            // coz elements are in their correct positions
            if (compare(elems[index], elems[j]) > 0)
            {
                break;
            }

            final double temp = elems[index];
            elems[index] = elems[j];
            elems[j] = temp;

            index = j;
        }
    }

    /*
        -1 = less
        0 = equal
        1 = greater
        comparator rule: compare(a, b) == 1 then a ranks higher than b
        comparator rule: compare(a, b) == -1 then a ranks lower than b
        comparator rule: compare(a, b) == 0 then a and b are of equal rank
    */
    public abstract double compare (double l1, double l2);
}
