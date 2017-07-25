//: by.iba.ekkel.holding/EnvironmentVariables.java
package by.iba.ekkel.holding;

import java.util.*;

public class EnvironmentVariables {

	public static void main(String[] args) {
	
		for(Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	
	}
	
} /* Output
LOCALAPPDATA: C:\Users\Svirydchuk_T\AppData\Local
PROCESSOR_LEVEL: 6
SUBLIME: C:\Program Files\Sublime Text 3
FP_NO_HOST_CHECK: NO
MW_HOME: D:\soft\wls12120
USERDOMAIN: IBA
LOGONSERVER: \\DC05
JAVA_HOME: C:\Program Files\Java\jdk1.8.0_91
SESSIONNAME: Console
ALLUSERSPROFILE: C:\ProgramData
PROCESSOR_ARCHITECTURE: AMD64
PSModulePath: C:\windows\system32\WindowsPowerShell\v1.0\Modules\
SystemDrive: C:
APPDATA: C:\Users\Svirydchuk_T\AppData\Roaming
USERNAME: Svirydchuk_T
TOMCAT_HOME: D:\soft\apache-tomcat-8.5.6
USERDNSDOMAIN: IBA
windows_tracing_logfile: C:\BVTBin\Tests\installpackage\csilogfile.log
ProgramFiles(x86): C:\Program Files (x86)
CommonProgramFiles: C:\Program Files\Common Files
Path: C:/Program Files/Java/jre1.8.0_131/bin/server;C:/Program Files/Java/jre1.8.0_131/bin;C:/Program Files/Java/jre1.8.0_131/lib/amd64;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\Intel\iCLS Client\;C:\Program Files\Intel\iCLS Client\;C:\windows\system32;C:\windows;C:\windows\System32\Wbem;C:\windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Java\jdk1.8.0_91\bin;C:\Program Files\Java\jre1.8.0_91\bin;C:\Program Files\Git\cmd;"C:\Program Files\Sublime Text 3";"D:\soft\apache-tomcat-8.5.6";C:\Program Files (x86)\Brackets\command;C:\Program Files (x86)\Calibre2\;C:\Program Files (x86)\Skype\Phone\;D:\soft\eclipse-jee-mars-2-win32-x86_64\eclipse;
PATHEXT: .COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC
OS: Windows_NT
SCM_HOME: C:\Program Files\IBM\SCM
windows_tracing_flags: 3
COMPUTERNAME: SVIRYDCHUK-T
PROCESSOR_REVISION: 3c03
CLASSPATH: D:\java_training\ekkel\TIJ4-code
CommonProgramW6432: C:\Program Files\Common Files
TISDIR: C:\Program Files\IBM\SCM\codeset
ComSpec: C:\windows\system32\cmd.exe
ProgramData: C:\ProgramData
ProgramW6432: C:\Program Files
HOMEPATH: \Users\Svirydchuk_T
SystemRoot: C:\windows
TEMP: C:\Users\SVIRYD~1\AppData\Local\Temp
HOMEDRIVE: C:
PROCESSOR_IDENTIFIER: Intel64 Family 6 Model 60 Stepping 3, GenuineIntel
USERPROFILE: C:\Users\Svirydchuk_T
TMP: C:\Users\SVIRYD~1\AppData\Local\Temp
NLSPATH: C:\Program Files\IBM\SCM\msg\%L\%N.cat;C:\Program Files\IBM\SCM\msg\C\%N.cat
SCM_CLIENT_INST_DIR: C:\Program Files\IBM\SCM\client
CommonProgramFiles(x86): C:\Program Files (x86)\Common Files
ProgramFiles: C:\Program Files
PUBLIC: C:\Users\Public
NUMBER_OF_PROCESSORS: 4
windir: C:\windows
=::: ::\
*///:~
