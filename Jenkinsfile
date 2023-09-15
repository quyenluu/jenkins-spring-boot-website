pipeline {
    agent any
    environment{
        SONARQUBE_HOME= tool 'SonarQube-Scanner'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/quyenluu/jenkins-spring-boot-website.git'
            }
        }
        stage('SonarQube Sccan') {
            steps {
                withSonarQubeEnv('SonarQube-Server'){
                   sh ''' $SONARQUBE_HOME/bin/sonar-scanner -Dsonar.projectName=Shopping-Cart \
                   -Dsonar.java.binaries=. \
                   -Dsonar.projectKey=Shopping-Cart '''
               }
            }
        }
    }
}
