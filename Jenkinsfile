pipeline {
    agent any

    stages {
        stage('Checkout Codebase') {
            steps {
                // Récupération du code depuis GitHub
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
                echo 'Building project...'
                // Création du dossier lib pour les dépendances
                sh 'mkdir -p lib target'
                // Téléchargement de JUnit
                sh 'curl -L -o lib/junit-platform-console-standalone-1.8.1.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar'
                // Compilation des tests Java (à adapter selon ton projet)
                sh 'javac -d target -cp lib/junit-platform-console-standalone-1.8.1.jar src/test/java/*.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Exécution des tests
                sh 'java -jar lib/junit-platform-console-standalone-1.8.1.jar -cp target -c FirstUnitTest'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying project...'
                // Exemple : copier les fichiers compilés dans target/ pour déploiement
                sh 'cp -r target/* deploy/'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}

