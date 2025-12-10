pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[credentialsId: 'GitHubSShkey', url: 'git@github.com:Rouabna/ConsoleLauncher.git']]]
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
