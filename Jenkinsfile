pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: 'main']],
                          userRemoteConfigs: [[
                              url: 'git@github.com:Rouabna/ConsoleLauncher.git',
                              credentialsId: 'GitHubSShkey'
                          ]]
                ])
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

