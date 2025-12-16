pipeline {
    agent any

    environment {
        IMAGE_NAME = "rouabna/consolelauncher"
        IMAGE_TAG  = "latest"
    }

    stages {

        stage('Checkout') {
            steps {
                cleanWs()
                checkout scm
            }
        }

        stage('Build Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Push Docker Image') {
            withCredentials([string(credentialsId: 'dockerhub_token', variable: 'DOCKER_TOKEN')]) {
                sh '''
                    echo $DOCKER_TOKEN | docker login -u rouabna --password-stdin
                    docker push ${IMAGE_NAME}:${IMAGE_TAG}
                '''
            }
        }

        stage('Run Container') {
            steps {
                // Stop & remove old container if exists
                sh '''
                    if [ $(docker ps -a -q -f name=consolelauncher) ]; then
                        docker rm -f consolelauncher
                    fi
                    docker run -d -p 8080:80 --name consolelauncher ${IMAGE_NAME}:${IMAGE_TAG}
                '''
            }
        }
    }
}
