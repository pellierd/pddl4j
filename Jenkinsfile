pipeline {
    agent any

    stages {
    	stage('Checkout') {
    		steps {
				checkout scm
			}
		}
        stage('Clean') {
            steps {
                sh "echo 'Cleanning...'"
                sh "./gradlew clean"
            }
        }
        stage('Build') {
            steps {
                sh "echo 'Building...'"
                sh "./gradlew jar"
                sh "./gradlew javadoc"
            }
        }
        stage('Analyze') {
            steps {
                sh "echo 'Analyzing...'"
                sh "./gradlew checkstyleMain"
                sh "./gradlew checkstyleTest"
                sh "./gradlew findbugsMain -Pfindbug"
                sh "./gradlew findbugsTest -Pfindbug"
            }
        }
        stage('Test') {
            steps {
                sh "echo 'Testing...'"
                sh "./gradlew test"
            }
        }
        stage('Deploy') {
            steps {
                sh "echo 'Deploying...'"
            }
        }
    }
}