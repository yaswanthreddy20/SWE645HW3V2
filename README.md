Backend: http://35.202.102.15:8080/surveys
•	We have used Spring boot to develop the backend API services.
•	We developed GET, and POST APIs to list the filled surveys and submit a new survey.
•	In Amazon RDS, we created a Database and used its endpoint in the properties file inside the spring boot application as below:





•	We have segregated the project into different components:
o	We used a controller to interact with the front end. 
o	To interact with the RDS, we used the repository.
o	The remaining components such as service and entity are used internally in the spring boot application.
•	We created a multi-stage docker file to build the image and push it to the registry.
•	We have created a deployment YAML file to create PODS within the Kubernetes cluster. Also, we have created a service YAML file that acts as a load balancer and exposes the backend service.
Frontend: http://34.121.35.110/
•	We have used Angular JS to develop the frontend service.
•	This service enables users to fill out new surveys and list all the old ones.
•	We have segregated the project into different components:
o	We used a home component to display a message to select an option from the navbar.
o	The Survey list component is used to retrieve the filled surveys from the backend API and show them on the frontend.
o	The create survey component is used to send the filled form to the backend POST API and save it in the Amazon RDS.
o	We have used a routing module to route the URL between these components.
•	Frontend communicates with the backend APIs via the exposed backend service which is configured in the survey.service.ts file as below:



•	The remaining components are used internally in the angular application.
•	We created a multi-stage docker file to build the image and push it to the registry.
•	We have created a deployment YAML file to create PODS within the Kubernetes cluster. Also, we have created a service YAML file that acts as a load balancer and exposes the frontend service.
Deployment:
•	We used Google Container Registry and Google Kubernetes Engine (GKE) to containerize and deploy both the backend and frontend services.
•	Deployment is done in three phases:
1.	Dockerfile: This file is used to build a docker image. This is done in a multistage so that it does not expose the source code. Instead, it uses the files that are generated from the build phase.
2.	Deployment.yaml: This file contains the required information about replicas and the image used for deployment along with the metadata of the application. 
3.	Service.yaml: It is used to expose the above-mentioned deployment to the outside world and acts as a load balancer for this deployment.
Steps to Replicate:
•	Clone the repository using the below command:
o	git clone https://github.com/yaswanthreddy20/SWE645HW3V2.git
•	Now, to build and push the docker images to the container registry please use the below commands:





•	To connect to the Kubernetes cluster, use the below command:



•	Now, to deploy the application change the image name (if required) in the YAML files and use the below commands:







•	Validate the above deployment using the command “kubectl get svc“. This gives us a result something like below:
 
•	From the above image, use the external IP and port to access the frontend and backend services. In this example, the URLs would look like this:
Frontend: http://34.121.35.110:80
Backend: http://35.202.102.15:8080/surveys
Lessons Learned:
1.	Cross-origins:
•	Initially, we were not able to display the results that are fetched by the backend API from the RDS on the frontend.
•	We saw in the browser console that the cross-origin access is causing the issue and We have figured out that we need to use the annotation @CrossOrigin(origins = "*") just above the backend service endpoints in the controller.
2.	spring.jpa.hibernate.ddl-auto:
•	we were losing the old, saved data once the service is restarted.
•	we figured that this property in the application.properties of the springboot application is causing the issue.
•	If this property is set to create every time the service is stopped, the data saved so far is getting truncated
•	If this property is set to update the data doesn’t truncate even though you stop the service and restart later.
3.	Date Format:
•	The date datatype in java is storing the time as 00:00:00 alongside the date.
•	But our requirement is only to display the date of the survey. we need to format the date object to the MM/DD/YYYY format to meet the requirement.
4.	Lombok:
•	It is a java library used to automatically generate the getters and setters in the spring boot application.
•	We tried using this library but somehow, we were not able to get the required data. Need to explore why this issue happened.
•	To overcome this we generated the getters and setters from the eclipse itself.
Further Scope:
•	Instead of hardcoding the baseurl and RDS URL, we should look forward to reading those from the environment variables.
