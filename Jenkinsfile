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
                withSonarQubeEnv('SonarQube-Server') {
                    sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Spring-Boot-Website \
                       -Dsonar.java.binaries=. \
                       -Dsonar.projectKey=Spring-Boot-Website '''
                }
            }
        }
    }
}
