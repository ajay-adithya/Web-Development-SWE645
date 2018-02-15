Author name: Ajay Adithya Rajagopal

Files Included:
1. .war file containing the survey form.
2. Source files including html and java files.

Set up Instructions:
1. Create home page and survey form using Eclipse dynamic web project.
3. Create a war file using eclipse.
4. Create an instance on EC2 and deploy the file using SCP -i command. 
5. Connect to EC2 giving hostname as Public:DNS and username as 'ubuntu'.
6. Include the private key by choosing the appropriate .pem file. Once the connection is complete drag and drop the .war file in the root folder.
7. The file is copied from home folder to webapps sudo mv 645assign-1.war /home/bitnami/stack/apache-tomcat/webapps.
8. The .war file is uploaded. The other files required are included in the bucket and the permissions are changed.
9. The file is accessed using the following link
  		https://s3.amazonaws.com/ajay645/swe645/HomePage.html
10. The survey page can be accessed using the link 
http://ec2-52-55-187-187.compute-1.amazonaws.com/645assign-2/WelcomePage.xhtml