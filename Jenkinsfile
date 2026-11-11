
pipeline {
    agent any

    stages {
        
        stage('Docker Check') {
            steps {
                bat '''
                    echo Checking Docker
                    where docker
                    docker --version
                    docker ps
                '''
            }
        }
        stage('Git Checkout') {
            steps {
                echo 'Getting latest source code'
                checkout scm
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t gym-management-system:%BUILD_NUMBER% .'
            }
        }

        stage('Stop Old Container') {
            steps {
                script {
                    bat(returnStatus: true,
                        script: 'docker rm -f admission-website')
                }
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker run -d --name gym-management-system -p 8081:80 gym-management-system:%BUILD_NUMBER%'
            }
        }

    }
}
