>ramzi@ramzi-pop-os:~/Development/tutos_enit_java/brouillon/c-06-HR_Test_JDBC$ mvn test


[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.dal.RepeatedAddOnSCTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.813 s - in com.dal.RepeatedAddOnSCTest
[INFO] Running com.dal.RepeatedAddOnPCTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.549 s - in com.dal.RepeatedAddOnPCTest
[INFO] Running com.dal.JobDAOImpl1SCPTest
[INFO] Tests run: 102, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.251 s - in com.dal.JobDAOImpl1SCPTest
[INFO] Running com.dal.JobDAOImpl2PCPTest
[INFO] Tests run: 102, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.458 s - in com.dal.JobDAOImpl2PCPTest
[INFO] Running com.dal.JobDAOImpl1PCPTest
[INFO] Tests run: 102, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.407 s - in com.dal.JobDAOImpl1PCPTest
[INFO] Running com.dal.JobDAOImpl2SCPTest
[INFO] Tests run: 102, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.881 s - in com.dal.JobDAOImpl2SCPTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 424, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.989 s


Single VS Pooled conenction
Statement vs Prepared statement

|                      | statement | prepared statement |
|----------------------|-----------|--------------------|
| pooled connection    | 0.407 s   | 0.458 s            |
| singleton connection | 1.251 s   | 0.881 s            |

Multiple operations
Singleton connection
|                      | statement | prepared statement |
|----------------------|-----------|--------------------|
| connection per TX    | 0.930 s   | 0.740 s            |
| Same transaction     | 0.091 s   | 0.080 s            |
| 1 TX manual commit   | 0.014 s   | 0.010 s            |
| Batch                | 0.014 s   | 0.010 s            |

Multiple operations
Pooled connection
|                      | statement | prepared statement |
|----------------------|-----------|--------------------|
| connection per TX    | 0.410 s   | 0.116 s            |
| Same transaction     | 0.113 s   | 0.085 s            |
| 1 TX manual commit   | 0.012 s   | 0.004 s            |
| Batch                | 0.010 s   | 0.004 s            |
