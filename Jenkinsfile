pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                echo 'Cleanning...'
                ./gradlew clean
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                ./gradlew jar
                ./gradlew javadoc
            }
        }
        stage('Analyze') {
            steps {
                echo 'Analyzing...'
                ./gradlew checkstyleMain
                ./gradlew checkstyleTest
                ./gradlew findbugsMain -Pfindbug
                ./gradlew findbugsTest -Pfindbug
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                ./gradlew test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}