# unix-sort.
Unix lexicographic sort. Developed with java and red-black Trees as data structure to sort in O(log(n)) time. 

With proprietary implementations of data structures, which meet the complexity in time and space.

## Prerequisites.
**_The program makes use of the MAVEN 3.8.6 or higher packager._**

* Linux.
```sh
  https://maven.apache.org/download.cgi
```
1. Clone the repository.
```sh
   git clone https://github.com/richardfm77/unix-sort.git
```
```sh
   cd unix-sort/proyecto1
```

2. Compile.
```sh
   mvn compile
```

3. Run tests.

**It is necessary to keep the txt files for the tests to work correctly.**

```sh
   mvn test
```

## Start program.

* Installation of the files **.jar**.
```sh
   mvn install
```

* Execution for reading unix standard input.
```sh
   java -jar target/proyecto1
```

* Execution for reading one or more files.
```sh
   java -jar target/proyecto1 [file1] [file2] ...
```

## Flags.

* The flag **-o** allows you to redirect the standard output to a file.

It is used with the parameter **-o** followed by the directory and name of the output file.

*Warning:* the operation is destructive and it is understood that the user knows what he is doing.

For example:
```sh
   java -jar target/proyecto1 [file1] -o [fileOutput]
```

* The flag **-r** allows the output to be displayed in reverse.

It is used with the parameter **-r**.

For example:
```sh
   java -jar target/proyecto1 [file1] -r
```

**Flags can go anywhere in the parameters, and can be used and adapted as required.**
