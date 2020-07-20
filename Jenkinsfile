node {
	    // reference to maven
	    // ** NOTE: This 'Maven-OS' Maven tool must be configured in the Jenkins Global Configuration.   
	    def mvnHome = tool 'Maven-OS'
	

	    // holds reference to docker image
	    def dockerImage
	    // ip address of the docker private repository(nexus)
	 
	    def dockerImageTag = "insign${env.BUILD_NUMBER}"
	    
	    stage('Clone Repo') { // for display purposes
	      // Get some code from a GitHub repository
	      git 'https://github.com/purnomo010981/Spring-Boot-Starter.git'
	      // Get the Maven tool.
	      // ** NOTE: This 'Maven-OS' Maven tool must be configured
	      // **       in the global configuration.           
	      mvnHome = tool 'Maven-OS'
	    }    
	  
	    stage('Build Project') {
	      // build project via maven
	      // CentOS
		  // sh "'${mvnHome}/bin/mvn' clean install"
		  // Windows
		  sh "'${mvnHome}/bin/mvn.cmd' -DskipTests=true clean install"
	    }
			
	    stage('Build Docker Image') {
	      // build docker image
	      dockerImage = docker.build("insign:${env.BUILD_NUMBER}")
	    }
	   
	    stage('Deploy Docker Image'){
	      
	      // deploy docker image to nexus
			
	      echo "Docker Image Tag Name: ${dockerImageTag}"
		  try {
				sh "docker.exe stop insign"
			} catch (err) {
			  echo "Container Not Running"
			}
			
			try {
				sh "docker.exe rm insign"
			} catch (err) {
			  echo "Container Not Exist"
			}
			
			try {
				sh "docker.exe run --name insign -d -p 8080:8080 insign:${env.BUILD_NUMBER}"
			} catch (err) {
			  echo "Container Not Running"
			}		  
		  // docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
	      //    dockerImage.push("${env.BUILD_NUMBER}")
	      //      dockerImage.push("latest")
	      //  }
	      
	    }
}