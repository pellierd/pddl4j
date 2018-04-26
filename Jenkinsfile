#!groovy

pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
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
                checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'build/reports/checkstyle/*.xml', unHealthy: ''
                sh "./gradlew findbugsMain -Pfindbug"
                sh "./gradlew findbugsTest -Pfindbug"
            }
        }
        stage('Test') {
            steps {
                sh "./gradlew test"
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
        }
        always {
            archiveArtifacts artifacts: 'build/test-results/test/binary/output.bin'

            junit 'build/test-results/test/*.xml'
        }
    }
}