package threading;

import trees.execute.InOrderUsingStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by mmandam on 12/20/16.
 */
public class HitCounter {

    int startTime = (int) System.currentTimeMillis() / 1000;
    int endTime = startTime + 300;
    List<Integer> hitsCount = new ArrayList(30);

    public static void main (String args[]) {
        HitCounter hitCounter = new HitCounter();
        for(int i =0; i<10; i++) {
            hitCounter.hit();
        }
        System.out.println("Total Hits " + hitCounter.total_hits());

    }

    public void hit() {
        int currentTime = (int) System.currentTimeMillis() / 1000;

        //if in range
        if (currentTime >= startTime && currentTime <= endTime) {
            int index = currentTime - startTime;
            Integer hit = hitsCount.get(currentTime - startTime);
            hit++;
        }

        //If intersection
        else if (currentTime > endTime && (currentTime - 300 < endTime)) {

            //Copy the intersection into new Array

            int newStartTime = currentTime - 300;
            int newEndTime = newStartTime + 300;

            int difference = newStartTime - endTime;
            List<Integer> backUp = hitsCount.subList(newStartTime, endTime);
            hitsCount.clear();
            //Fill the new Array
            for (Integer hit : backUp) {
                hitsCount.add(hit);
            }

            Integer hit = hitsCount.get(newStartTime - newEndTime);
            hit++;
            startTime = newStartTime;
            endTime = newEndTime;

        } else {
            hitsCount.clear();
            startTime = currentTime;
            endTime = startTime + 300;
            Integer hit = hitsCount.get(currentTime - startTime);
            hit++;
        }
    }

    public int total_hits() {
        return hitsCount.stream().reduce((a, b) -> a + b).get();
    }

}
