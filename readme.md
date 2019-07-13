<h2 align="center">Word Changer</h2>

<ol>
	<h4>About</h4>
	<li>WordChanger change the specific word in all the files in given directory</li>
	<li>This program takes three args</li>
	<ol>
		<li><strong>-d</strong>: the directory where files are</li>
		<li><strong>-o</strong>: old word</li>
		<li><strong>-l</strong>: new word</li>
	</ol>
	<li>Example: Let there are 1000 files in /path/to directory</li>
	<li>You want to change a specific word [sentence in each file]</li>
	<li>Then simple run</li>
	<li>java -jar WordChanger-Beta.jar -d /path/to -o oldWord -n newword</li>
</ol>
<ol>
	<h4>Building Instruction</h4>
	Do the following steps
	<li><strong>git clone 'https://github.com/UbaidurRehman1/WordChanger.git'</strong></li>
	<li><strong>cd WordChanger</strong></li>
	<li><strong>mvn test clean compile assembly:single</strong></li>
	<li>cd target</li>
	<li><strong>java -jar  WordChanger-Beta.jar -d /path/to -o oldWord -n newword</strong> to run the jar</li>
</ol>
<ol>
	<h4>Requirements</h4>
	<li>Java JDK 12 (required)</li>
	<li>Apache MAVEN 3.6.1 (required)</li>
	<li>set JAVA_HOME variable (optional)</li>
	<li>set MAVEN_HOME (optional)</li>
</ol>
