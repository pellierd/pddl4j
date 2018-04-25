#!groovy

pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
    	stage('Checkout') {
    		steps {
				checkout scm
			}
		}
        stage('Clean') {
            steps {
                sh "./gradlew clean"
            }
        }
        stage('Build') {
            steps {
                sh "./gradlew jar"
                sh "./gradlew javadoc"
            }
        }
        stage('Analyze') {
            steps {
                sh "./gradlew checkstyleMain"
                sh "./gradlew checkstyleTest"
                sh "./gradlew findbugsMain -Pfindbug"
                sh "./gradlew findbugsTest -Pfindbug"
            }
        }
        stage('Test') {
            steps {
                sh "./gradlew test"
            }
        }
        stage('Deploy') {
            steps {
                sh "echo 'Deploying...'"
            }
        }
    }

    post {
        success {
            sh "echo 'Everything run fine :)'
        }
        failure {
            sh "echo 'Build failed :('
        }
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            junit 'build/test-results/test/*.xml'
        }
    }
}