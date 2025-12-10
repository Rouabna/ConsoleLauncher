pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                cleanWs()
                checkout scm: [$class: 'GitSCM', 
                               userRemoteConfigs: [[credentialsId: 'GitHubSShkey', 
                                                    url: 'git@github.com:Rouabna/ConsoleLauncher.git']]]
            }
        }
        stage('Build') {
            steps {
                echo 'Building project...'
                // Création des dossiers
                sh 'mkdir -p lib target'
                // Téléchargement de JUnit
                sh 'curl -L -o lib/junit-platform-console-standalone-1.8.1.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar'
                // Compilation du fichier Java de test
                sh 'javac -d target -cp lib/junit-platform-console-standalone-1.8.1.jar src/test/java/FirstUnitTest.java'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'java -jar lib/junit-platform-console-standalone-1.8.1.jar -cp target -c FirstUnitTest'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}

