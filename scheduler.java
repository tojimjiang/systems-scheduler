/*
 * Operating Systems Job Scheduler
 *
 * Description: This scheduler takes in command line arguments when calling the program. This scheduler features 4
 * algorithms as specified in the specification. There is a verbose feature. (See README for more details). RandomOS
 * as required in the specification was implemented as a class that contains a scanner for the random_numbers file.
 * This program works with the two REQUIRED invocations of <program> <file> and <program> --verbose <file>.
 *
 * FILE NAME MUST BE THE LAST ARGUMENT IN INVOCATION.
 *
 *
 * Available Schedulers (for more details see spec, and lecture notes)
 * First Come First Served (FCFS), Round Robin (RR), Last Come First Served (LCFS), and Highest Penalty Ratio Next (HPRN)
 *
 * Available Tags (for more details see README)
 * For Detailed Output [EXCLUSIVE] (please see README) (Default behaviour WITHOUT --verbose or --verbosematch is NO detailed output)
 *     --verbose   will show detailed output.
 *
 *     --verbosematch    will show detailed output, that matches the given output files.
 *
 *     **NOTE** An invocation may NOT have both --verbose and --verbosematch. Only one detailed output tag can be used per invocation.
 * For Quality of Life [NOT EXCLUSIVE]
 *     --select   will query user for which algorithms to run.
 *                (Default behavior WITHOUT --select is to run all 4 algorithms)
 *
 *     --wait   will stop the running of the program BEFORE each algorithm. It will WAIT for a user input before starting the algorithm
 *              (Default behavior WITHOUT --wait is to run though the program as quickly as possible, with no waits)
 *
 *     **NOTE** An invocation may have --select and/or --wait. Only one tag will only do the feature detailed above. Both will first query for which algos to run. Then wait will WAIT for user input before starting each algortihm selected to run.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class scheduler {

    public static void main(String[] args) throws IOException {
        String fileName = "";
        boolean verbose = false;
        boolean match = false;
        // Left to right FCFS, RR, LCFS, HPRN
        boolean runAlgos[] = new boolean[] {true,true,true,true};
        String nameAlgos[] = new String[] {"First Come First Served (FCFS)"," Round Robin with Quantum 2 (RR Q=2) ","Last Come First Served (LCFS)","Highest Penalty Ratio Next (HPRN)"};
        boolean runWait = false;

        // 1 Arg (Only File)
        if(args.length == 1) {
            fileName = args[0];
        }

        // 2 Args (Verbose + File) or (Select/Waiting Run + File) or (Invalid Thing + File)
        else if(args.length == 2) {
            // Verbose + File
            String switchStr = args[0];
            switch (switchStr) {
                case "--verbose":
                    verbose = true;
                    fileName = args[1];
                    break;
                case "--verbosematch":
                    verbose = true;
                    match = true;
                    fileName = args[1];
                    break;
                case "--wait":
                    runWait = true;
                    fileName = args[1];
                    break;
                case "--select":
                    fileName = args[1];
                    Scanner selecter = new Scanner(System.in);
                    for (int i = 0; i < 4; i++) {
                        System.out.printf("\nWould you want to run the %s scheduling algorithm? Enter Y or y for YES. Enter any other key for No.", nameAlgos[i]);
                        String readIn = selecter.next();
                        if (readIn.equals("Y") || readIn.equals("y")) {
                            runAlgos[i] = true;
                        }
                        else {
                            runAlgos[i] = false;
                        }
                    }
                    selecter.close();
                    break;
                default:
                    System.out.println("Error: Your input is invalid. Please review the README file!");
                    System.exit(1);
            }
        }

        // 3 Args (Verbose + Wait + File), (Verbose + Select + File), (Wait + Select + File)
        else if (args.length == 3) {
            String switchStr = args[0];
            String switch2Str = args[1];
            switch (switchStr) {
                case "--verbose":
                    verbose = true;
                    switch (switch2Str) {
                        case "--wait":
                            fileName = args[2];
                            runWait = true;
                            break;
                        case "--select":
                            fileName = args[2];
                            Scanner selecter = new Scanner(System.in);
                            for (int i = 0; i < 4; i++) {
                                System.out.printf("\nWould you want to run the %s scheduling algorithm? Enter Y or y for YES. Enter any other key for No.", nameAlgos[i]);
                                String readIn = selecter.next();
                                if (readIn.equals("Y") || readIn.equals("y")) {
                                    runAlgos[i] = true;
                                }
                                else {
                                    runAlgos[i] = false;
                                }
                            }
                            break;
                        default:
                            System.out.println("Error: Your input is invalid. Please review the README file! 1");
                            System.exit(1);
                    }
                    break;
                case "--verbosematch":
                    verbose = true;
                    match = true;
                    switch (switch2Str) {
                        case "--wait":
                            fileName = args[2];
                            runWait = true;
                            break;
                        case "--select":
                            fileName = args[2];
                            Scanner selecter = new Scanner(System.in);
                            for (int i = 0; i < 4; i++) {
                                System.out.printf("\nWould you want to run the %s scheduling algorithm? Enter Y or y for YES. Enter any other key for No.", nameAlgos[i]);
                                String readIn = selecter.next();
                                if (readIn.equals("Y") || readIn.equals("y")) {
                                    runAlgos[i] = true;
                                }
                                else {
                                    runAlgos[i] = false;
                                }
                            }
                            break;
                        default:
                            System.out.println("Error: Your input is invalid. Please review the README file! 2");
                            System.exit(1);
                    }
                    break;
                case "--wait":
                    runWait = true;
                    switch (switch2Str) {
                        case "--verbose":
                            fileName = args[2];
                            verbose = true;
                            break;
                        case "--verbosematch":
                            fileName = args[2];
                            verbose = true;
                            match = true;
                            break;
                        case "--select":
                            fileName = args[2];
                            Scanner selecter = new Scanner(System.in);
                            for (int i = 0; i < 4; i++) {
                                System.out.printf("\nWould you want to run the %s scheduling algorithm? Enter Y or y for YES. Enter any other key for No.", nameAlgos[i]);
                                String readIn = selecter.next();
                                if (readIn.equals("Y") || readIn.equals("y")) {
                                    runAlgos[i] = true;
                                }
                                else {
                                    runAlgos[i] = false;
                                }
                            }
                            selecter.close();
                            break;
                        default:
                            System.out.println("Error: Your input is invalid. Please review the README file! 3");
                            System.exit(1);
                    }
                    break;
                case "--select":
                    switch (switch2Str) {
                        case "--verbose":
                            verbose = true;
                            fileName = args[2];
                            break;
                        case "--verbosematch":
                            fileName = args[2];
                            verbose = true;
                            match = true;
                            break;
                        case "--wait":
                            runWait = true;
                            fileName = args[2];
                            break;
                        default:
                            System.out.println("Error: Your input is invalid. Please review the README file! 4");
                            System.exit(1);
                    }
                    Scanner selecter = new Scanner(System.in);
                    for (int i = 0; i < 4; i++) {
                        System.out.printf("\nWould you want to run the %s scheduling algorithm? Enter Y or y for YES. Enter any other key for No.", nameAlgos[i]);
                        String readIn = selecter.next();
                        if (readIn.equals("Y") || readIn.equals("y")) {
                            runAlgos[i] = true;
                        }
                        else {
                            runAlgos[i] = false;
                        }
                    }
                    break;
                default:
                    System.out.println("Error: Your input is invalid. Please review the README file! 5");
                    System.exit(1);
            }
        }
        // 4 Args (Verbose + Wait + Select + File)
        else if (args.length == 4) {
            if (args[0].equals("--verbose") || args[1].equals("--verbose") || args[2].equals("--verbose")) {
                verbose = true;
            }
            else if (args[0].equals("--verbosematch") || args[1].equals("--verbosematch") || args[2].equals("--verbosematch")) {
                verbose = true;
                match = true;
            }
            else {
                System.out.println("Error: Your input is invalid. Please review the README file!");
                System.exit(1);
            }
            if (args[0].equals("--wait") || args[1].equals("--wait") || args[2].equals("--wait")) {
                runWait = true;
            }
            else {
                System.out.println("Error: Your input is invalid. Please review the README file!");
                System.exit(1);
            }
            if (args[0].equals("--select") || args[1].equals("--select") || args[2].equals("--select")) {
                Scanner selecter = new Scanner(System.in);
                for (int i = 0; i < 4; i++) {
                    System.out.printf("\nWould you want to run the %s scheduling algorithm? Enter Y or y for YES. Enter any other key for No.", nameAlgos[i]);
                    String readIn = selecter.next();
                    if (readIn.equals("Y") || readIn.equals("y")) {
                        runAlgos[i] = true;
                    }
                    else {
                        runAlgos[i] = false;
                    }
                }
            }
            else {
                System.out.println("Error: Your input is invalid. Please review the README file!");
                System.exit(1);
            }
            fileName = args[3];
        }
        // Too many or too few Args (Error)
        else{
            System.out.println("Error: Your input is invalid. Please review the README file!");
            System.exit(1);
        }

        // Try to use file. If not able, filename is bad
        File fileInput = new File(fileName);
        if (fileInput.exists() == false){
            System.out.println("Error: The filename entered is not in the directory.");
            System.exit(0);
        }

        // Create scanner to read file.
        Scanner reader = new Scanner(fileInput);
        // Create scanner to wait
        Scanner runScanner = new Scanner(System.in);

        // Create storage for processes, passed by first integer in input.
        int numProcesses = Integer.parseInt(reader.next());
        Process pList[] = new Process[numProcesses];
        Process pListRR[] = new Process[numProcesses];
        Process pListLC[] = new Process[numProcesses];
        Process pListHP[] = new Process[numProcesses];

        // Create Object that holds randomOS(U) Function
        rng random = new rng();

        // Read in Processes
        for (int i = 0; i < numProcesses; i++){
            Integer inputs[] = new Integer[4];
            for(int j = 0; j < 4; j++) {
                String unclean = reader.next();
                String clean = new String();
                if(unclean.contains("(")){
                    clean = unclean.replace("(","");
                }
                else if(unclean.contains(")")) {
                    clean = unclean.replace(")", "");
                }
                else {
                    clean = unclean;
                }
                inputs[j] = Integer.parseInt(clean);
            }
            // Multi Array
            pList[i] = new Process(inputs[0], inputs[1], inputs[2], inputs[3], i);
            // Set timer from -1 (Not Use) to 2 (Quantum 2) for RR
            pListRR[i] = new Process(inputs[0], inputs[1], inputs[2], inputs[3], i);
            pListRR[i].timer = 2;
            // Remaining Arrays
            pListLC[i] = new Process(inputs[0], inputs[1], inputs[2], inputs[3], i);
            pListHP[i] = new Process(inputs[0], inputs[1], inputs[2], inputs[3], i);
        }
        // Close Reader of File (no longer needed)
        reader.close();

        // Print out Input
        System.out.printf("The original input was: %d ", numProcesses);
        for (int i = 0; i < numProcesses; i++){
            pList[i].printProcess();
        }
        System.out.println();
        // Sort All Arrays
        Arrays.sort(pList);
        Arrays.sort(pListRR);
        Arrays.sort(pListLC);
        Arrays.sort(pListHP);

        // Print out Sorted
        System.out.printf("The sorted input is: %d ", numProcesses);
        for (int i = 0; i < numProcesses; i++){
            pList[i].printProcess();
        }
        System.out.println();

        // SCHEDULER CODE

        // First Come First Served Algorithm
        Queue<Process> FCFSqueue = new LinkedList<Process>();
        boolean FCFSgo = true;
        int FCFScycle = 0;
        Process FCFSrunning=null;
        int FCFStotalCPU = 0;
        int FCFStotalIO = 0;

        // Selector and Messages
        if(runAlgos[0]) {
            // Run This Algo
            // Waiter
            if (runWait) {
                System.out.printf("\nWAITING: About to run %s Scheduler. Enter any letter to start. \n", nameAlgos[0]);
                String temp = runScanner.next();
            }
            // Do, or After Waiting
            System.out.printf("=== SCHEDULER: %s ===\n", nameAlgos[0]);
            //Verbose Message
            if(verbose && match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running VERBOSE MATCH - Meaning output will match given output but may VIOLATE spec.");
                System.out.println("See README for more details about the spec violation to match given output.\n");
            }
            else if (verbose && !match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running STANDARD - Meaning output may NOT match given output but will match spec.");
                System.out.println("See README for more details about the output deviation.\n");
            }
        }
        else {
            // Skip this Algo
            FCFSgo = false;
            System.out.printf(">>-->> >>-->> >>-->>  >>-->> >>-->> >>-->>\n");
            System.out.printf("SKIPPED %s\n", nameAlgos[0]);
            System.out.printf(">>-->> >>-->> >>-->>   >>-->> >>-->> >>-->>\n\n");
        }

        while(FCFSgo) {
            if (verbose) {
                System.out.printf("Before cycle %4d:  ", FCFScycle);
                for (int i = 0; i < numProcesses; i++) {
                    pList[i].printVerbose();
                }
                System.out.println("");
            }
            // IO Active Check
            boolean ioActive = false;
            for (int i=0; i<numProcesses; i++) {
                if (pList[i].ioB > 0 && pList[i].state == 3) {
                    ioActive = true;
                }
            }
            if (ioActive) {
                FCFStotalIO++;
            }

            for (int i = 0; i< numProcesses; i++) {
                // Waiting Ready
                if(pList[i].state == 1) {
                    pList[i].waitTime++;
                }
                // Un - Unstart
                if(pList[i].arrival == FCFScycle) {
                    pList[i].state = 1;
                    FCFSqueue.add(pList[i]);
                }
                // Do IO blocked
                if(pList[i].state == 3) {
                    pList[i].io();
                    if(pList[i].ioB == 0) {
                        pList[i].state = 1;
                        FCFSqueue.add(pList[i]);
                    }
                }
                // Do Running
                if(pList[i].state == 2) {
                    pList[i].run();
                    FCFStotalCPU++;
                    // Finish
                    if (pList[i].remCPU == 0) {
                        pList[i].state = 4;
                        pList[i].finTime = FCFScycle;
                        FCFSrunning = null;
                    }
                    // Get blocked
                    else if (pList[i].cpuB == 0){
                        pList[i].state = 3;
                        FCFSrunning = null;
                    }
                }
            }

            // If no active job, find one.
            if (FCFSrunning == null) {
                if(FCFSqueue.peek() == null) {
                    int terminated = 0;
                    for(int i = 0; i<numProcesses; i++) {
                        if (pList[i].state == 4) {
                            terminated++;
                        }
                    }
                    if (terminated == numProcesses) {
                        // All processes have terminated
                        FCFSgo = false;
                        break;
                    }
                }
                else {
                    FCFSrunning = FCFSqueue.remove();
                    int nextCPUb = random.randomOS(FCFSrunning.burstCPU);
                    // notMatch (by will be true). Only when working to match the output notMatch be false.
                    // To get matching, we have to disregard when randomOS(U) > remCPU use remCPU.
                    // To get matching, we ALWAYS use randomOS.
                    if (nextCPUb > FCFSrunning.remCPU && !match) {
                        nextCPUb = FCFSrunning.remCPU;
                    }
                    FCFSrunning.cpuB = nextCPUb;
                    FCFSrunning.ioB = FCFSrunning.M * nextCPUb; // Also calculate what the next ioBurst is.
                    FCFSrunning.state = 2;
                }
            }
            FCFScycle++;
        }

        if (runAlgos[0]) {
            //Print out FCFS processes
            double FCFSturn = 0;
            double FCFSwait = 0;
            System.out.println();
            System.out.println("The scheduling algorithm used was First Come First Served (FCFS).");
            System.out.println();
            for (int i = 0; i < numProcesses; i++) {
                FCFSturn += (pList[i].finTime - pList[i].arrival);
                FCFSwait += pList[i].waitTime;
                pList[i].printProcEnd(i);
            }
            FCFSturn = FCFSturn / numProcesses;
            FCFSwait = FCFSwait / numProcesses;
            double DFCFScycle = (double) FCFScycle;
            double FCFScpu = FCFStotalCPU / DFCFScycle;
            double FCFSio = FCFStotalIO / DFCFScycle;
            double FCFS100 = (double) numProcesses / DFCFScycle * 100;

            System.out.printf("Summary Data: \n");
            System.out.printf("    Finishing Time:  %d \n", FCFScycle);
            System.out.printf("    CPU Utilization: %.6f \n", FCFScpu);
            System.out.printf("    I/O Utilization: %.6f \n", FCFSio);
            System.out.printf("    Throughput:      %.6f per hundred cycles \n", FCFS100);
            System.out.printf("    Average Turnaround Time:  %.6f \n", FCFSturn);
            System.out.printf("    Average Waiting Time :    %.6f \n", FCFSwait);
        }
        // Reset the random numbers
        random.reset();

        // Round Robin Algorithm with Quantum 2
        Queue<Process> RRqueue = new LinkedList<Process>();
        boolean RRgo = true;
        int RRcycle = 0;
        Process RRrunning=null;
        int RRtotalCPU = 0;
        int RRtotalIO = 0;

        // Selector and Messages
        if(runAlgos[1]) {
            // Run this Algo
            // Waiter
            if (runWait) {
                System.out.printf("\nWAITING: About to run %s Scheduler. Enter any letter to start. \n", nameAlgos[1]);
                String temp = runScanner.next();
            }
            // Do, or After Waiting
            System.out.printf("=== SCHEDULER: %s ===\n", nameAlgos[1]);
            //Verbose Messages
            if(verbose && match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running VERBOSE MATCH - Meaning output will match given output but may VIOLATE spec.");
                System.out.println("See README for more details about the spec violation to match given output.\n");
            }
            else if (verbose && !match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running STANDARD - Meaning output may NOT match given output but will match spec.");
                System.out.println("See README for more details about the output deviation.\n");
            }
        }
        else {
            // Skip this Algo
            RRgo = false;
            System.out.printf(">>-->> >>-->> >>-->>  >>-->> >>-->> >>-->>\n");
            System.out.printf("SKIPPED %s\n", nameAlgos[1]);
            System.out.printf(">>-->> >>-->> >>-->>   >>-->> >>-->> >>-->>\n \n");
        }

        while(RRgo) {
            if (verbose) {
                System.out.printf("Before cycle %4d:  ", RRcycle);
                for (int i = 0; i < numProcesses; i++) {
                    pListRR[i].printVerbose();
                }
                System.out.println("");
            }
            // IO Active Check
            boolean ioActive = false;
            for (int i = 0; i < numProcesses; i++) {
                if (pListRR[i].ioB > 0 && pListRR[i].state == 3) {
                    ioActive = true;
                }
            }
            if (ioActive) {
                RRtotalIO++;
            }
            for (int i=0; i<numProcesses; i++) {

                // Waiting Ready
                if(pListRR[i].state == 1) {
                    pListRR[i].waitTime++;
                }
                // Un - Unstart
                if(pListRR[i].arrival == RRcycle) {
                    pListRR[i].state = 1;
                    RRqueue.add(pListRR[i]);
                }
                // Do IO blocked
                if(pListRR[i].state == 3) {
                    pListRR[i].io();
                    if(pListRR[i].ioB == 0) {
                        pListRR[i].state = 1;
                        RRqueue.add(pListRR[i]);
                    }
                }

                // Do Running
                if(pListRR[i].state == 2) {
                    pListRR[i].run();
                    pListRR[i].timer--;
                    RRtotalCPU++;
                    // Finish
                    if (pListRR[i].remCPU == 0) {
                        pListRR[i].state = 4;
                        pListRR[i].finTime = RRcycle;
                        RRrunning = null;
                    }
                    // Get blocked
                    else if (pListRR[i].cpuB == 0){
                        pListRR[i].state = 3;
                        pListRR[i].timer = 2;
                        pListRR[i].qUsed = false;
                        RRrunning = null;
                    }
                    // Get Expired
                    else if ((pListRR[i].cpuB > 0) && (pListRR[i].timer == 0)) {
                        pListRR[i].state = 1;
                        pListRR[i].timer = 2;
                        pListRR[i].qUsed = true;
                        RRqueue.add(pListRR[i]);
                        RRrunning = null;
                    }
                }
            }
            // If no active job, find one
            if (RRrunning == null) {
                if(RRqueue.peek() == null) {
                    int terminated = 0;
                    for (int i = 0; i < numProcesses; i++) {
                        if (pListRR[i].state == 4) {
                            terminated++;
                        }
                    }
                    if (terminated == numProcesses) {
                        // All processes have terminated
                        RRgo = false;
                        break;
                    }
                }
                else {
                    RRrunning = RRqueue.remove();
                    if(RRrunning.qUsed == false){
                        int nextCPUb = random.randomOS(RRrunning.burstCPU);
                        // notMatch (by will be true). Only when working to match the output notMatch be false.
                        // To get matching, we have to disregard when randomOS(U) > remCPU use remCPU.
                        // To get matching, we ALWAYS use randomOS.
                        if(nextCPUb > RRrunning.remCPU && !match) {
                            nextCPUb = RRrunning.remCPU;
                        }
                        RRrunning.cpuB = nextCPUb;
                        RRrunning.ioB = RRrunning.M * nextCPUb; // Also calculate what the next ioBurst is.
                    }
                    RRrunning.state = 2;
                }
            }
            RRcycle++;
        }

        if (runAlgos[1]) {
            //Print out RR processes
            double RRturn = 0;
            double RRwait = 0;
            System.out.println();
            System.out.println("The scheduling algorithm used was Round Robin with Quantum 2 (RR).");
            System.out.println();
            for (int i = 0; i < numProcesses; i++) {
                RRturn += (pListRR[i].finTime - pListRR[i].arrival);
                RRwait += pListRR[i].waitTime;
                pListRR[i].printProcEnd(i);
            }
            RRturn = RRturn / numProcesses;
            RRwait = RRwait / numProcesses;
            double DRRcycle = (double) RRcycle;
            double RRcpu = RRtotalCPU / DRRcycle;
            double RRio = RRtotalIO / DRRcycle;
            double RR100 = (double) numProcesses / DRRcycle * 100;

            System.out.printf("Summary Data: \n");
            System.out.printf("    Finishing Time:  %d \n", RRcycle);
            System.out.printf("    CPU Utilization: %.6f \n", RRcpu);
            System.out.printf("    I/O Utilization: %.6f \n", RRio);
            System.out.printf("    Throughput:      %.6f per hundred cycles \n", RR100);
            System.out.printf("    Average Turnaround Time:  %.6f \n", RRturn);
            System.out.printf("    Average Waiting Time :    %.6f \n", RRwait);
        }
        // Reset the random numbers
        random.reset();


        // Last Come First Served
        Stack<Process> LCFSqueue = new Stack<Process>();
        boolean LCFSgo = true;
        int LCFScycle = 0;
        Process LCFSrunning=null;
        int LCFStotalCPU = 0;
        int LCFStotalIO = 0;

        // Selector and Messages
        if(runAlgos[2]) {
            // Run This Algo
            // Waiter
            if (runWait) {
                System.out.printf("\nWAITING: About to run %s Scheduler. Enter any letter to start. \n", nameAlgos[2]);
                String temp = runScanner.next();
            }
            // Do, or After Waiting
            System.out.printf("=== SCHEDULER: %s ===\n", nameAlgos[2]);
            //Verbose Message
            if(verbose && match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running VERBOSE MATCH - Meaning output will match given output but may VIOLATE spec.");
                System.out.println("See README for more details about the spec violation to match given output.\n");
            }
            else if (verbose && !match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running STANDARD - Meaning output may NOT match given output but will match spec.");
                System.out.println("See README for more details about the output deviation.\n");
            }
        }
        else {
            // Skip this Algo
            LCFSgo = false;
            System.out.printf(">>-->> >>-->> >>-->>  >>-->> >>-->> >>-->>\n");
            System.out.printf("SKIPPED %s\n", nameAlgos[2]);
            System.out.printf(">>-->> >>-->> >>-->>   >>-->> >>-->> >>-->>\n\n");
        }

        while(LCFSgo) {
            if (verbose) {
                System.out.printf("Before cycle %4d:  ", LCFScycle);
                for (int i = 0; i < numProcesses; i++) {
                    pListLC[i].printVerbose();
                }
                System.out.println("");
            }

            // Check if any process will unblock next cycle
            ArrayList<Process> almostReady = new ArrayList<Process>();
            int blocked = 0;
            for (int i = 0; i < numProcesses; i++) {
                if(pListLC[i].ioB == 1 && pListLC[i].state == 3) {
                    almostReady.add(pListLC[i]);
                    blocked++;
                }
            }
            // If so, find the number that will unblock (and deal with any multi-unblockes)
            if(blocked > 1){
                // Sort by arrival time.
                for(int i = 0; i < blocked; i++) {
                    almostReady.get(i).singleBlock = false;
                    Process LCtemp = almostReady.get(i);
                    int index = i - 1;
                    while(index >= 0 && LCtemp.arrival < almostReady.get(index).arrival) {
                        Process LCtemp2 = almostReady.get(index);
                        almostReady.set(index+1, LCtemp2);
                        index = index - 1;
                    }
                    almostReady.set(index + 1, LCtemp);
                }
                // Swap by inputPosition
                for (int i = 0; i < blocked - 1; i++) {
                    if(almostReady.get(i).arrival == almostReady.get(i+1).arrival) {
                        if(almostReady.get(i).inputPos > almostReady.get(i+1).inputPos) {
                            Process LCswap = almostReady.get(i);
                            Process LCswap2 = almostReady.get(i+1);
                            almostReady.set(i,LCswap2);
                            almostReady.set(i+1, LCswap);
                        }
                    }
                }
                // Add to queue (bc will unblock this cycle)
                for (int a = blocked - 1; a >= 0; a--) {
                    LCFSqueue.push(almostReady.get(a));
                }
            }


            // IO Active Check, AND Unstarted Process Starter (Work backwards)
            boolean ioActive = false;
            for (int i = numProcesses - 1; i >= 0; i--) {
                if (pListLC[i].ioB > 0 && pListLC[i].state == 3) {
                    ioActive = true;
                }
                if(pListLC[i].arrival == LCFScycle) {
                    pListLC[i].state = 1;
                    LCFSqueue.add(pListLC[i]);
                }
            }
            if (ioActive) {
                LCFStotalIO++;
            }

            for (int i = 0; i < numProcesses; i++) {
                // Waiting Ready
                if(pListLC[i].state == 1) {
                    pListLC[i].waitTime++;
                }
                // Do IO blocked
                if(pListLC[i].state == 3) {
                    pListLC[i].io();
                    if(pListLC[i].ioB == 0) {
                        if(pListLC[i].singleBlock) {
                            pListLC[i].state = 1;
                            LCFSqueue.add(pListLC[i]);
                        }
                        else {
                            // Was already added to queue in the multi-unblock above
                            pListLC[i].state = 1;
                            pListLC[i].singleBlock = true;
                        }
                    }
                }
                // Do Running
                if(pListLC[i].state == 2) {
                    pListLC[i].run();
                    LCFStotalCPU++;
                    // Finish
                    if (pListLC[i].remCPU == 0) {
                        pListLC[i].state = 4;
                        pListLC[i].finTime = LCFScycle;
                        LCFSrunning = null;
                    }
                    // Get blocked
                    else if (pListLC[i].cpuB == 0){
                        pListLC[i].state = 3;
                        LCFSrunning = null;
                    }
                }
            }

            // If no active job, find one.
            if (LCFSrunning == null) {
                if(LCFSqueue.empty()) {
                    int terminated = 0;
                    for(int i = 0; i<numProcesses; i++) {
                        if (pListLC[i].state == 4) {
                            terminated++;
                        }
                    }
                    if (terminated == numProcesses) {
                        // All processes have terminated
                        LCFSgo = false;
                        break;
                    }
                }
                else {
                    LCFSrunning = LCFSqueue.pop();
                    int nextCPUb = random.randomOS(LCFSrunning.burstCPU);
                    // notMatch (by will be true). Only when working to match the output notMatch be false.
                    // To get matching, we have to disregard when randomOS(U) > remCPU use remCPU.
                    // To get matching, we ALWAYS use randomOS.
                    if (nextCPUb > LCFSrunning.remCPU  && !match) {
                        nextCPUb = LCFSrunning.remCPU;
                    }
                    LCFSrunning.cpuB = nextCPUb;
                    LCFSrunning.ioB = LCFSrunning.M * nextCPUb;
                    LCFSrunning.state = 2;
                }
            }
            LCFScycle++;
        }

        if(runAlgos[2]) {
            //Print out LCFS processes
            double LCFSturn = 0;
            double LCFSwait = 0;
            System.out.println();
            System.out.println("The scheduling algorithm used was Last Come First Served (LCFS).");
            System.out.println();
            for (int i = 0; i < numProcesses; i++) {
                LCFSturn += (pListLC[i].finTime - pListLC[i].arrival);
                pListLC[i].waitTime--;
                LCFSwait += pListLC[i].waitTime;
                pListLC[i].printProcEnd(i);
            }
            LCFSturn = LCFSturn / numProcesses;
            LCFSwait = LCFSwait / numProcesses;
            double DLCFScycle = (double) LCFScycle;
            double LCFScpu = LCFStotalCPU / DLCFScycle;
            double LCFSio = LCFStotalIO / DLCFScycle;
            double LCFS100 = (double) numProcesses / DLCFScycle * 100;

            System.out.printf("Summary Data: \n");
            System.out.printf("    Finishing Time:  %d \n", LCFScycle);
            System.out.printf("    CPU Utilization: %.6f \n", LCFScpu);
            System.out.printf("    I/O Utilization: %.6f \n", LCFSio);
            System.out.printf("    Throughput:      %.6f per hundred cycles \n", LCFS100);
            System.out.printf("    Average Turnaround Time:  %.6f \n", LCFSturn);
            System.out.printf("    Average Waiting Time :    %.6f \n", LCFSwait);
        }
        // Reset the random numbers
        random.reset();

        // Highest Penalty Ration Next Algorithm
        Queue<Process> HPRNqueue = new LinkedList<Process>();
        boolean HPRNgo = true;
        int HPRNcycle = 0;
        Process HPRNrunning=null;
        int HPRNtotalCPU = 0;
        int HPRNtotalIO = 0;

        // Selector and Messages
        if(runAlgos[3]) {
            // Run This Algo
            // Waiter
            if (runWait) {
                System.out.printf("\nWAITING: About to run %s Scheduler. Enter any letter to start. \n", nameAlgos[3]);
                String temp = runScanner.next();
            }
            // Do, or After Waiting
            System.out.printf("=== SCHEDULER: %s ===\n", nameAlgos[3]);
            //Verbose Message
            if(verbose && match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running VERBOSE MATCH - Meaning output will match given output but may VIOLATE spec.");
                System.out.println("See ReadMe for more details about the spec violation to match given output.\n");
            }
            else if (verbose && !match){
                System.out.println("This detailed printout gives the state and remaining burst for each process");
                System.out.println("Running STANDARD - Meaning output may NOT match given output but will match spec.");
                System.out.println("See ReadMe for more details about the output deviation.\n");
            }
        }
        else {
            // Skip this Algo
            HPRNgo = false;
            System.out.printf(">>-->> >>-->> >>-->>  >>-->> >>-->> >>-->>\n");
            System.out.printf("SKIPPED %s\n", nameAlgos[3]);
            System.out.printf(">>-->> >>-->> >>-->>   >>-->> >>-->> >>-->>\n\n");
        }

        while(HPRNgo) {
            if (verbose) {
                System.out.printf("Before cycle %4d:  ", HPRNcycle);
                for (int i = 0; i < numProcesses; i++) {
                    pListHP[i].printVerbose();
                }
                System.out.println("");
            }
            // IO Active Check
            boolean ioActive = false;
            for (int i=0; i<numProcesses; i++) {
                if (pListHP[i].ioB > 0 && pListHP[i].state == 3) {
                    ioActive = true;
                }
            }
            if (ioActive) {
                HPRNtotalIO++;
            }

            for (int i = 0; i< numProcesses; i++) {
                // Waiting Ready
                if(pListHP[i].state == 1) {
                    pListHP[i].waitTime++;
                }

                // Un - Unstart
                if(pListHP[i].arrival == HPRNcycle) {
                    pListHP[i].state = 1;
                    HPRNqueue.add(pListHP[i]);
                }

                // Do IO blocked
                if(pListHP[i].state == 3) {
                    pListHP[i].io();
                    if(pListHP[i].ioB == 0) {
                        pListHP[i].state = 1;
                        HPRNqueue.add(pListHP[i]);
                    }
                }
                // Do Running
                if(pListHP[i].state == 2) {
                    pListHP[i].run();
                    HPRNtotalCPU++;
                    // Finish
                    if (pListHP[i].remCPU == 0) {
                        pListHP[i].state = 4;
                        pListHP[i].finTime = HPRNcycle;
                        HPRNrunning = null;
                    }
                    // Get blocked
                    else if (pListHP[i].cpuB == 0){
                        pListHP[i].state = 3;
                        HPRNrunning = null;
                    }
                }
            }
            // Update Penalty Ratios
            for (int i = 0; i< numProcesses; i++) {
                pListHP[i].updateRatio(HPRNcycle);
            }

            // If no active job, find one.
            if (HPRNrunning == null) {
                if(HPRNqueue.peek() == null) {
                    int terminated = 0;
                    for(int i = 0; i<numProcesses; i++) {
                        if (pListHP[i].state == 4) {
                            terminated++;
                        }
                    }
                    if (terminated == numProcesses) {
                        // All processes have terminated
                        HPRNgo = false;
                        break;
                    }
                }
                else {
                    // Sort the list before getting a new one
                    ArrayList<Process> sorter = new ArrayList<Process>();
                    // Make a temporary ArrayList to use the Collections sort using a custom defined comparator
                    while(HPRNqueue.isEmpty() == false){
                        sorter.add(HPRNqueue.remove());
                    }
                    Collections.sort(sorter, new ComparatorRatio());
                    // Restore Queue is sorted order
                    HPRNqueue.addAll(sorter);

                    // Get from the sorted list
                    HPRNrunning = HPRNqueue.remove();
                    int nextCPUb = random.randomOS(HPRNrunning.burstCPU);
                    // notMatch (by will be true). Only when working to match the output notMatch be false.
                    // To get matching, we have to disregard when randomOS(U) > remCPU use remCPU.
                    // To get matching, we ALWAYS use randomOS.
                    if (nextCPUb > HPRNrunning.remCPU && !match) {
                        nextCPUb = HPRNrunning.remCPU;
                    }
                    HPRNrunning.cpuB = nextCPUb;
                    HPRNrunning.ioB = HPRNrunning.M * nextCPUb;
                    HPRNrunning.state = 2;
                }
            }
           HPRNcycle++;
        }
        if (runAlgos[3]) {
            //Print out HPRN processes
            double HPRNturn = 0;
            double HPRNwait = 0;
            System.out.println();
            System.out.println("The scheduling algorithm used was Highest Penalty Ratio Next (HPRN).");
            System.out.println();
            for (int i = 0; i < numProcesses; i++) {
                HPRNturn += (pListHP[i].finTime - pListHP[i].arrival);
                HPRNwait += pListHP[i].waitTime;
                pListHP[i].printProcEnd(i);
            }
            HPRNturn = HPRNturn / numProcesses;
            HPRNwait = HPRNwait / numProcesses;
            double DHPRNcycle = (double) HPRNcycle;
            double HPRNcpu = HPRNtotalCPU / DHPRNcycle;
            double HPRNio = HPRNtotalIO / DHPRNcycle;
            double HPRN100 = (double) numProcesses / DHPRNcycle * 100;

            System.out.printf("Summary Data: \n");
            System.out.printf("    Finishing Time:  %d \n", HPRNcycle);
            System.out.printf("    CPU Utilization: %.6f \n", HPRNcpu);
            System.out.printf("    I/O Utilization: %.6f \n", HPRNio);
            System.out.printf("    Throughput:      %.6f per hundred cycles \n", HPRN100);
            System.out.printf("    Average Turnaround Time:  %.6f \n", HPRNturn);
            System.out.printf("    Average Waiting Time :    %.6f \n", HPRNwait);
        }
        // Close RNG item
        random.end();
        // Close Run Waiting Scanner
        runScanner.close();
    }

    public static class Process implements Comparable<Process> {
        // fields
        int arrival = 0;
        int burstCPU = 0;
        int totalCPU = 0;
        int remCPU = 0;
        int M = 0;

        int cpuB;
        int ioB;
        int state;

        int ioTime;
        int finTime;
        int waitTime;

        int inputPos;
        int timer = -1;
        double ratio;
        boolean qUsed = false;
        boolean singleBlock = true;

        public Process(int A, int B, int C, int M, int pos){ // constructor
            this.arrival = A;
            this.burstCPU = B;
            this.totalCPU = C; // Fixed C (total CPU needed)
            this.remCPU = C; // Decementing C (remCPU), to know when is complete.
            this.M = M;
            this.inputPos = pos;
        }

        public void run(){
            remCPU--;
            cpuB--;
        }

        public void io(){
            ioTime++;
            ioB--;
        }

        public void printProcess(){
            System.out.printf(" (%d %d %d %d)", this.arrival, this.burstCPU, this.totalCPU, this.M);
        }

        public void printProcEnd(int i){
            System.out.printf("Process %d:\n" , i);
            System.out.printf("    (A,B,C,M) = (%d,%d,%d,%d)\n", this.arrival, this.burstCPU, this.totalCPU, this.M);
            System.out.printf("    Finishing Time:  %d \n", this.finTime);
            System.out.printf("    Turnaround Time: %d \n", (this.finTime-this.arrival));
            System.out.printf("    I/O Time:        %d \n", this.ioTime);
            System.out.printf("    Waiting Time:    %d \n",this.waitTime);
            System.out.println();
        }

        public void printVerbose(){
            switch (this.state) {
                case 0:
                    System.out.printf(" unstarted %-3d ", 0);
                    break;
                case 1:
                    System.out.printf("     ready %-3d ", 0);
                    break;
                case 2:
                    if (this.timer == -1) {
                        System.out.printf("   running %-3d ", this.cpuB);
                    }
                    else {
                        if (this.timer < this.cpuB) {
                            System.out.printf("   running %-3d ", this.timer);
                        }
                        else {
                            System.out.printf("   running %-3d ", this.cpuB);
                        }
                    }
                    break;
                case 3:
                    System.out.printf("   blocked %-3d ", this.ioB);
                    break;
                case 4:
                    System.out.printf("terminated %-3d ", 0);
                    break;
            }
        }

        public int compareTo(Process o){
            if(this.arrival != o.arrival){
                return(arrival - o.arrival);
            }
            else{
                return (inputPos - o.inputPos);
            }
        }

        public void updateRatio(int cycle){
            double bigT = (double) (cycle - this.arrival);
            int gottenCPU = this.totalCPU - this.remCPU;
            double smallT = (double) Integer.max(1, gottenCPU);
            this.ratio = bigT / smallT;
        }
    }

    public static class ComparatorRatio implements Comparator<Object>{
        public int compare (Object obj1, Object obj2){
            Process p1 = (Process) obj1;
            Process p2 = (Process) obj2;
            if(p1.ratio < p2.ratio){
                return 1;
            }
            else if(p1.ratio > p2.ratio){
                return -1;
            }
            else{
                if(p1.inputPos > p2.inputPos){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }
    }

    // Random OS RNG from FILE
    public static class rng{
        File rngFile = new File("random-numbers");
        Scanner rngReader;

        public rng() throws IOException{
            // Test if Available
            if (rngFile.exists() == false){
                System.out.println("Error: The random_numbers file is not in this directory.");
                System.exit(0);
            }
            else {
                this.rngReader = new Scanner(this.rngFile);
            }
        }

        public int randomOS(int u) {
            int x = 0;
            if(rngReader.hasNext()){
                x = rngReader.nextInt();
            }
            x = 1 + x % u;
            return x;
        }

        public void reset() throws IOException{
            this.end();
            if (rngFile.exists() == false){
                System.out.println("Error: The random_numbers file is not in this directory.");
                System.exit(0);
            }
            else {
                this.rngReader = new Scanner(this.rngFile);
            }
        }

        public void end() {
            this.rngReader.close();
        }
    }
}