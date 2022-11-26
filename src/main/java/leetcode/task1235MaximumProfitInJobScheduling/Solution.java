package leetcode.task1235MaximumProfitInJobScheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
 * obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays,
 * return the maximum profit you can take such
 * that there are no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */
public class Solution {

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    List<int[]> allJobs = new ArrayList<>(startTime.length);

    for (int i = 0; i < startTime.length; i++) {
      allJobs.add(new int[]{startTime[i], endTime[i], profit[i]});
    }

    allJobs.sort(Comparator.comparingInt(arr -> arr[1]));

    int[] result = new int[allJobs.size()];
    result[0] = allJobs.get(0)[2];

    for (int i = 1; i < allJobs.size(); i++) {
      result[i] = Math.max(result[i - 1], allJobs.get(i)[2]);
      
      for (int j = i - 1; j >= 0; j--) {
        if (allJobs.get(j)[1] <= allJobs.get(i)[0]) {
          result[i] = Math.max(result[i], allJobs.get(i)[2] + result[j]);
          break;
        }
      }
    }
    return result[allJobs.size() - 1];
  }
}

//  private Stack<int[]> count(List<int[]> allJobs) {
//    int[] job;
//    List<int[]> tmp = new ArrayList<>();
//    Stack<int[]> tmpStack;
//    Stack<int[]> schedule = new Stack<>();
//    schedule.add(allJobs.get(0));
//
//    for (int i = 1; i < allJobs.size(); i++) {
//      job = allJobs.get(i);
//      if (schedule.peek()[1] < job[0]) { // check if job is after last in schedule
//        schedule.push(job);
//        tmp.clear();
//      } else {
//        if (job[1] >= schedule.peek()[1]) {  // check end time
//          if (job[2] > schedule.peek()[2]) { // replace if end time is after and profit is more
//            tmp.add(schedule.pop());
//            schedule.push(job);
//          } else {                // else take back last
//            tmp.add(job);
//          }
//        } else { // now job is inside of last
//          if (job[2] > schedule.peek()[2]) { // replace if inside and profit is more
//            tmp.add(job);
//            tmpStack = count(tmp);
//            schedule.addAll(tmpStack);
//            tmp.clear();
//          } else {
//            tmp.add(job);
//          }
//        }
//      }
//    }
//    return schedule;
//  }
