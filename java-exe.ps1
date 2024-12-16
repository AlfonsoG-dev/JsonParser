$srcClases = ".\src\*.java .\src\Application\Operations\*.java .\src\Application\Utils\*.java "
$libFiles = ""
$compile = "javac -Werror -Xlint:all -d .\bin\ $srcClases"
$createJar = "jar -cfm JsonParser.jar Manifesto.txt -C .\bin\ ."
$javaCommand = "java -jar JsonParser.jar"
$runCommand = "$compile" + " && " + "$createJar" + " && " +"$javaCommand"
Invoke-Expression $runCommand 
