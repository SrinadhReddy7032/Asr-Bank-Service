pipeline {

    agent any

    tools {
        maven 'Maven'
        jdk 'Java17'
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/SrinadhReddy7032/bank.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Application') {
            steps {
                bat '''
                start cmd /c "java -jar target/demo-0.0.1-SNAPSHOT.jar"
                '''
            }
        }
    }
}
