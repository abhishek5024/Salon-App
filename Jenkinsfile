pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "salon-booking-app"
        DOCKER_TAG = "latest"
        REGISTRY = "your-dockerhub-username"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/your-repo/salon-booking-app.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build' // or mvn clean package
            }
        }

        stage('Unit Tests') {
            steps {
                sh './gradlew test' // or mvn test
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-cred', url: '']) {
                    sh "docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${REGISTRY}/${DOCKER_IMAGE}:${DOCKER_TAG}"
                    sh "docker push ${REGISTRY}/${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh "kubectl apply -f k8s/deployment.yaml"
            }
        }
    }

    post {
        success {
            echo 'Deployment Successful!'
        }
        failure {
            echo 'Deployment Failed!'
        }
    }
}
