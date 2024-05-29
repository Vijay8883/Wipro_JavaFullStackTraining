package com.computationalalgorithms;
import java.util.Arrays;

class Job {
    char id;     // Job Id
    int deadline; // Deadline of job
    int profit;  // Profit if job is completed before or on deadline
    
    // Constructor
    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
 
public class JobSequencing {
 
    // Function to schedule the jobs to maximize profit
    public static void scheduleJobs(Job[] jobs, int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        // To keep track of free time slots
        boolean[] result = new boolean[n];
        
        // To store the sequence of jobs
        char[] jobOrder = new char[n];
        
        // Initialize all slots to be free
        for (int i = 0; i < n; i++) {
            result[i] = false;
        }
        
        // Iterate through all given jobs
        for (int i = 0; i < jobs.length; i++) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                // Free slot found
                if (result[j] == false) {
                    result[j] = true;
                    jobOrder[j] = jobs[i].id;
                    break;
                }
            }
        }
        
        // Print the job order to maximize profit
        System.out.println("Job sequence to maximize profit:");
        for (int i = 0; i < n; i++) {
            if (result[i]) {
                System.out.print(jobOrder[i] + " ");
            }
        }
        System.out.println();
    }
 
    // Driver code
    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };
        int n = 3;  // Number of time slots
        scheduleJobs(jobs, n);
    }
}
