# al-lunch-group

1. Download the Project by doing "git clone https://github.com/aravindan-bk/al-lunch-group.git"
2. Step into the root folder of the project. If your download location is, "/opt/myprojects/al-lunch-group"
   Type "cd /opt/myprojects/al-lunch-group" on terminal

3. You will find a sample-input.txt file in "al-lunch-group/src/main/resources" folder.
   Replace each line with your employee names and save the file to a convenient location
   example: "/user/aravindan/Desktop/employees.txt"

4. Copy the file "al-lunch-group/src/main/resources/app.properties" to a convenient location like, "/user/aravindan/Desktop/app.properties"
5. Change the content of the file as follows:
    employee.list.file=/user/aravindan/Desktop/employees.txt
    Note: This is the location where you have saved the employees.txt file

    group.file.output.folder=/Users/arthulas/Desktop
    Note: This should be a valid folder where you want to create the output.

    Save the file once you have made the changes.


6. Now, build the code as follows: "mvn clean package"

7. Execute the project as follows:
"java -jar target/lunch-group-selector-1.0-SNAPSHOT.jar /user/aravindan/Desktop/app.properties"
 Note: Here the app.properties location should point to where you have saved it in step 4.
