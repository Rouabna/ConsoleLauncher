pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                cleanWs() // Clean workspace before build
                checkout scm: [$class: 'GitSCM',
                               userRemoteConfigs: [[credentialsId: 'GitHubSShkey',
                                                    url: 'git@github.com:Rouabna/ConsoleLauncher.git']]]
            }
        }
        stage('Build') {
            steps {
                echo 'Building project...'
                // Create directories
                sh 'mkdir -p lib target'
                // Download JUnit standalone JAR
                sh 'curl -L -o lib/junit-platform-console-standalone-1.8.1.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar'
                // Compile Java test
                sh 'javac -d target -cp lib/junit-platform-console-standalone-1.8.1.jar src/test/java/FirstUnitTest.java'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Run JUnit test
                sh 'java -jar lib/junit-platform-console-standalone-1.8.1.jar -cp target -c FirstUnitTest'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add deployment commands if needed
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
