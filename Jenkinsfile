pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/quyenluu/jenkins-spring-boot-website.git'
            }
        }
    }
}