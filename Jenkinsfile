pipeline {

    agent any

    tools {
        maven 'Maven'
        jdk 'Java17'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Application') {
            steps {
                bat '''
                start cmd /c "java -jar target/Asr-Bank-Service-0.0.1-SNAPSHOT.jar"
                '''
            }
        }
    }
}
