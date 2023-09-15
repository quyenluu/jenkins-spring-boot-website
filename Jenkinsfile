pipeline {
    agent any
    tools {
        maven 'maven-3.9.4'
    }
    environment{
        SONARQUBE_HOME= tool 'SonarQube-Scanner'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/quyenluu/jenkins-spring-boot-website.git'
            }
        }
        stage('Compile') {
            steps {
                sh "mvn clean compile -DskipTests=true"
            }
        }
        stage('OWASP Scan') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ ', odcInstallation: 'Dependency-Check'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage('SonarQube Sccan') {
            steps {
                withSonarQubeEnv('SonarQube-Server'){
                   sh ''' $SONARQUBE_HOME/bin/sonar-scanner -Dsonar.projectName=Spring-Boot-Website \
                   -Dsonar.java.binaries=. \
                   -Dsonar.projectKey=Spring-Boot-Website '''
               }
            }
        }
        stage("SonarQube Sccan Result") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                }
            }
        }
    }
}
