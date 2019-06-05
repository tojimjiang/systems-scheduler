# Scheduler
A README File

## What is this?
This is a program that emulates the scheduleduling of jobs that need processing.
This is based on the lab specification for the Scheduler Lab for Operating Systems.

This scheduler takes in command line arguments when calling the program. This scheduler features 4 algorithms as specified in the specification. There is a verbose feature. (See below for more details). RandomOS as required in the specification was implemented as a class that contains a scanner for the random_numbers file. This program works with the two REQUIRED invocations of `program file` and `program --verbose file`. There are --verbose, --verbosematch, --select, and --wait flags. For details about these flags see below. **IMPORTANT** FILE NAME MUST BE THE LAST ARGUMENT IN INVOCATION.


## How to Compile

### On  Windows and NYU Compute Servers
To compile and run the program, load the file scheduler.java to your working directory. 
Next, using a terminal window with the javac and java commands, compile the java program by using the command "javac scheduler.java"
a) To run the program after compilation w/o detailed output use the command `java scheduler 'file' `. 
b) To run the program after compilation with SPEC COMPLIANT detailed output use the command `java scheduler --verbose 'file' `. [This output may violate the given output] See below for details.
c) To run the program after compilation with GIVEN OUTPUT COMPLIANT detailed output use the command `java scheduler --verbosematch 'file' `. [This output may violate the spec] See below for details.

### FreeStyle Compiling
Open the scheduler.java file and copy and paste the source code into wherever you want to compile. 
The class declaration (line 39) may need modifications for freestyle compiling. 
The program must be compiled into a java unit using the Java compiler using at a minimum Java 7.
a) To run the program use the java command, call the program name, and the file.
b) To add tags, add them between the class declaration and the file.
     Example: `java programName --wait --select --verbose 'file' `

### Notes about Compiling and Running
The (input) file MUST be in the same directory as the java file and must be in a similar layout to that of those given in given.
The random_numbers file MUST be in the same directory as the java file.
The random_numbers MUST be similar to that of given, with the SAME file name (random_numbers), file extension (none), and file structure (1 number per line, reasonably infinte relative to the processes (Given was 100k numbers)).
The execution of the program MUST be with the directory with the java/class files as the working directory.
The 'file' argument MUST be the final argument passed in the invocation.
All flags MUST be two dashes (--) followed by the word(s) to use. All letters in tags MUST be lowercase, no spaces within a flag. Multiple flags MUST be seperated by one space ONLY. 
     Example: `scheduler --verbose --wait --select 'file'`
Invocation arguments MUST follow spec, or added flags must follow the spirit of the spec. 
MAX 3 flags per invocation. MAX 4 TOTAL ARGUMENTS at innvoation (MAX 3 Tags plus file). ProgramName is NOT an argument. Calling Java is NOT an argument.

## Flags
###  Detailed Output Flags
(Usage: Only ONE of these flags is allowed per invocation)

Spec Compliant: `--verbose`	
    
This produces detailed output that prints out the status and remaining burst of the processes before every cycle. --verbose follows the SPEC closely, which means in some cases, --verbose's detailed output may not follow (conflict with) the GIVEN OUTPUT. See below for more info. (Detailed Output Deviation)  

Given Output Complant: `--verbosematch` 
This produces detailed output that prints out the status and remaining burst of the processes before every cycle. --verbosematch follows the GIVEN OUTPUT closely, which means in some cases, --verbosematch's detailed output may not follow (conflict with) the SPEC. See below for more info. (Detailed Output Deviation)

### Quality of Life Flags
(Useage: Use as many of these flags as you want per invocation)

`--select`
This queries user about which algortihms to run. User must enter Y or y for each algorithms to run, or enter any other key for algorithms not to run. A successful select flag DOES NOT gurantee successful invocation. If the above very important notes, and below tag usage rules are not followed, program may fail. (Default behavior WITHOUT --select is to run all 4 algorithms)

`--wait`
stops the program before every algorithm to run. Waits for the user to enter any key before starting the stated algorithm in the wait message. A successful wait flag DOES NOT gurantee successful invocation. If the above very important notes, and below flag usage rules are not followed, program may fail. (Default behavior WITHOUT --wait is to run though the program as quickly as possible, with no waits)

### Flag Usage Rules 
All flags MUST be two dashes (--) followed by the word(s) to use. All letters in flags MUST be lowercase, no spaces within a single flag. Example of proper flags: `--verbose --verbosematch --select --wait`
Only ONE detailed output flag may be used. Both QoL flags may be used. A single detailed output flag may be used with both QoL flags.
- Example: `scheduler --verbose --wait --select 'file'` and `scheduler --verbosematch --wait --select 'file'`  

When using multiple flags, order does not matter. BUT, may still fail if very important notes above are not followed. Generally order does not matter for flags.

#### Flag Combination Behavior Examples
- `--verbose --select --wait` 		Queries which algos to run. Then waits before each algo to run for user response. Also detailed prints are spec compliant output.
- `--verbosematch --select --wait` 	Queries which algos to run. Then waits before each algo to run for user response. Also detailed prints are given output compliant output.
- `--select --wait` 				Queries which algos to run. Then waits before each algo to run for user response. No detailed printing.
- `--verbose --select`				Queries which algos to run. Also detailed prints are spec complaint output. Does no waiting.
- `--verbosematch --select`		 	Queries which algos to run. Also detailed prints are given output complaint output. Does no waiting.
- `--verbose --wait` 				Waits before each algo to run for user response. Also detailed prints are spec compliant output. No select, runs all 4 algos.
- `--verbosematch --wait` 			Waits before each algo to run for user response. Also detailed prints are given output compliant output. No select, runs all 4 algos.
- **Default [NO FLAGS]**			Takes input, runs though all algorithms as quickly as possible. No selection, no waiting, no detailed output.

## Detailed Output Deviation 
The given output conflicts with the spec, by violating: (Last Sentence in the 3rd Paragraph of the given Spec PDF)

	"If the value returned by randomOS(B), is larger than the total CPU time remaining, set the next CPU burst to the remaining time."

So, I have two detailed output tags. The first `--verbose` follows the SPEC closely. So, in some cases, the detailed output, namely in the final burst cycle burst values, will vary. This is because `--verbose` causes the program to check when random(OS) > remCycles, and cpuBurst will be set to remCycles in those cases. 

The second detailed output tag `--verbosematch` follows the GIVEN OUTPUT closesly. So, in some cases, the detailed output, namely in the final burst cycles burst values, will not follow the spec. This is because --verbosematch causes the program to ALWAYS assign random(OS) to cpuBurst, it doesn't care the assigned cpuBurst may exceed remCycles. 

In essence, `--verbosematch` is meant to MATCH the given output. `--verbose` is meant to follow the spec. 

### Note About Detailed Output Deviation

For given output 1-3, 6-7, `--verbose` and `--verbosematch` do not vary from the spec nor the given output. (Only select output4 and select output5 have this issue.

## Other Notes 
Quotation marks (and appostrophes) above are for differantion purposes, DO NOT use them when running commands in the terminal.
All input must still follow the specifications indicated. 
The scheduling algorithms are First Come First Served (FCFS), Round Robin (RR), Last Come First Served (LCFS), and Highest Penalty Ratio Next (HPRN). By default they will all run, and in that order. 

## Other Related Repositories:
* [Linker](https://github.com/tojimjiang/systems-linker)  
* [Banker](https://github.com/tojimjiang/systems-banker)  
* [Demand Pager](https://github.com/tojimjiang/systems-pager)  